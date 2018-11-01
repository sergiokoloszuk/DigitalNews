package br.com.digitalnews.digitalnews.data.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import br.com.digitalnews.digitalnews.interfaces.ArticleDAO;
import br.com.digitalnews.digitalnews.model.Article;

@android.arch.persistence.room.Database(entities = {Article.class}, version = 1)
public abstract class Database extends RoomDatabase{

    public abstract ArticleDAO getArticleDAO();

    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "digitalnews_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
