package br.com.digitalnews.digitalnews;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.fragments.FragmentForYou;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        linearLayout = findViewById(R.id.linearlayout);
        tabLayout = findViewById(R.id.tablayout);




    }
}
