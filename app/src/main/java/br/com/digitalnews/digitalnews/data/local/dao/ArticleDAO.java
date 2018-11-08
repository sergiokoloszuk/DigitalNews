package br.com.digitalnews.digitalnews.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Flowable;

@Dao
public interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Article> articles);

    @Update
    void update(Article article);

    @Delete
    void delete(Article article);

    @Query("Select * from articles limit 30")
    Flowable<List<Article>> getAll();

    @Query("Select * from articles where id = :id")
    Article getById(long id);
}
