package com.xzl.bookstore.dao;


import com.xzl.bookstore.pojo.po.Area;

import java.util.List;

public interface AreaCustomMapper {
    List<Area> listCitiesByCityCode(String citycode);
}