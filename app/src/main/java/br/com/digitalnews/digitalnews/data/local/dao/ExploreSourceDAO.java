package br.com.digitalnews.digitalnews.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalnews.digitalnews.explore.model.ExploreSource;
import io.reactivex.Flowable;

@Dao
public interface ExploreSourceDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ExploreSource exploreSource);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ExploreSource> exploreSources);

    @Update
    void update(ExploreSource exploreSource);

    @Delete
    void delete(ExploreSource exploreSource);

    @Query("Select * from exploreSources limit 30")
    Flowable<List<ExploreSource>> getAll();

    @Query("Select * from exploreSources where id = :id")
    ExploreSource getById(long id);
}
