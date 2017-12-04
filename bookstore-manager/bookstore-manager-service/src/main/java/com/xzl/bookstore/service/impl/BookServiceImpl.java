package com.xzl.bookstore.service.impl;

import com.xzl.bookstore.dao.BookCustomMapper;
import com.xzl.bookstore.dao.BookMapper;
import com.xzl.bookstore.pojo.po.Book;
import com.xzl.bookstore.pojo.po.BookExample;
import com.xzl.bookstore.pojo.vo.BookCustom;
import com.xzl.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookDao;

    @Autowired
    private BookCustomMapper bookCustomDao;

    @Override
    public List<Book> listBooks() {
       List<Book> list = null;
        try {
            list = bookDao.selectByExample(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookCustom> listBooksCustomByPage() {
        Map<String , Object> map = new HashMap<>();
        int count = 0;
        List<BookCustom> list = null;
        try {
            count = bookCustomDao.countBooks(map);
            list = bookCustomDao.listBooksByPage(map);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        System.out.println(count);

        return list;
    }

    @Override
    public int countBook() {

        Map<String , Object> map = new HashMap<>();
        return bookCustomDao.countBooks(map);
    }

    /**
     * 删除book   实际上是修改状态为3
     * @param ids
     * @return
     */
    @Override
    public int updateBooksByIds(List<Long> ids) {
        Book book = new Book();
        book.setState((byte)3);
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return bookDao.updateByExampleSelective(book,example);
    }

    //上架书  状态修改为1
    @Override
    public int upBooksByIds(List<Long> ids) {
        Book book = new Book();
        book.setState((byte)1);
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return bookDao.updateByExampleSelective(book,example);
    }
    //下架书  状态修改为2
    @Override
    public int downBooksByIds(List<Long> ids) {
        Book book = new Book();
        book.setState((byte)2);
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return bookDao.updateByExampleSelective(book,example);
    }

    @Override
    public List<BookCustom> listBooksByState(byte state) {
        return bookCustomDao.listBooksByState(state);
    }
}
