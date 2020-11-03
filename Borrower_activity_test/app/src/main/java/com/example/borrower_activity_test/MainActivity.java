package com.example.borrower_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BorrowerActivity");

        Button borrower_search_book = findViewById(R.id.borrower_search_book);
        Button borrower_scan_isbn = findViewById(R.id.borrower_scan_isbn);
        Button borrower_check_requested_list = findViewById(R.id.borrower_check_requested_list);
        Button borrower_user_profile = findViewById(R.id.borrower_user_profile);
        Button borrower_search_user = findViewById(R.id.borrower_search_user);
        Button borrower_activity_back = findViewById(R.id.borrower_activity_back);

        TextView borrower_hi_user_name = findViewById(R.id.borrower_hi_user_name);
        TextView borrower_have_request = findViewById(R.id.borrower_have_request);

        /**
         * Need to add a bell image in the image view.
         */
        ImageView borrower_bell = findViewById(R.id.borrower_bell);

        LinearLayout borrower_activity_linear_layout_3 = findViewById(R.id.borrower_activity_linear_layout_3);
        LinearLayout borrower_activity_linear_layout_2 = findViewById(R.id.borrower_activity_linear_layout_2);
        LinearLayout borrower_activity_linear_layout_1 = findViewById(R.id.borrower_activity_linear_layout_1);
        RelativeLayout borrower_activity_relative_layout = findViewById(R.id.borrower_activity_relative_layout);
        /**
         * Need to add the UserEvent function to get the user name.
         */
        /**Bundle data = getIntent().getExtras();
        //the_user = (UserEvent) data.getParcelable("the_user");
        //borrower_hi_user_name.setText(the_user.getUser());*/

        borrower_search_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_borrower_search_book();
            }
        });

        /**borrower_scan_isbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        borrower_check_requested_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_borrower_check_requested_list();
            }
        });

        /**borrower_user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        borrower_search_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        borrower_activity_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }); */




    }

    public void open_borrower_search_book(){
        Intent intent = new Intent(this, book_keyword_search_activity.class);
        startActivity(intent);
    }

   /**public void open_borrower_scan_isbn(){
        Intent intent = new Intent(this, scan_isbn_activity.class);
        startActivity(intent);
    }
    */
    public void open_borrower_check_requested_list(){
        Intent check_requested_list = new Intent(this, request_book_list_activity.class);
        startActivity(check_requested_list);
    }
    /**
    public void open_borrower_user_profile(){
        Intent intent = new Intent(this, edit_user_profile_activity.class);
        startActivity(intent);
    }

    public void open_borrower_search_user(){
        Intent intent = new Intent(this, search_user_activity.class);
        startActivity(intent);
    }*/
}