package br.com.digitalnews.digitalnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.explore.model.ExploreSource;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;

public class CompleteArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_article);

        TopHeadlinesArticle article = getIntent().getParcelableExtra("ARTICLE");
        Toast.makeText(this, article.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
