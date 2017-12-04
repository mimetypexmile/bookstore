package com.xzl.bookstore.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzl.bookstore.pojo.po.Book;
import com.xzl.bookstore.pojo.vo.BookCustom;
import com.xzl.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * book 操作
 */
@Controller
@RequestMapping("/book")
public class BookAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookService bookService;
    @ResponseBody
    @RequestMapping(value = "list")
    public List<Book> listBooks(){

        List<Book> books = bookService.listBooks();
        return  books;
    }
    @ResponseBody
    @RequestMapping(value = "/list/detail")
    public List<BookCustom> listCustomBooks(){

        List<BookCustom> list = bookService.listBooksCustomByPage();
        return  list;
    }
    @RequestMapping(value = "/list/all")
    public String listCustomBooksAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn, ModelMap map){

        PageHelper.startPage(pn,5);
        List<BookCustom> list = bookService.listBooksCustomByPage();
        PageInfo<BookCustom> page = new PageInfo<>(list,5);
        map.addAttribute("page",page);
        return "list";

    }
    @ResponseBody
    @RequestMapping(value = "/delete/batch")
    public int updateBook(@RequestParam("ids[]") List<Long> ids){
        int count = 0;
        try {
            count = bookService.updateBooksByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return count;
    }
    @ResponseBody
    @RequestMapping(value = "/up/batch")
    public int upBook(@RequestParam("ids[]") List<Long> ids){
        int count = 0;
        try {
            count = bookService.upBooksByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return count;
    }
    @ResponseBody
    @RequestMapping(value = "/down/batch")
    public int downBook(@RequestParam("ids[]") List<Long> ids){
        int count = 0;
        try {
            count = bookService.downBooksByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return count;
    }

    @ResponseBody
    @RequestMapping("/list/bookbystate")
    public List<BookCustom> listBooksByState(byte state){

        List<BookCustom> list = null;
        try {
            list = bookService.listBooksByState(state);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;

    }
}
