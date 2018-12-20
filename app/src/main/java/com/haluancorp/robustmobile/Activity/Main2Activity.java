package com.haluancorp.robustmobile.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.haluancorp.robustmobile.Interface;
import com.haluancorp.robustmobile.Object.Company;
import com.haluancorp.robustmobile.R;
import com.haluancorp.robustmobile.util.Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        teks = findViewById(R.id.teks);
        sharedPreferences = this.getSharedPreferences("Cookie", Context.MODE_PRIVATE);
        String cook = sharedPreferences.getString("Cookie",null);
//        teks.setText(cook);
        masuk("read", "com.hrk.enterprise.setup.CompanyPres", 0, 15, 100, "", true, cook);
    }

    public void masuk(final String cmd, final String cls, final int start, final int nlist, final int ncres, final String dform0, final Boolean populate, final String cookie){
        Interface inter = Helper.getClient().create(Interface.class);
        Call<Company> call = inter.company(cmd, cls, start, nlist, ncres, dform0, populate, cookie);
        call.enqueue(new Callback<Company>() {
            @Override
            public void onResponse(Call<Company> call, Response<Company> response) {
                if (response.isSuccessful()) {
                    teks.setText(Integer.toString(response.body().getTotalRows()));
//                    Toast.makeText(Main2Activity.this, response.body().getTotalRows(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Company> call, Throwable t) {
                Toast.makeText(Main2Activity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
