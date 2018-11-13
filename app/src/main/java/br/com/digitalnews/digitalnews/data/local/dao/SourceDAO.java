package br.com.digitalnews.digitalnews.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalnews.digitalnews.explorer.model.Source;
import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Flowable;

@Dao
public interface SourceDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Source source);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Source> sources);

    @Update
    void update(Source source);

    @Delete
    void delete(Source source);

    @Query("Select * from sources limit 30")
    Flowable<List<Source>> getAll();

    @Query("Select * from sources where id = :id")
    Source getById(long id);
}
