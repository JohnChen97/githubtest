package com.example.borrower_activity_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class book_keyword_search_activity extends AppCompatActivity {

    static ArrayAdapter<BookEvent> bookAdapter;
    static ArrayAdapter<BookEvent> bookBorrowingAdapter;
    static  ArrayAdapter<BookEvent> updatedBookAdapter;
    static ArrayList<BookEvent> bookDataList;
    static ArrayList<BookEvent> bookBorrowingDataList;
    static  ArrayList<BookEvent> updatedBookList;


    ListView potentialBook;

    EditText enter_key_word;

    TextView book_inform;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_keyword_search_activity);

        final String TAG = "Sample";
        final FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("BookEvent");

        potentialBook = findViewById(R.id.potential_book_list);

        enter_key_word = findViewById(R.id.enter_key_word);

        Button search_button = findViewById(R.id.search_button);
        Button back_button = findViewById(R.id.back_button);

        book_inform = findViewById(R.id.book_inform);

        Intent intent = getIntent();
        bookBorrowingDataList = (ArrayList<BookEvent>) intent.getSerializableExtra("code");

        bookDataList = new ArrayList<>();
        updatedBookList = new ArrayList<>();


        bookAdapter = new BookListCustomList(this, bookDataList);
        bookBorrowingAdapter = new BookListCustomList(this, bookBorrowingDataList);
        updatedBookAdapter = new BookListCustomList(this, updatedBookList);


        /**
         * Need to implement google book api
         */






        search_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                updatedBookList.clear();
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


        db.collection("BookEvent")

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            bookDataList.clear();
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                                BookEvent the_book = new BookEvent(documentSnapshot.getData().get("title").toString(), documentSnapshot.getData().get("author").toString(), Integer.parseInt(documentSnapshot.getData().get("isbn").toString()));
                                the_book.setStatus(Integer.parseInt(documentSnapshot.getData().get("status").toString()));
                                bookDataList.add(the_book);



                            }
                        }else{
                            Log.d(TAG, "Error getting document: ", task.getException());
                        }
                    }
                });



        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This book is already in you request list");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );

        final AlertDialog alertDialog = builder.create();


        potentialBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookEvent selected_book = (BookEvent) potentialBook.getItemAtPosition(position);
                //Intent intent = new Intent( book_keyword_search_activity.this, request_book_list_activity.class);
                //intent.putExtra("Key", selected_book);
                //startActivity(intent);
                if (bookBorrowingDataList.contains(selected_book)){
                    alertDialog.show();
                    System.out.println(bookBorrowingDataList.toString());
                }else {
                    bookBorrowingDataList.add(selected_book);
                    builder.setMessage("Added");
                    AlertDialog alertDialog1 = builder.create();
                    alertDialog1.show();


                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("result", bookBorrowingDataList);
                setResult(RESULT_OK, result);
                finish();
            }
        });




    }

    public  void search() {
        for (int i = 0; i < bookDataList.size(); i++) {
            String key_word = enter_key_word.getText().toString();
            if (bookDataList.get(i).getTitle().contains(key_word)){
                updatedBookList.add(bookDataList.get(i));
            }
        }
        potentialBook.setAdapter(updatedBookAdapter);

    }




}