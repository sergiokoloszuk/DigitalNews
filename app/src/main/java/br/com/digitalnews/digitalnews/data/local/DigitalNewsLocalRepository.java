package br.com.digitalnews.digitalnews.data.local;

import android.content.Context;

import java.util.List;

import br.com.digitalnews.digitalnews.data.local.dao.ArticleDAO;
import br.com.digitalnews.digitalnews.data.local.database.NewsDatabase;
import br.com.digitalnews.digitalnews.model.Article;
import io.reactivex.Flowable;

public class DigitalNewsLocalRepository {
    public Flowable<List<Article>> getLocalArticles(Context context) {
        NewsDatabase room = NewsDatabase.getDatabase(context);
        ArticleDAO articleDAO = (ArticleDAO) room.getArticleDAO();
        return articleDAO.getAll();
    }

    public void insertItems(Context context, List<Article> items) {
        NewsDatabase room = NewsDatabase.getDatabase(context);
        ArticleDAO articleDAO = (ArticleDAO) room.getArticleDAO();
        articleDAO.insert(items);
    }
}
