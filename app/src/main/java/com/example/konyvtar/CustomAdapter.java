package com.example.konyvtar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Konyv> konyvek = new ArrayList<>();
    private Button torol;

    public CustomAdapter(Context context, List<Konyv> konyvek) {
        this.inflater = LayoutInflater.from(context);
        this.konyvek = konyvek;
    }

    @Override
    public int getCount() { return this.konyvek.size(); }

    @Override
    public Object getItem(int position) { return this.konyvek.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        convertView = inflater.inflate(R.layout.row_item, parent, false);

        TextView title = convertView.findViewById(R.id.title);
        TextView author = convertView.findViewById(R.id.author);
        TextView page = convertView.findViewById(R.id.page_count);

        title.setText(konyvek.get(position).getTitle());
        author.setText(konyvek.get(position).getAuthor());
        page.setText(konyvek.get(position).getPage_count().toString());

        return convertView;

    }
}
