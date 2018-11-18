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

import br.com.digitalnews.digitalnews.adapters.RecycleNewsAdapter;
import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.home.model.TopHeadlinesResponse;
import br.com.digitalnews.digitalnews.home.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private List<TopHeadlinesResponse> list = new ArrayList<>();
    private HomeViewModel viewModel;

    public HomeFragment() {

    }

    public static Fragment newInstance(int noticia_tres, String message) {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_foryou);
        final RecycleNewsAdapter adapter = new RecycleNewsAdapter(getResponses());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getArticles();
        viewModel.topHeadlinesArticleLiveData.observe(this, new Observer<List<TopHeadlinesResponse>>() {
            @Override
            public void onChanged(@Nullable List<TopHeadlinesResponse> topHeadlinesResponses) {
                adapter.setResponses(topHeadlinesResponses);
            }
        });

        return view;
    }

    private List<TopHeadlinesResponse> getResponses() {

        while (list.size() < 30){
            list.add(new TopHeadlinesResponse());
        }
        return list;
    }
}
