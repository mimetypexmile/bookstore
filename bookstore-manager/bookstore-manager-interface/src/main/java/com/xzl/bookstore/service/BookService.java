package com.xzl.bookstore.service;

import com.xzl.bookstore.pojo.po.Book;
import com.xzl.bookstore.pojo.vo.BookCustom;

import java.util.List;

public interface BookService {

    List<Book> listBooks();

    List<BookCustom> listBooksCustomByPage();

    int countBook();

    int updateBooksByIds(List<Long> ids);

    int upBooksByIds(List<Long> ids);

    int downBooksByIds(List<Long> ids);

    List<BookCustom> listBooksByState(byte state);
}
