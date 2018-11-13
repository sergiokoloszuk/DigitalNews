package br.com.digitalnews.digitalnews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import br.com.digitalnews.digitalnews.explorer.view.ExplorerFragment;

import br.com.digitalnews.digitalnews.fragments.FragmentForYou;
import br.com.digitalnews.digitalnews.fragments.NotificationsFragment;
import br.com.digitalnews.digitalnews.fragments.PerfilFragment;


public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private FrameLayout container;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_foryou:
                    replaceFragment(new ExplorerFragment());
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(new NotificationsFragment());
                    return true;
                case R.id.navigation_account:
                    replaceFragment(new PerfilFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        container = findViewById(R.id.container);

        initViews();
        replaceFragment(new FragmentForYou());


    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack("Frag");
        transaction.commit();
    }

    private void initViews() {


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }



}
