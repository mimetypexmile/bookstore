package com.xzl.bookstore.pojo.dto;

import com.xzl.bookstore.pojo.po.Book;

public class BookDTO{

    private long id;
    private String bookname;
    private Long price;
    private int count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
