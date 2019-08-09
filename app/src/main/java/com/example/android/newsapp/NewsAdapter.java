package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String DATE_SEPARATOR = "T";

    public NewsAdapter (Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        //get title view
        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(currentNews.getTitle());

        TextView sectionTextView = listItemView.findViewById(R.id.section);
        sectionTextView.setText(currentNews.getSection());

        String originalDate = currentNews.getDate();
        String shortDate = null;

        if (originalDate.contains(DATE_SEPARATOR)){
            String[] parts = originalDate.split(DATE_SEPARATOR);
            shortDate = parts[0];
        }

        TextView dateTextView = listItemView.findViewById(R.id.publish_date);
        dateTextView.setText(shortDate);


        return listItemView;
    }
}
