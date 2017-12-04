package com.xzl.bookstore.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xzl.bookstore.common.util.JsonUtils;
import com.xzl.bookstore.dao.*;
import com.xzl.bookstore.pojo.dto.BookDTO;
import com.xzl.bookstore.pojo.po.*;
import com.xzl.bookstore.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrdersMapper ordersDao;

    @Autowired
    private UserMapper userDao;

    @Autowired
    private UserCustomMapper userCustomDao;

    @Autowired
    private BookMapper bookDao;

    @Autowired
    private BookCustomMapper bookCustomDao;

    @Override
    public int saveOrder(Orders order) {

        int count = 0;
        try {
            count = ordersDao.insertSelective(order);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return count;
    }


    @Transactional
    @Override
    public int payOrder(List<Long> ids,Long uid) {
        //1. 求出价格
        Orders record = new Orders();
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdIn(ids);
        List<Orders> ordersList = ordersDao.selectByExampleWithBLOBs(example);
        Long sum = 0L;
        int book_count = 0;
        Long book_id =0L;
        List<Long> book_ids = new ArrayList<>(16);
        List<Book> batchUpdatedBooks = new ArrayList<>();

        List<BookDTO> bookDTOS = null;
        for(Orders order:ordersList){
            String content = order.getContent();
            bookDTOS = JsonUtils.jsonToList(content, BookDTO.class);
            for (int i = 0;i<bookDTOS.size();i++){
                book_id = bookDTOS.get(i).getId();
                book_ids.add(book_id);
                book_count = bookDTOS.get(i).getCount();
                Long price = bookDTOS.get(i).getPrice();
                sum += book_count * price;

            }
        }
        BookExample bookExample = new BookExample();
        BookExample.Criteria bookExampleCriteria = bookExample.createCriteria();
        bookExampleCriteria.andIdIn(book_ids);
        List<Book> books = bookDao.selectByExample(bookExample);
        for (int i = 0;i<books.size();i++){
            Book book = new Book();
            book.setId(bookDTOS.get(i).getId());
            book.setInventory(books.get(i).getInventory()- bookDTOS.get(i).getCount());
            batchUpdatedBooks.add(book);
        }
        //批量修改book的库存
        int book_affectedRows = bookCustomDao.updateCount(batchUpdatedBooks);
        System.out.println(book_affectedRows);
        System.out.println("orders is cost:"+sum);
        //2 查出用户的账户余额
        User user_count = userDao.selectByPrimaryKey(uid);
        Double account = 0.0;
        if(user_count != null){
            account = user_count.getAccount();
            System.out.println(account);
        }
        //6表示交易完成
        record.setStatus((byte)6);
        int order_count = ordersDao.updateByExampleSelective(record, example);

        //更改用户的金额
        User user = new User();
        user.setId(uid);
        user.setAccount(account-sum);
        int user_affectedRows = userCustomDao.updateAccount(user);
        System.out.println("order_count:"+user_affectedRows);
        return 0;
    }

    /**
     * 查询所有的订单
     * @return
     */
    @Override
    public List<Orders> listOrders() {
        List<Orders> list = null;
        try{
            list = ordersDao.selectByExampleWithBLOBs(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
