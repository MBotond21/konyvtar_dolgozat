package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter customAdapter;
    private EditText title_input;
    private EditText author_input;
    private EditText page_input;
    private Button add;
    private ListView konyv_list;
    private List<Konyv> konyvek = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = title_input.getText().toString();
                String a = author_input.getText().toString();
                String p = page_input.getText().toString();

                if(t.isEmpty() || a.isEmpty() || p.isEmpty()){
                    Toast.makeText(MainActivity.this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(p) < 50) {
                    Toast.makeText(MainActivity.this, "Az oldalszám nem lehet kevesebb 50-nél!", Toast.LENGTH_SHORT).show();
                } else{
                    Konyv konyv = new Konyv(t, Integer.parseInt(p), a);
                    konyvek.add(konyv);
                    customAdapter.notifyDataSetChanged();
                }
            }
        });

        konyv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ujIntent = new Intent(MainActivity.this, DetailsActivity.class);
                ujIntent.putExtra("title", konyvek.get(i).getTitle());
                ujIntent.putExtra("author", konyvek.get(i).getAuthor());
                ujIntent.putExtra("page", konyvek.get(i).getPage_count().toString());

                startActivity(ujIntent);

                finish();
            }
        });
    }

    private void init(){
        this.customAdapter = new CustomAdapter(this, konyvek);
        this.konyv_list = findViewById(R.id.konyv_list);
        this.title_input = findViewById(R.id.title_input);
        this.author_input = findViewById(R.id.author_input);
        this.page_input = findViewById(R.id.page_count_input);
        this.add = findViewById(R.id.add);
        this.konyv_list.setAdapter(customAdapter);
    }
}