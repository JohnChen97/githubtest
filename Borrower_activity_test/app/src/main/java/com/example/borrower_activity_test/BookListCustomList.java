package com.example.borrower_activity_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BookListCustomList extends ArrayAdapter<BookEvent> {


    private ArrayList<BookEvent> books;
    private Context context;

    public BookListCustomList(Context context, ArrayList<BookEvent> books) {
        super(context,0,books);
        this.books = books;
        this.context = context;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.book_list_content,parent,false);
        }

        BookEvent book = books.get(position);

        TextView titleTextView = view.findViewById(R.id.title_textView);
        TextView statusTextView = view.findViewById(R.id.status_textView);


        titleTextView.setText(book.getTitle());
        int status = book.getStatus();
        switch (status){
            case 0:
                statusTextView.setText("Available");
                break;
            case 1:
                statusTextView.setText("Requested");
                break;
            case 2:
                statusTextView.setText("Borrowed");
                break;
            case 3:
                statusTextView.setText("Accepted");
                break;
        }

        return view;
    }
}

