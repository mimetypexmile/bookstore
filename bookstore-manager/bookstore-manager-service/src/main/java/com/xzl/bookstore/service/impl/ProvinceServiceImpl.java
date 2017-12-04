package com.xzl.bookstore.service.impl;

import com.xzl.bookstore.dao.ProvinceMapper;
import com.xzl.bookstore.pojo.po.Province;
import com.xzl.bookstore.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProvinceMapper provinceDao;
    @Override
    public List<Province> listProviders() {
        List<Province> provinces = null;
        try{
            provinces = provinceDao.selectByExample(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return provinces;
    }
}
