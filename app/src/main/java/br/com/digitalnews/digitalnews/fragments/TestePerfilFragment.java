package br.com.digitalnews.digitalnews.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalnews.digitalnews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestePerfilFragment extends Fragment {


    public TestePerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teste_perfil, container, false);
        return view;
    }

}
