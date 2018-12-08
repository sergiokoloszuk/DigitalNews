package br.com.digitalnews.digitalnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.explore.model.ExploreSource;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;

public class CompleteArticleActivity extends AppCompatActivity {

    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewText;
    private TextView textFonte;
    private TextView textData;
    private TextView textJornalista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_article);


        initViews();

        TopHeadlinesArticle article = getIntent().getParcelableExtra("ARTICLE");
        Toast.makeText(this, article.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        imageViewPoster = findViewById(R.id.ic_notifications);
        textViewTitle = findViewById(R.id.tv_manchete);
        textViewText = findViewById(R.id.tv_corpo_da_noticia);
        textData = findViewById(R.id.tv_data_da_noticia);
        textFonte = findViewById(R.id.tv_fonte);
        textData = findViewById(R.id.tv_jornalista);
    }
}
