package br.com.digitalnews.digitalnews.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalnews.digitalnews.home.model.TopHeadlinesSource;
import io.reactivex.Flowable;


@Dao
public interface TopHeadlineSourceDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TopHeadlinesSource topHeadlinesSource);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TopHeadlinesSource> topHeadlinesSources);

    @Update
    void update(TopHeadlinesSource topHeadlinesSource);

    @Delete
    void delete(TopHeadlinesSource topHeadlinesSource);

    @Query("Select * from topHeadlinesSources limit 30")
    Flowable<List<TopHeadlinesSource>> getAll();

    @Query("Select * from topHeadlinesSources where id = :id")
    TopHeadlinesSource getById(long id);
}
