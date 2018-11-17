package br.com.digitalnews.digitalnews.explorer.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.disposables.CompositeDisposable;

public class ExplorerFragViewModel extends AndroidViewModel{


    public ExplorerFragViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Article>> articleLiveData = new MutableLiveData<>();
    MutableLiveData<List<POJO>>();

    MutableLiveData<Throwable> articleLiveDataError = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    

    public void getCategories( ){

    }
}
