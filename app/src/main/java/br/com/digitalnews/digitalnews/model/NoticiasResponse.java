
package br.com.digitalnews.digitalnews.model;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity (tableName = "Nome")

public class NoticiasResponse {

    @Expose
    @SerializedName("articles")
    private List<Article> articles;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("totalResults")
    private Long totalResults;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
