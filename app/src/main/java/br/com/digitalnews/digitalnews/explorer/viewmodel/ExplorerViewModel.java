package br.com.digitalnews.digitalnews.explorer.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalnews.digitalnews.data.local.database.NewsDatabase;
import br.com.digitalnews.digitalnews.explorer.model.CategoryResponse;
import br.com.digitalnews.digitalnews.explorer.model.ExploreSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalnews.digitalnews.data.network.RetrofitService.API_KEY;
import static br.com.digitalnews.digitalnews.data.network.RetrofitService.getApiService;
import static br.com.digitalnews.digitalnews.util.AppUtil.isNetworkConnected;

public class ExplorerViewModel extends AndroidViewModel{


    public ExplorerViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<ExploreSource>> categoryLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> gategoryLiveDataError = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public void getCategories(){

        if(isNetworkConnected(getApplication())){
            disposable.add(
                    getApiService().getCategories(API_KEY)
                            .map(new Function<CategoryResponse, CategoryResponse>() {
                                @Override
                                public CategoryResponse apply(CategoryResponse response) throws Exception {
                                    return saveCategories(response);
                                }
                            })
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<CategoryResponse>() {
                                @Override
                                public void accept(CategoryResponse response) throws Exception {
                                    categoryLiveData.setValue(response.getExploreSources());
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
                    NewsDatabase.getDatabase(getApplication()).getSourceDAO().getAll()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<List<ExploreSource>>() {
                                @Override
                                public void accept(List<ExploreSource> exploreSources) throws Exception {
                                    categoryLiveData.setValue(exploreSources);
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

    private CategoryResponse saveCategories(CategoryResponse response) {
        NewsDatabase.getDatabase(getApplication()).getSourceDAO().insert(response.getExploreSources());
        return response;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
