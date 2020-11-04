package com.example.borrower_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class request_target_book extends AppCompatActivity {

    static TextView owner_inform;
    static TextView borrower_inform;
    static TextView book_title;

    ArrayList<BookEvent> Borrower_book_list;
    ArrayAdapter<BookEvent> Borrower_book_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_target_book);

        Button request_book = findViewById(R.id.request_button);
        Button back_button = findViewById(R.id.back_button);

        Intent search_intent = getIntent();
        BookEvent target_book = (BookEvent) search_intent.getSerializableExtra("Key");

        if (target_book.getStatus() != 0){
            Context context;
            //AlertDialog.Builder builder = new AlertDialog.Builder(context);
            //builder.setMessage("This book currently is not available");

        }
    }
}