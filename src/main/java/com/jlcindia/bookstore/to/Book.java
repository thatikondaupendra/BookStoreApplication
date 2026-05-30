package com.jlcindia.bookstore.to;

public class Book {
	public int bookid;
    public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String bookName;
    public String author;
    public double price;
    public int quantity;


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Constructor
    public Book(String bookName, String author, double price, int quantity) {
    	this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public Book() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Book [bookName=" + bookName + ", author=" + author +
               ", price=" + price + ", quantity=" + quantity + "]";
    }
}
