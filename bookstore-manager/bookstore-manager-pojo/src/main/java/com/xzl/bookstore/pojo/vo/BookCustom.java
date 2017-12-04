package com.xzl.bookstore.pojo.vo;

import com.xzl.bookstore.pojo.po.Book;

public class BookCustom extends Book{

    private String categoryName;

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
