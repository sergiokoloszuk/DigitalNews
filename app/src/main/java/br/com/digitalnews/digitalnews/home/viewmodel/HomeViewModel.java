package br.com.digitalnews.digitalnews.home.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalnews.digitalnews.data.local.database.NewsDatabase;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesResponse;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalnews.digitalnews.data.network.RetrofitService.API_KEY;
import static br.com.digitalnews.digitalnews.data.network.RetrofitService.getApiService;
import static br.com.digitalnews.digitalnews.util.AppUtil.isNetworkConnected;

public class HomeViewModel extends AndroidViewModel {


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<TopHeadlinesArticle>> TopHeadLinesArticlesLiveData = new MutableLiveData<>();
    public MutableLiveData<List<TopHeadlinesSource>> topHeadlinesSourceLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> liveDataError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public void getArticles() {

        if (isNetworkConnected(getApplication())) {
            disposable.add(
                    getApiService().getTopHeadlines("br", API_KEY)
                            .map(new Function<TopHeadlinesResponse, TopHeadlinesResponse>() {
                                @Override
                                public TopHeadlinesResponse apply(TopHeadlinesResponse response) throws Exception {
                                    return saveArticles(response);
                                }
                            })
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe(new Consumer<Disposable>() {
                                @Override
                                public void accept(Disposable disposable) throws Exception {
                                    isLoading.setValue(true);
                                }
                            })
                            .doOnTerminate(new Action() {
                                @Override
                                public void run() throws Exception {
                                    isLoading.setValue(false);
                                }
                            })
                            .subscribe(new Consumer<TopHeadlinesResponse>() {
                                @Override
                                public void accept(TopHeadlinesResponse response) throws Exception {
                                    TopHeadLinesArticlesLiveData.setValue(response.getTopHeadlinesArticles());
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.i("LOG", "Error: " + throwable.getMessage());
                                }
                            })
            );
        } else {
            disposable.add(
                    NewsDatabase.getDatabase(getApplication()).getTopHeadlineArticleDAO().getAll()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<List<TopHeadlinesArticle>>() {
                                @Override
                                public void accept(List<TopHeadlinesArticle> articleList) throws Exception {
                                    TopHeadLinesArticlesLiveData.setValue(articleList);
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.i("LOG", "Error: " + throwable.getMessage());
                                }
                            })
            );
        }

    }

    public void getArticlesCategory(String category) {
        disposable.add(
                getApiService().getTopHeadlinesByCategory(category, API_KEY)
                        .map(new Function<TopHeadlinesResponse, TopHeadlinesResponse>() {
                            @Override
                            public TopHeadlinesResponse apply(TopHeadlinesResponse response) throws Exception {
                                return saveArticles(response);
                            }
                        })
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                isLoading.setValue(true);
                            }
                        })
                        .doOnTerminate(new Action() {
                            @Override
                            public void run() throws Exception {
                                isLoading.setValue(false);
                            }
                        })
                        .subscribe(new Consumer<TopHeadlinesResponse>() {
                            @Override
                            public void accept(TopHeadlinesResponse response) throws Exception {
                                TopHeadLinesArticlesLiveData.setValue(response.getTopHeadlinesArticles());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.i("LOG", "Error: " + throwable.getMessage());
                            }
                        })
        );
    }

    private TopHeadlinesResponse saveArticles(TopHeadlinesResponse response) {
        NewsDatabase.getDatabase(getApplication()).getTopHeadlineArticleDAO().insert(response.getTopHeadlinesArticles());
        return response;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
