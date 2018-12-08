
package br.com.digitalnews.digitalnews.home.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "TopHeadlinesArticles")
public class TopHeadlinesArticle implements Parcelable{

    // id criado localmente
    @Expose
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @Expose
    private String author;

    @Expose
    private String content;

    @Expose
    private String description;

    @Expose
    private String publishedAt;

    @Expose
    @SerializedName("source")
    private TopHeadlinesSource source;

    @Expose
    private String title;

    @Expose
    private String url;

    @Expose
    private String urlToImage;

    public TopHeadlinesArticle() {
    }

    protected TopHeadlinesArticle(Parcel in) {
        id = in.readLong();
        author = in.readString();
        content = in.readString();
        description = in.readString();
        publishedAt = in.readString();
        title = in.readString();
        url = in.readString();
        urlToImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(author);
        dest.writeString(content);
        dest.writeString(description);
        dest.writeString(publishedAt);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(urlToImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TopHeadlinesArticle> CREATOR = new Creator<TopHeadlinesArticle>() {
        @Override
        public TopHeadlinesArticle createFromParcel(Parcel in) {
            return new TopHeadlinesArticle(in);
        }

        @Override
        public TopHeadlinesArticle[] newArray(int size) {
            return new TopHeadlinesArticle[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public TopHeadlinesSource getSource() {
        return source;
    }

    public void setSource(TopHeadlinesSource source) {
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
