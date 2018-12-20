package com.haluancorp.robustmobile.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.haluancorp.robustmobile.Interface;
import com.haluancorp.robustmobile.Object.Configs;
import com.haluancorp.robustmobile.Object.CurrentUserInformation;
import com.haluancorp.robustmobile.R;
import com.haluancorp.robustmobile.util.Helper;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AdvanceDrawerLayout drawer;
    SharedPreferences sharedPreferences;
    TextView nama, jabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        View includedLayout = findViewById(R.id.appsbar);
        NavigationView headerLayout = findViewById(R.id.nav_view);
        View headerView = headerLayout.getHeaderView(0);
        nama = headerView.findViewById(R.id.nama);
        jabatan = headerView.findViewById(R.id.jabatan);

        setDrawer();

        sharedPreferences = this.getSharedPreferences("Cookie", Context.MODE_PRIVATE);
        String cook = sharedPreferences.getString("Cookie",null);
        masuk("initconfig", cook);
    }

    public void masuk(final String cmd, final String cookie){
        Interface inter = Helper.getClient().create(Interface.class);
        Call<CurrentUserInformation> call = inter.currentUserInformation(cmd, cookie);
        call.enqueue(new Callback<CurrentUserInformation>() {
            @Override
            public void onResponse(Call<CurrentUserInformation> call, Response<CurrentUserInformation> response) {
                if (response.isSuccessful()) {
                    nama.setText(response.body().getConfig().getUsername());
                    jabatan.setText(response.body().getConfig().getPosition());
//                    Toast.makeText(Main2Activity.this, response.body().getTotalRows(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CurrentUserInformation> call, Throwable t) {
                Toast.makeText(ActivityDrawer.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setRadius(Gravity.START, 35);
        drawer.setViewElevation(Gravity.START, 20);

        displaySelectedScreen(R.id.employeeSelfService);
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
//        Fragment fragment = null;
//        TextView title = findViewById(R.id.toolbarTitle);
//        RelativeLayout nTitle = findViewById(R.id.wrapperToolbar);

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.employeeSelfService:
                break;
            case R.id.personalInformation:
                break;
            case R.id.workingInformation:
                break;
            case R.id.leaveInformation:
                break;
            case R.id.leaveRequest:
                break;
        }

//        if (fragment != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.content_frame, fragment);
//            ft.commit();
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedScreen(item.getItemId());
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
