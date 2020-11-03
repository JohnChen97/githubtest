package com.example.borrower_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class book_keyword_search_activity extends AppCompatActivity {

    static ArrayAdapter<BookEvent> bookAdapter;
    static ArrayAdapter<BookEvent> bookBorrowingAdapter;
    static ArrayList<BookEvent> bookDataList;
    static ArrayList<BookEvent> bookBorrowingDataList;

    ListView potentialBook;

    EditText enter_key_word;

    TextView book_inform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_keyword_search_activity);

        potentialBook = findViewById(R.id.potential_book_list);

        enter_key_word = findViewById(R.id.enter_key_word);

        Button search_button = findViewById(R.id.search_button);
        Button back_button = findViewById(R.id.back_button);

        book_inform = findViewById(R.id.book_inform);

        bookDataList = new ArrayList<>();
        bookBorrowingDataList = new ArrayList<>();
        bookDataList.add(new  BookEvent("Testing Title A", "Testing Author A", 123456) );
        bookAdapter = new BookListCustomList(this, bookDataList);
        bookBorrowingAdapter = new BookListCustomList(this, bookBorrowingDataList);
        //potentialBook.setAdapter(bookAdapter);

        /**
         * Need to implement google book api
         */


        search_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                search();
            }



        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        book_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book_inform.setVisibility(View.VISIBLE);
                book_inform.setText("Testing Visibility");

            }
        });






    }

    public void search(){
        for (int i = 0; i < bookDataList.size(); i++){
            if (bookDataList.get(i).getTitle().contains(enter_key_word.getText())){
                bookBorrowingDataList.add(bookDataList.get(i));
            }
        }
        potentialBook.setAdapter(bookBorrowingAdapter);

    }

}