package br.com.digitalnews.digitalnews.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.digitalnews.digitalnews.HomeActivity;
import br.com.digitalnews.digitalnews.R;

public class LoginActivity extends AppCompatActivity  {

    private TextView register;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    register = findViewById(R.id.register);
    btnLogin = findViewById(R.id.btn_login);

    register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

        }
    });

    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }
    });


    }
}
