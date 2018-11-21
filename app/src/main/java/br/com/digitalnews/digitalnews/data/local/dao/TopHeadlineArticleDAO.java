package br.com.digitalnews.digitalnews.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;
import io.reactivex.Flowable;

@Dao
public interface TopHeadlineArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TopHeadlinesArticle article);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TopHeadlinesArticle> topHeadlinesArticles);

    @Update
    void update(TopHeadlinesArticle article);

    @Delete
    void delete(TopHeadlinesArticle article);

    @Query("Select * from TopHeadlinesArticles limit 30")
    Flowable<List<TopHeadlinesArticle>> getAll();

    @Query("Select * from TopHeadlinesArticles where id = :id")
    TopHeadlinesArticle getById(long id);
}
