package com.haluancorp.robustmobile.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haluancorp.robustmobile.Interface;
import com.haluancorp.robustmobile.Object.Login;
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
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Cookie", response.headers().get("Set-Cookie"));
                        editor.apply();
                        Toast.makeText(MainActivity.this, response.headers().get("Set-Cookie"), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
}
