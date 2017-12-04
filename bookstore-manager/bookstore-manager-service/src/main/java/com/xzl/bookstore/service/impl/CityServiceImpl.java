package com.xzl.bookstore.service.impl;

import com.xzl.bookstore.dao.CityCustomMapper;
import com.xzl.bookstore.dao.CityMapper;
import com.xzl.bookstore.pojo.po.City;
import com.xzl.bookstore.pojo.po.CityExample;
import com.xzl.bookstore.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityMapper cityDao;

    @Autowired
    private CityCustomMapper cityCustomDao;

    @Override
    public List<City> listCities(int id) {
        List<City> cities = null;

        try{
            cities = cityCustomDao.listCitiesByProvinceCode(id +"");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return cities;
    }
}
