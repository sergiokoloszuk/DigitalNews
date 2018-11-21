
package br.com.digitalnews.digitalnews.home.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopHeadlinesResponse {

    @Expose
    @SerializedName("articles")
    private List<TopHeadlinesArticle> topHeadlinesArticles;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("totalResults")
    private Long totalResults;

    public List<TopHeadlinesArticle> getTopHeadlinesArticles() {
        return topHeadlinesArticles;
    }

    public void setTopHeadlinesArticles(List<TopHeadlinesArticle> topHeadlinesArticles) {
        this.topHeadlinesArticles = topHeadlinesArticles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

}
