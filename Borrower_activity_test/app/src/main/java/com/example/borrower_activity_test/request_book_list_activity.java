package com.example.borrower_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

/**import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;*/

import java.util.ArrayList;

public class request_book_list_activity extends AppCompatActivity {






    static ArrayAdapter<BookEvent> bookAdapter;
    static ArrayAdapter<BookEvent> bookBorrowingAdapter;
    static ArrayList<BookEvent> bookDataList;
    static ArrayList<BookEvent> bookBorrowingDataList;

    static ListView request_book_list_view;
    static TextView just_show;
    static TextView just_show_one_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_book_list_activity);


        just_show = findViewById(R.id.just_show);
        just_show_one_status = findViewById(R.id.just_show_one_status);
        request_book_list_view = findViewById(R.id.request_book_list_view);

        /**final FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("User-Books");*/

        Switch the_switch = findViewById(R.id.just_show_switch);

        Button back_button = findViewById(R.id.back_button);





        TextView textView = new TextView(this);
        textView.setText("Requested Book");
        request_book_list_view.addHeaderView(textView);

        bookBorrowingDataList = new ArrayList<>();
        bookBorrowingDataList.add(new  BookEvent("Testing Title A", "Testing Author A", 123456) );
        bookAdapter = new BookListCustomList(this, bookBorrowingDataList);
        request_book_list_view.setAdapter(bookAdapter);

        /**for (int i = 0; i < bookDataList.size(); i++){
            if (bookDataList.get(i).getStatus() == 2){
                bookBorrowingDataList.add(bookDataList.get(i));
            }
        }*/

        the_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    //bookBorrowingAdapter = new BookListCustomList(request_book_list_activity.this, bookBorrowingDataList);
                    bookBorrowingDataList.add(new  BookEvent("Testing Title B", "Testing Author B", 123467890) );
                    request_book_list_view.setAdapter(bookAdapter);

                }
                else {

                    //bookAdapter = new BookListCustomList(request_book_list_activity.this, bookDataList);
                    bookBorrowingDataList.add(new  BookEvent("Testing Title C", "Testing Author C", 123467890) );
                    request_book_list_view.setAdapter(bookAdapter);



                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}