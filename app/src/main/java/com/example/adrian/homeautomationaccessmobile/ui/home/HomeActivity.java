package com.example.adrian.homeautomationaccessmobile.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adrian.homeautomationaccessmobile.HomeAutomationAccessMobile;
import com.example.adrian.homeautomationaccessmobile.R;
import com.example.adrian.homeautomationaccessmobile.ui.control.ControlFragment;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginActivity;
import com.example.adrian.homeautomationaccessmobile.ui.settings.SettingsActivity;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Dummy floating action button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        ScreenType screenType = ScreenType.toScreenType(prefs.getString(getString(R.string.pref_default_screen_key), getString(R.string.pref_default_screen_default)));
        loadProperFragment(screenType);


        HomeAutomationAccessMobile application = (HomeAutomationAccessMobile) getApplication();
        Tracker mTracker = application.getDefaultTracker();
        Log.i("GoogleAnalytics", "Home activity onCreate()");
        mTracker.setScreenName("HomeActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent settings = new Intent(getBaseContext(), SettingsActivity.class);
            startActivity(settings);
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadProperFragment(ScreenType screenType){
        switch (screenType){
            case HOME:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_content, new HomeFragment()).commit();
                break;

            case FAVOURITES:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_content, new HomeFragment()).commit();
                // TODO replace with favourite
                break;

            default:
                Bundle bundle = new Bundle();
                bundle.putString("controlType", screenType.toString());

                Fragment fragment = new ControlFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.home_content, fragment).commit();
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_logout:
                Intent login = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.nav_home:
                loadProperFragment(ScreenType.HOME);
                break;
            case R.id.nav_gates:
                loadProperFragment(ScreenType.GATES);
                break;
            case R.id.nav_cameras:
                loadProperFragment(ScreenType.CAMERAS);
                break;
            case R.id.nav_wakeOnLans:
                loadProperFragment(ScreenType.WOLS);
                break;
            case R.id.nav_favourites:
                loadProperFragment(ScreenType.FAVOURITES);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
