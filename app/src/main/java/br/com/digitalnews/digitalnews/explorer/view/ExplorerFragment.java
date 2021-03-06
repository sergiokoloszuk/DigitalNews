package br.com.digitalnews.digitalnews.explorer.view;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.adapters.RecyclerViewAdapterExplorerNoticias;
import br.com.digitalnews.digitalnews.adapters.ViewPagerAdapterExplorer;
import br.com.digitalnews.digitalnews.explorer.viewmodel.ExplorerFragViewModel;
import br.com.digitalnews.digitalnews.fragments.ViewPagerExplorerFragment;
import br.com.digitalnews.digitalnews.model.NoticiaExplorer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExplorerFragment extends Fragment {


    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private ExplorerFragViewModel viewModel;

    public ExplorerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(ExplorerFragViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explorer, container, false);
        viewPager = view.findViewById(R.id.view_pager);

        List<Fragment> fragments = getFragments();
        ViewPagerAdapterExplorer pagerAdapter = new ViewPagerAdapterExplorer(getActivity().getSupportFragmentManager(), fragments);

        viewPager.setAdapter(pagerAdapter);

        recyclerView = view.findViewById(R.id.recycler_view);

        RecyclerViewAdapterExplorerNoticias adapter = new RecyclerViewAdapterExplorerNoticias(new ArrayList<NoticiaExplorer>());
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        viewModel.getCategories();
        return view;
    }

    @NonNull
    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        Fragment fragment = ViewPagerExplorerFragment.newInstance(R.drawable.news_1, "BMW recalls BMW M3, M4 models");

        fragments.add(fragment);
        fragments.add(ViewPagerExplorerFragment.newInstance(R.drawable.news_2, "Tesla Model 3"));
        return fragments;
    }


}
