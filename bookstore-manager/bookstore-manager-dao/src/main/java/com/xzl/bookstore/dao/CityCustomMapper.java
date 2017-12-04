package com.xzl.bookstore.dao;


import com.xzl.bookstore.pojo.po.City;

import java.util.List;

public interface CityCustomMapper {
    List<City> listCitiesByProvinceCode(String provincecode);
}