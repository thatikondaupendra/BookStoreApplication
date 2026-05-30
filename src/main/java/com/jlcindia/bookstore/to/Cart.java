package com.jlcindia.bookstore.to;

public class Cart {
	private String userName;
    public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	private String bookName;
    private String author;
    private double price;
    private int quantity;
    private int cartid;

    public Cart(String bookName, String author, double price, int quantity,int cartid) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.cartid=cartid;
    }
    
    public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public Cart() {}


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


	public double getTotal() {
        return price * quantity;
    }
	
	
}
