package kh.edu.rupp.fe.ite.tosreadbooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import kh.edu.rupp.fe.ite.tosreadbooks.fragment.AboutFragment;
import kh.edu.rupp.fe.ite.tosreadbooks.fragment.ContactFragment;
import kh.edu.rupp.fe.ite.tosreadbooks.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        //Use Toolbar to replace ActionBar
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        // Add drawer toggle
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //Click on navigation view
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleNavigationView(item);
                return true;
            }
        });

        // Show HomeFragment as Default
        showFragment(new HomeFragment());

    }
    // Show Search and more in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_more, menu);
        return true;
    }

    private void handleNavigationView(MenuItem item){
        if (item.getItemId() == R.id.mnu_home){
            showFragment(new HomeFragment());
        } else if (item.getItemId() == R.id.mnu_contact){
            showFragment(new ContactFragment());
        } else {
            showFragment(new AboutFragment());
        }
        //when click close drawer
        drawerLayout.closeDrawers();
    }

    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lyFragment, fragment);
        fragmentTransaction.commit();
    }
}