package br.com.digitalnews.digitalnews.data.local.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.digitalnews.digitalnews.data.local.dao.ExploreSourceDAO;
import br.com.digitalnews.digitalnews.data.local.dao.TopHeadlineArticleDAO;
import br.com.digitalnews.digitalnews.data.local.dao.TopHeadlineSourceDAO;
import br.com.digitalnews.digitalnews.explore.model.ExploreSource;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesSource;


@android.arch.persistence.room.Database(entities = {ExploreSource.class, TopHeadlinesArticle.class, TopHeadlinesSource.class}, version = 4, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class NewsDatabase extends RoomDatabase{

    public abstract ExploreSourceDAO getSourceDAO();
    public abstract TopHeadlineArticleDAO getTopHeadlineArticleDAO();
    public abstract TopHeadlineSourceDAO getTopHeadlineSourceDAO();


    private static volatile NewsDatabase INSTANCE;

    public static NewsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NewsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "digital_news_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
