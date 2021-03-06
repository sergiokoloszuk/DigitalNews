package br.com.digitalnews.digitalnews.data.local.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.digitalnews.digitalnews.data.local.dao.ArticleDAO;
import br.com.digitalnews.digitalnews.model.Article;

@android.arch.persistence.room.Database(entities = {Article.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class NewsDatabase extends RoomDatabase{

    public abstract ArticleDAO getArticleDAO();

    private static volatile NewsDatabase INSTANCE;

    public static NewsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NewsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "digital_news_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
