package br.com.digitalnews.digitalnews.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;

    @Dao
    interface NewsDAO {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Article article);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(List<Article> articles);

        @Update
        void update(News news);

        @Delete
        void delete(News news);

        @Query("Select * from nome limit 30")
        Flowable<List<Article>> getAll();

        @Query("Select * from nome where id = :id")
        News getById(long id);
    }


