package br.com.digitalnews.digitalnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThemesActivity extends AppCompatActivity {

    private TextView themes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        themes = findViewById(R.id.textViewThemes);

        themes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThemesActivity.this, MainActivity.class));
            }
        });


    }
}
