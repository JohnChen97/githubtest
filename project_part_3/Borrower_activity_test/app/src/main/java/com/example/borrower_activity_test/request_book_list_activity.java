package com.example.borrower_activity_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class request_book_list_activity extends AppCompatActivity {






    static ArrayAdapter<BookEvent> bookAdapter;
    static ArrayAdapter<BookEvent> bookBorrowingAdapter;
    static ArrayAdapter<BookEvent> availableBookAdapter;
    static ArrayList<BookEvent> bookDataList;
    static ArrayList<BookEvent> bookBorrowingDataList;
    static ArrayList<BookEvent> availableBookList;

    ListView request_book_list_view;
    TextView just_show;
    TextView just_show_one_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_book_list_activity);

        Intent intent = getIntent();
        bookBorrowingDataList = (ArrayList<BookEvent>) intent.getSerializableExtra("password");




        just_show = findViewById(R.id.just_show);
        just_show_one_status = findViewById(R.id.just_show_one_status);
        request_book_list_view = findViewById(R.id.request_book_list_view);

        final String TAG = "Sample";
        final FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();
        final CollectionReference collectionReference = db.collection("BookEvent");


        /**final ArrayList<BookEvent> selectedBook = new ArrayList<>();
        db.collection("BookEvent")
                .whereEqualTo("title", "Testing Title D")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            selectedBook.clear();
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());
                                selectedBook.add(new BookEvent(documentSnapshot.getData().get("title").toString(), documentSnapshot.getData().get("author").toString(), Integer.parseInt(documentSnapshot.getData().get("isbn").toString())));



                            }
                        }else{
                            Log.d(TAG, "Error getting document: ", task.getException());
                        }
                    }
                });*/


        Switch the_switch = findViewById(R.id.just_show_switch);

        Button back_button = findViewById(R.id.back_button);





        TextView textView = new TextView(this);
        textView.setText("Requested Book");
        request_book_list_view.addHeaderView(textView);

        bookAdapter = new BookListCustomList(this, bookBorrowingDataList);
        request_book_list_view.setAdapter(bookAdapter);

        availableBookList = new ArrayList<>();
        for (int i = 0; i < bookBorrowingDataList.size(); i++){
            if (bookBorrowingDataList.get(i).getStatus() == 0){
                availableBookList.add(bookBorrowingDataList.get(i));

            }
        }
        availableBookAdapter = new BookListCustomList(this, availableBookList);


        the_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){



                    request_book_list_view.setAdapter(availableBookAdapter);
                    System.out.println(availableBookList.toString());



                }
                else {

                    //bookAdapter = new BookListCustomList(request_book_list_activity.this, bookDataList);

                    request_book_list_view.setAdapter(bookAdapter);



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
}