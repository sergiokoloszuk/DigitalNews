package br.com.digitalnews.digitalnews.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.disposables.CompositeDisposable;

import static br.com.digitalnews.digitalnews.util.AppUtil.isNetworkConnected;

public class DigitalNewsViewModel extends AndroidViewModel{

    public MutableLiveData<List<Article>> articleLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> articlesLiveDataError = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public DigitalNewsViewModel(@NonNull Application application) {
        super(application);
    }

    public void getArticles(){
    }


}