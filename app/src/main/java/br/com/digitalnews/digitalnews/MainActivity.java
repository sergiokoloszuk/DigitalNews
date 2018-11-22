package br.com.digitalnews.digitalnews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import br.com.digitalnews.digitalnews.explorer.view.ExplorerFragment;
import br.com.digitalnews.digitalnews.notifications.view.NotificationsFragment;
import br.com.digitalnews.digitalnews.profile.view.ProfileFragment;
import br.com.digitalnews.digitalnews.home.view.HomeFragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

        private FrameLayout container;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        replaceFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_explore:
                        replaceFragment(new ExplorerFragment());
                        return true;
                    case R.id.navigation_notifications:
                        replaceFragment(new NotificationsFragment());
                        return true;
                    case R.id.navigation_account:
                        replaceFragment(new ProfileFragment());
                        return true;
                }
                return false;
            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            BottomNavigationView navigation = findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

            container = findViewById(R.id.container);

            //TODO ajustar isto para HomeFragment
            replaceFragment(new HomeFragment());
        }

        private void replaceFragment(Fragment fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack("Frag");
            transaction.commit();
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return false;
        }
    }
}
