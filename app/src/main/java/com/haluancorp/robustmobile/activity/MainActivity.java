package com.haluancorp.robustmobile.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haluancorp.robustmobile.Interface;
import com.haluancorp.robustmobile.object.Login;
import com.haluancorp.robustmobile.R;
import com.haluancorp.robustmobile.util.Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText username, password;
Button login;
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("Cookie", Context.MODE_PRIVATE);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!"".equals(username.getText().toString()) && !"".equals(password.getText().toString())) {
                    login.setTextColor(Color.parseColor("#FFFFFF"));
                    login.setBackgroundResource(R.drawable.rounded_button_green);
                    login.setClickable(true);
                }
                else {
                    login.setTextColor(Color.parseColor("#AAAAAA"));
                    login.setBackgroundResource(R.drawable.rounded_button_false);
                    login.setClickable(false);
                }


            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!"".equals(username.getText().toString()) && !"".equals(password.getText().toString())) {
                    login.setTextColor(Color.parseColor("#FFFFFF"));
                    login.setBackgroundResource(R.drawable.rounded_button_green);
                    login.setClickable(true);
                }
                else {
                    login.setTextColor(Color.parseColor("#AAAAAA"));
                    login.setBackgroundResource(R.drawable.rounded_button_false);
                    login.setClickable(false);
                }


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masuk("login", username.getText().toString(), password.getText().toString());

            }
        });

    }

        public void masuk(final String cmd, final String userId, final String pin){
            Interface inter = Helper.getClient().create(Interface.class);
            Call<Login> call = inter.login(cmd, userId, pin);
            call.enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    if (response.isSuccessful()) {
                        if(response.body().getSuccess()) {
                            Intent intent = new Intent(MainActivity.this, ActivityDrawer.class);
                            startActivity(intent);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("Cookie", response.headers().get("Set-Cookie"));
                            editor.apply();
                            Toast.makeText(MainActivity.this, response.headers().get("Set-Cookie"), Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
}
