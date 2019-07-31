package com.company.store;

public class Transaksi {

    private String id;
    private int qty;
    private Book book;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getQty() {
        return qty;
    }

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

