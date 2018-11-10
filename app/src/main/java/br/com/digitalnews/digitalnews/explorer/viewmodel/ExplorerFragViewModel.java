package br.com.digitalnews.digitalnews.explorer.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalnews.digitalnews.model.Article;
import br.com.digitalnews.digitalnews.model.Source;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalnews.digitalnews.data.network.RetrofitService.getApiService;

public class ExplorerFragViewModel extends AndroidViewModel{


    public ExplorerFragViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Article>> articleLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> articleLiveDataError = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public void getCategories( ){

    }
}
