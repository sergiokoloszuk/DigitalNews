package br.com.digitalnews.digitalnews.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalnews.digitalnews.R;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register_now = findViewById(R.id.btn_register_now);

        btn_register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, ThemesActivity.class));
            }
        });
    }
}
