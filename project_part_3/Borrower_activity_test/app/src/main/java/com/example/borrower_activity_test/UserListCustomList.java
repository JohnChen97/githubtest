package com.example.borrower_activity_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class UserListCustomList extends ArrayAdapter<UserEvent> {


    private ArrayList<UserEvent> users;
    private Context context;

    public UserListCustomList(Context context, ArrayList<UserEvent> users) {
        super(context, 0, users);
        this.users = users;
        this.context = context;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.user_list_custom_list,parent,false);
        }

        UserEvent user = users.get(position);

        TextView user_name = view.findViewById(R.id.user_name);
        TextView user_id = view.findViewById(R.id.user_id);


        user_name.setText(user.getUserName());
        user_id.setText(user.getUid());

        return view;
    }
}
