package br.com.digitalnews.digitalnews.explore.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.adapters.ExploreRecyclerViewAdapter;
import br.com.digitalnews.digitalnews.explore.model.ExploreSource;
import br.com.digitalnews.digitalnews.explore.viewmodel.ExploreViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {



    private RecyclerView recyclerView;
    private ExploreViewModel viewModel;

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(ExploreViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explorer, container, false);

        recyclerView = view.findViewById(R.id.explore_recyclerview);

        final ExploreRecyclerViewAdapter adapter = new ExploreRecyclerViewAdapter(new ArrayList<ExploreSource>());
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getCategories();

        viewModel.categoryLiveData.observe(this, new Observer<List<ExploreSource>>() {
            @Override
            public void onChanged(@Nullable List<ExploreSource> exploreSources) {
                adapter.update(exploreSources);
            }
        });

        return view;
    }
}
