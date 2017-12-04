package com.xzl.bookstore.web;

import com.xzl.bookstore.common.util.IDUtils;
import com.xzl.bookstore.common.util.JsonUtils;
import com.xzl.bookstore.pojo.dto.BookDTO;
import com.xzl.bookstore.pojo.po.Book;
import com.xzl.bookstore.pojo.po.Orders;
import com.xzl.bookstore.pojo.po.User;
import com.xzl.bookstore.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/order")
@Controller
public class OrderAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderService orderService;


    @ResponseBody
    @RequestMapping("/searchOrders")
    public List<Orders> listOrders(){
        List<Orders> list = null;

        try{
            list = orderService.listOrders();

            String content = list.get(0).getContent();

            List<BookDTO> bookDTOS = JsonUtils.jsonToList(content, BookDTO.class);
            System.out.println(bookDTOS);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 下订单
     * @param orders
     * @param ids
     * @param booknames
     * @param prices
     * @param counts
     * @param session
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/bookOrder")
    public int saveOrder(Orders orders,@RequestParam(value = "ids[]",defaultValue = "")Long[] ids,@RequestParam("booknames[]") String[] booknames,
            @RequestParam("prices[]") Long[] prices, @RequestParam("counts[]") Integer[] counts, HttpSession session, HttpServletResponse response) throws IOException {
        User loginUser = (User) session.getAttribute("loginUser");
//        if(loginUser == null){
//            //todo 跳转到登录界面
//            response.sendRedirect("");
//        }
//        创订单
        orders.setOrderId(IDUtils.generateId());
        orders.setUid(((User)session.getAttribute("loginUser")).getId());
        orders.setCreated(new Date());
        orders.setStatus((byte)1);
        List<BookDTO> bookDTOList = new ArrayList<>(16);
        BookDTO bookDTO = new BookDTO();
        for(int i = 0;i<counts.length;i++){
            bookDTO.setId(ids[i]);
            bookDTO.setBookname(booknames[i]);
            bookDTO.setPrice(prices[i]);
            bookDTO.setCount(counts[i]);
            bookDTOList.add(bookDTO);
        }
        String content = JsonUtils.objectToJson(bookDTOList);
        orders.setContent(content);
        int i = 0;
        try {
            i = orderService.saveOrder(orders);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/pay")
    public String payOrder(@RequestParam("ids[]") List<Long> ids,HttpSession session){
        //todo 支付操作，账户减少钱，订单状态更改，书籍库存减少
//        User loginUser = (User)session.getAttribute("loginUser");
//        if(loginUser == null){
//            //重定向
//
//        }
        int count = 0;
        try{
            //count = orderService.payOrder(ids,loginUser.getId());
            count = orderService.payOrder(ids,1L);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }
}
