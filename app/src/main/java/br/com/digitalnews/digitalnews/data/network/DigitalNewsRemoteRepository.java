package br.com.digitalnews.digitalnews.data.network;

import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Observable;

public class DigitalNewsRemoteRepository {

    public Observable<Article> searchItems(String item) {
        return RetrofitService.getApiService().searchItem(item);
    }
}
