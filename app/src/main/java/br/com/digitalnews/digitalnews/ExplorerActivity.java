package br.com.digitalnews.digitalnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalnews.digitalnews.adapters.RecyclerViewAdapterExplorerNoticias;
import br.com.digitalnews.digitalnews.adapters.ViewPagerAdapterExplorer;
import br.com.digitalnews.digitalnews.fragments.ExplorerFragment;
import br.com.digitalnews.digitalnews.fragments.NotificationsFragment;
import br.com.digitalnews.digitalnews.model.NoticiaExplorer;

public class ExplorerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorer);

        viewPager = findViewById(R.id.view_pager);

        List<Fragment> fragments = getFragments();
        ViewPagerAdapterExplorer pagerAdapter = new ViewPagerAdapterExplorer(getSupportFragmentManager(), fragments);

        viewPager.setAdapter(pagerAdapter);

        recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapterExplorerNoticias adapter = new RecyclerViewAdapterExplorerNoticias(getListNoticias());
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Home");
                    return true;
                case R.id.navigation_foryou:
                    mTextMessage.setText("For You");
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText("Search");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("Notifications");
                    return true;
                case R.id.navigation_account:
                    mTextMessage.setText("Account");
                    startActivity(new Intent(ExplorerActivity.this, PerfilActivity.class));
                    return true;
            }
            return false;
        }
    };

    @NonNull
    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        Fragment fragment = ExplorerFragment.newInstance(R.drawable.news_1, "BMW recalls BMW M3, M4 models");

        fragments.add(fragment);
        fragments.add(ExplorerFragment.newInstance(R.drawable.news_2, "Tesla Model 3"));
        return fragments;
    }

    private List<NoticiaExplorer> getListNoticias() {
        List<NoticiaExplorer> noticiaExplorerList = new ArrayList<>();

        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_3));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_4));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_5));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_3));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_4));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_5));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_3));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_4));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_5));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_3));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_4));
        noticiaExplorerList.add(new NoticiaExplorer(R.drawable.news_5));

        return noticiaExplorerList;
    }
}

