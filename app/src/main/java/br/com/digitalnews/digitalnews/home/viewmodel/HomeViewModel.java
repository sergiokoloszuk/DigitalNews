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
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalnews.digitalnews.data.network.RetrofitService.API_KEY;
import static br.com.digitalnews.digitalnews.data.network.RetrofitService.getApiService;
import static br.com.digitalnews.digitalnews.util.AppUtil.isNetworkConnected;

public class HomeViewModel extends AndroidViewModel{


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData topHeadlinesArticleLiveData = new MutableLiveData<>();
    public MutableLiveData<List<TopHeadlinesSource>> topHeadlinesSourceLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> liveDataError = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public void getArticles(){

        if(isNetworkConnected(getApplication())){
            disposable.add(
                    getApiService().getTopHeadlines("brazil", API_KEY)
                            .map(new Function<TopHeadlinesResponse, TopHeadlinesResponse>() {
                                @Override
                                public TopHeadlinesResponse apply(TopHeadlinesResponse response) throws Exception {
                                    return saveResponse(response);
                                }
                            })
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<TopHeadlinesResponse>() {
                                @Override
                                public void accept(TopHeadlinesResponse response) throws Exception {
                                    topHeadlinesArticleLiveData.setValue(response.getTopHeadlinesArticles());
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
                                public void accept(List<TopHeadlinesArticle> topHeadlinesArticles) throws Exception {
                                    topHeadlinesArticleLiveData.setValue(topHeadlinesArticles);
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

    private TopHeadlinesResponse saveResponse(TopHeadlinesResponse response) {
        NewsDatabase.getDatabase(getApplication()).getTopHeadlineArticleDAO().insert(response.getTopHeadlinesArticles());
        return response;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
