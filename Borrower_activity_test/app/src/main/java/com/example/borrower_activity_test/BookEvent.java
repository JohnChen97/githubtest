package com.example.borrower_activity_test;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.UUID;

public class BookEvent implements Serializable {
    private String title;
    private String author;
    private int isbn;
    private int photo;
    private int status;
    public String id;

    public BookEvent(String title, String author, int isbn, int photo){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.photo = photo;
        this.id = UUID.randomUUID().toString();
    }


    public BookEvent(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public BookEvent() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
