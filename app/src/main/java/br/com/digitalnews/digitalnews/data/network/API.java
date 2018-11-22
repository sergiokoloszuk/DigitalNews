package br.com.digitalnews.digitalnews.data.network;

import br.com.digitalnews.digitalnews.explore.model.CategoryResponse;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface API {
    @GET("v2/sources")
    Observable<CategoryResponse> getCategories(@Query("apiKey") String apiKey);

    // @GET("v2/everything")
    // TODO checar se este Observable usará o mesmo TopHeadlinesArticle que Top Headlines
    // Observable<TopHeadlinesArticle> getTopHeadlinesArticles(@Query("q") String query, @Query("apiKey") String apiKey);

    @GET("v2/top-headlines")
    Observable<TopHeadlinesResponse> getTopHeadlines(@Query("country") String country,
                                                     @Query("apiKey") String apiKey);
}
