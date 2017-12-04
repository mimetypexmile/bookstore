package com.xzl.bookstore.dao;

import com.xzl.bookstore.pojo.po.Orders;
import com.xzl.bookstore.pojo.po.OrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExampleWithBLOBs(OrdersExample example);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExampleWithBLOBs(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKeyWithBLOBs(Orders record);

    int updateByPrimaryKey(Orders record);
}