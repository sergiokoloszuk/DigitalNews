
package br.com.digitalnews.digitalnews.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "articles")
public class Article {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "author")
    @Expose
    private String author;

    @ColumnInfo(name = "content")
    @Expose
    private String content;

    @ColumnInfo(name = "description")
    @Expose
    private String description;

    @ColumnInfo(name = "publishedAt")
    @Expose
    private String publishedAt;

    @ColumnInfo(name = "source")
    @Expose
    private Source source;

    @ColumnInfo(name = "title")
    @Expose
    private String title;

    @ColumnInfo(name = "url")
    @Expose
    private String url;

    @ColumnInfo(name = "urlToImage")
    @Expose
    private String urlToImage;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

}
