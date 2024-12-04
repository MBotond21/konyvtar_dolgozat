package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private TextView title;
    private TextView author;
    private TextView page;
    private TextView year;
    private Button back;
    private Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        Bundle bundle = getIntent().getExtras();

        title.setText(bundle.getString("title"));
        author.setText(bundle.getString("author"));
        page.setText(bundle.getString("page"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ujIntent = new Intent(DetailsActivity.this, MainActivity.class);

                startActivity(ujIntent);

                finish();
            }
        });

    }

    private void init(){
        this.title = findViewById(R.id.title_detail);
        this.author = findViewById(R.id.author_detail);
        this.page = findViewById(R.id.page_count_detail);
        this.year = findViewById(R.id.year_detail);
        year.setText(String.valueOf(r.nextInt(2024)));
        this.back = findViewById(R.id.back);
    }
}