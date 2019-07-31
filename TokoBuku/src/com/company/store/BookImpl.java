package com.company.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookImpl implements IBook {

    private  List<Book> list = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        list.add(book);
    }

    @Override
    public Book showDetail(String id) {
        Book detailBook = null;

        for (Book book : list) {
            if (book.getId() == id) {
                detailBook = book;
                break;
            }
        }
        return detailBook;
    }

    @Override
    public List<Book> getListBook() {
        return list;
    }

    @Override
    public void updateStock(String id, int qty) {
        int i  = 0;
        for (Book book : list) {
            if (book.getId() == id) {
                book.setStock((book.getStock()-qty));
            }
            i++;
        }
    }
}
