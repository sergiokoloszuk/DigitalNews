
package br.com.digitalnews.digitalnews.model;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;


public class News {

    @Expose
    private List<Article> articles;
    @Expose
    private String status;
    @Expose
    private Long totalResults;


    @PrimaryKey
    private Long id;



    public List<Article> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public static class Builder {

        private List<Article> articles;
        private String status;
        private Long totalResults;

        public News.Builder withArticles(List<Article> articles) {
            this.articles = articles;
            return this;
        }

        public News.Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public News.Builder withTotalResults(Long totalResults) {
            this.totalResults = totalResults;
            return this;
        }

        public News build() {
            News news = new News();
            news.articles = articles;
            news.status = status;
            news.totalResults = totalResults;
            return news;
        }

    }

}
