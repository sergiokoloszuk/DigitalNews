package br.com.digitalnews.digitalnews.home.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.adapters.HomeRecyclerViewAdapter;
import br.com.digitalnews.digitalnews.adapters.ViewPagerAdapter;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesArticle;
import br.com.digitalnews.digitalnews.home.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private ViewPager viewPager;
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

        viewPager = view.findViewById(R.id.home_viewpager);
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), new ArrayList<Fragment>());
        viewPager.setAdapter(viewPagerAdapter);

        RecyclerView recyclerView = view.findViewById(R.id.home_recyclerview);
        final HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(new ArrayList<TopHeadlinesArticle>());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getArticles();
        viewModel.TopHeadLinesArticlesLiveData.observe(this, new Observer<List<TopHeadlinesArticle>>() {
            @Override
            public void onChanged(@Nullable List<TopHeadlinesArticle> articleList) {
                adapter.update(articleList);
                viewPagerAdapter.update(setFragments(articleList));
            }
        });
        return view;
    }

    @NonNull
    private List<Fragment> setFragments(List<TopHeadlinesArticle> articleList) {

        final List<Fragment> fragments = new ArrayList<>();

        for (TopHeadlinesArticle article : articleList) {
            fragments.add(HomeViewPager.newInstance(article.getUrlToImage(), article.getTitle()));
        }
        
        return fragments;
    }
}
