package com.ahmad.techpolitan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LoginActivity extends AppCompatActivity {
    CardView cvLogin;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cvLogin = findViewById(R.id.cvLogin);
        mContext = this;

        cvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}