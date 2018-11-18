package br.com.digitalnews.digitalnews.data.network;

import br.com.digitalnews.digitalnews.explorer.model.CategoryResponse;
import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface API {
    @GET("v2/sources")
    Observable<CategoryResponse> getCategories(@Query("apiKey") String apiKey);

    @GET("v2/everything")
    Observable<Article> getArticles(@Query("q") String query, @Query("apiKey") String apiKey);

    @GET("v2/top-headlines")
    Observable<Article> getendpoint (@Query("q") String query,@Query("country")String country,
                                     @Query("apikey")String apikey );

    Observable<Article> searchItem(String item);
}
