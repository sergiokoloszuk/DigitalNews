package br.com.digitalnews.digitalnews.explore.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalnews.digitalnews.R;

public class ViewPagerExplore extends Fragment {


    public ViewPagerExplore() {
    }

    public static ViewPagerExplore newInstance(int image, String title) {

        Bundle args = new Bundle();

        args.putInt("IMAGE", image);
        args.putString("TITLE", title);

        ViewPagerExplore fragment = new ViewPagerExplore();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        ImageView imageNoticia = view.findViewById(R.id.image_view_pager);
        TextView titulo = view.findViewById(R.id.titulo_noticia_view_pager);

        int imageResource = getArguments().getInt("IMAGE");
        String textTitle = getArguments().getString("TITLE");

        imageNoticia.setImageResource(imageResource);
        titulo.setText(textTitle);

        return view;
    }

}

