package br.com.digitalnews.digitalnews.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.adapters.RecycleNoticiasAdapter;
import br.com.digitalnews.digitalnews.R;
import br.com.digitalnews.digitalnews.model.Noticias;

public class FragmentForYou extends Fragment {

    private List<Noticias> list = new ArrayList<>();

    public FragmentForYou() {

    }

    public static Fragment newInstance(int noticia_tres, String message) {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foryou, container, false);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.navigation);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_foryou);
        RecycleNoticiasAdapter adapter = new RecycleNoticiasAdapter(getNoticias());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Noticias> getNoticias() {
        list.add(new Noticias(R.drawable.noticia_um, "Titulo Noticia", "Subtitulo Noticia"));
        list.add(new Noticias(R.drawable.noticia_dois, "Titulo Noticia", "Subtitulo Noticia"));
        list.add(new Noticias(R.drawable.noticia_tres, "Titulo Noticia", "Subtitulo Noticia"));
        list.add(new Noticias(R.drawable.noticia_dois, "Titulo Noticia", "Subtitulo Noticia"));
        list.add(new Noticias(R.drawable.noticia_tres, "Titulo Noticia", "Subtitulo Noticia"));
        list.add(new Noticias(R.drawable.noticia_dois, "Titulo Noticia", "Subtitulo Noticia"));
        list.add(new Noticias(R.drawable.noticia_tres, "Titulo Noticia", "Subtitulo Noticia"));

        return list;
    }
}
