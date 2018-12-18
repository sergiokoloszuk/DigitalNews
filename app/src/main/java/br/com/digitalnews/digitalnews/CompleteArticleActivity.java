package br.com.digitalnews.digitalnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        TopHeadlinesArticle article = getIntent().getParcelableExtra("ARTICLE");

        initViews();

        if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
            Picasso.get().load(article.getUrlToImage()).into(imageViewPoster);
        } else {
            imageViewPoster.setImageResource(R.drawable.digital_news);
        }

        textViewTitle.setText(article.getTitle());
        textViewText.setText(article.getContent());

        if (article.getSource() != null && article.getSource().getName() != null) {
            textFonte.setText(article.getSource().getName());
            textJornalista.setText(article.getAuthor());
        }


    }

    private void initViews() {
        imageViewPoster = findViewById(R.id.ic_notifications);
        textViewTitle = findViewById(R.id.tv_manchete);
        textViewText = findViewById(R.id.tv_corpo_da_noticia);
        //textData = findViewById(R.id.tv_data_da_noticia);
        //textFonte = findViewById(R.id.tv_fonte);
        //textJornalista = findViewById(R.id.tv_jornalista);
    }
}
