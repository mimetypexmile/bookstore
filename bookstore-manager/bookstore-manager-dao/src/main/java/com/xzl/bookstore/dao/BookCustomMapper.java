package com.xzl.bookstore.dao;

import com.xzl.bookstore.pojo.po.Book;
import com.xzl.bookstore.pojo.vo.BookCustom;

import java.util.List;
import java.util.Map;

public interface BookCustomMapper {
    //分页查询book数据
    List<BookCustom> listBooksByPage(Map<String, Object> map);

    //符合条件的书的数量
    int countBooks(Map<String, Object> map);

    //通过状态查询书籍
    List<BookCustom> listBooksByState(byte state);

    //购买之后更新书籍库存
    int updateCount(List<Book> list);

}
