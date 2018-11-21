package br.com.digitalnews.digitalnews.home.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.adapters.RecyclerViewHomeAdapter;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;
import br.com.digitalnews.digitalnews.home.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;

    public HomeFragment() {

    }

    // TODO analisar a necessidade de se colocar um newInstace para este fragment

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_home);
        final RecyclerViewHomeAdapter adapter = new RecyclerViewHomeAdapter(new ArrayList<TopHeadlinesArticle>());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getArticles();
        viewModel.TopHeadLinesArticlesLiveData.observe(this, new Observer<List<TopHeadlinesArticle>>() {
            @Override
            public void onChanged(@Nullable List<TopHeadlinesArticle> articleList) {
                adapter.update(articleList);
            }
        });
        return view;
    }
}
