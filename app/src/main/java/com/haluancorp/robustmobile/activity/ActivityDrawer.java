package com.haluancorp.robustmobile.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.haluancorp.robustmobile.Interface;
import com.haluancorp.robustmobile.fragment.LeaveInformation;
import com.haluancorp.robustmobile.object.CurrentUserInformation;
import com.haluancorp.robustmobile.R;
import com.haluancorp.robustmobile.util.Helper;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AdvanceDrawerLayout drawer;
    SharedPreferences sharedPreferences;
    TextView nama, jabatan, company;
    ImageView imageView, companyLogo;

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
        imageView = headerView.findViewById(R.id.imageView);
//        company = includedLayout.findViewById(R.id.companyName);
//        companyLogo = includedLayout.findViewById(R.id.companyLogo);

        setDrawer();

        sharedPreferences = this.getSharedPreferences("Cookie", Context.MODE_PRIVATE);
        String cook = sharedPreferences.getString("Cookie",null);
        masuk("initconfig", cook);
    }

    public void masuk(final String cmd, final String cookie){
        Interface inter = Helper.getClient().create(Interface.class);
        Call<CurrentUserInformation> call = inter.currentUserInformation(cmd, cookie);
        call.enqueue(new Callback<CurrentUserInformation>() {
            @SuppressLint("CheckResult")
            @Override
            public void onResponse(Call<CurrentUserInformation> call, Response<CurrentUserInformation> response) {
                if (response.isSuccessful()) {
                    nama.setText(response.body().getConfig().getUsername());
                    jabatan.setText(response.body().getConfig().getPosition());
//                    company.setText(response.body().getConfig().getCompany());
//                    company.setTypeface(null, Typeface.BOLD);

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.malenophoto).error(R.drawable.malenophoto);
//                    requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
//                    requestOptions.bitmapTransform(new RoundedCorners(150));

                    String url = "http://10.53.25.59" + response.body().getConfig().getUserlogo();
//                    String urlLogo = "http://10.53.25.59" + response.body().getConfig().getCompanylogo();
                    Glide.with(getBaseContext()).load(url).apply(requestOptions).into(imageView);
//                    Glide.with(getBaseContext()).load(urlLogo).apply(requestOptions).into(companyLogo);
//                    Toast.makeText(ActivityDrawer.this, url, Toast.LENGTH_SHORT).show();
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

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setRadius(Gravity.START, 35);
        drawer.setViewElevation(Gravity.START, 20);

        navigationView.getMenu().setGroupVisible(R.id.groupESS, false);

        displaySelectedScreen(R.id.employeeSelfService);
    }

    private void showSubMenu(int itemId) {
        NavigationView nv = findViewById(R.id.nav_view);
        Menu m = nv.getMenu();

        switch (itemId) {
            case R.id.employeeSelfService:
//                boolean b=!m.findItem(R.id.personalInformation).isVisible();
//                m.findItem(R.id.personalInformation).setVisible(b);
//                m.findItem(R.id.workingInformation).setVisible(b);
//                m.findItem(R.id.leaveInformation).setVisible(b);
//                m.findItem(R.id.leaveRequest).setVisible(b);
                boolean b=!m.findItem(R.id.personalInformation).isVisible();
                m.setGroupVisible(R.id.groupESS, b);
                break;
        }
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
//        Fragment fragment = null;
//        TextView title = findViewById(R.id.toolbarTitle);
//        RelativeLayout nTitle = findViewById(R.id.wrapperToolbar);

        Fragment fragment;
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.personalInformation:
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.workingInformation:
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.leaveInformation:
                fragment = new LeaveInformation();
                changeFragment(ft, fragment, drawer);
                break;
            case R.id.leaveRequest:
                drawer.closeDrawer(GravityCompat.START);
                break;
        }

    }

    private void changeFragment(FragmentTransaction ft, Fragment fragment, DrawerLayout drawer) {
            if (fragment != null) {
            ft.replace(R.id.content_frame, fragment).commit();
            }
            drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        showSubMenu(item.getItemId());
        displaySelectedScreen(item.getItemId());
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }
}
