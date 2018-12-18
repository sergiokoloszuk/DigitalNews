package br.com.digitalnews.digitalnews;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.adapters.HomeRecyclerViewAdapter;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;
import br.com.digitalnews.digitalnews.home.viewmodel.HomeViewModel;

public class ArticlesActivity extends AppCompatActivity {
    private HomeViewModel viewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.home_recyclerview);
        progressBar = findViewById(R.id.progressBar);
        final HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(new ArrayList<TopHeadlinesArticle>());
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        String category = getIntent().getStringExtra("CATEGORY");
        viewModel.getArticlesCategory(category);
        viewModel.TopHeadLinesArticlesLiveData.observe(this, new Observer<List<TopHeadlinesArticle>>() {
            @Override
            public void onChanged(@Nullable List<TopHeadlinesArticle> articleList) {
                adapter.update(articleList);
            }
        });

        viewModel.isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean loading) {
                if (loading) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

}
