package br.com.digitalnews.digitalnews.home.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.digitalnews.digitalnews.R;

public class HomeViewPager extends Fragment {


    public HomeViewPager() {
    }

    public static HomeViewPager newInstance(String imageURL, String title) {

        Bundle args = new Bundle();

        args.putString("IMAGE_URL", imageURL);
        args.putString("TITLE", title);

        HomeViewPager fragment = new HomeViewPager();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_home, container, false);

        ImageView image = view.findViewById(R.id.home_viewpager_image);
        TextView title = view.findViewById(R.id.home_viewpager_title);

        String imageResource = getArguments().getString("IMAGE_URL");
        String titleResource = getArguments().getString("TITLE");

        Picasso.get().load(imageResource).into(image);
        title.setText(titleResource);

        return view;
    }
}

