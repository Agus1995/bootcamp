package com.company.store;

import java.util.List;

public interface IBook {
    void addBook(Book book);

    Book showDetail(String id);

    List<Book> getListBook();

    void updateStock(String id, int qty);


}
