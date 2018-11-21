
package br.com.digitalnews.digitalnews.home.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;

@Entity(tableName = "topHeadlinesSources")
public class TopHeadlinesSource {

    @Expose
    @PrimaryKey
    @NonNull
    private String id;

    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
