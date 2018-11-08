package br.com.digitalnews.digitalnews.interfaces;

import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Observable;
import retrofit2.http.GET;


public interface API {
// voltar aqui e consertar
    @GET("")
    Observable<Article> searchItem(@Query("q") String item);
}
}
