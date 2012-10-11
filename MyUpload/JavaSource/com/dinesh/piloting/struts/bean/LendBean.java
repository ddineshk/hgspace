package com.dinesh.piloting.struts.bean;
public class LendBean {
    private int bookLend_Id;
    private int users_Id;
    private int books_Id;
    private String bookLend_StarTime;
    private String bookLend_EndTime;
    public LendBean() {
    }

    

    public void setUsers_Id(int users_Id) {
        this.users_Id = users_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }

    public void setBookLend_StarTime(String bookLend_StarTime) {
        this.bookLend_StarTime = bookLend_StarTime;
    }

    public void setBookLend_EndTime(String bookLend_EndTime) {
        this.bookLend_EndTime = bookLend_EndTime;
    }

   

    /**
	 * @return the bookLend_Id
	 */
	public int getBookLend_Id() {
		return bookLend_Id;
	}



	/**
	 * @param bookLend_Id the bookLend_Id to set
	 */
	public void setBookLend_Id(int bookLend_Id) {
		this.bookLend_Id = bookLend_Id;
	}



	public int getUsers_Id() {
        return users_Id;
    }

    public int getBooks_Id() {
        return books_Id;
    }

    public String getBookLend_StarTime() {
        return bookLend_StarTime;
    }

    public String getBookLend_EndTime() {
        return bookLend_EndTime;
    }
}
