package com.dinesh.piloting.struts.bean;
public class BooksTypeBean {
    private int bookType_Id;
    private String bookType_Name;
    public BooksTypeBean() {
    }

    public void setBookType_Id(int bookType_Id) {
        this.bookType_Id = bookType_Id;
    }

    public void setBookType_Name(String bookType_Name) {
        this.bookType_Name = bookType_Name;
    }

    public int getBookType_Id() {
        return bookType_Id;
    }

    public String getBookType_Name() {
        return bookType_Name;
    }
}
