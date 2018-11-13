package br.com.digitalnews.digitalnews.data.network;

import br.com.digitalnews.digitalnews.explorer.model.CategoryResponse;
import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface API {
    @GET("v2/sources")
    Observable<CategoryResponse> getCategory(@Query("apiKey") String apiKey);

    @GET("v2/everything")
    Observable<Article> getArticle(@Query("q") String query, @Query("apiKey") String apiKey);
}
