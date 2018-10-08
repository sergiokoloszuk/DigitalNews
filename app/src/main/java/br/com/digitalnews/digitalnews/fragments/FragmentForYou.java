package br.com.digitalnews.digitalnews.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalnews.digitalnews.R;

public class FragmentForYou extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;


    public FragmentForYou() {

    }

    public static FragmentForYou newInstance(int image, String text) {

        Bundle args = new Bundle();

        args.putInt("IMAGE", image);
        args.putString("TEXT", text);

        FragmentForYou fragment = new FragmentForYou();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foryou, container, false);


        return view;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
