package com.xzl.bookstore.service.impl;

import com.xzl.bookstore.dao.AreaCustomMapper;
import com.xzl.bookstore.dao.AreaMapper;
import com.xzl.bookstore.pojo.po.Area;
import com.xzl.bookstore.pojo.po.AreaExample;
import com.xzl.bookstore.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AreaServiceImpl implements AreaService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AreaMapper areaDao;

    @Autowired
    private AreaCustomMapper areaCustomDao;
    @Override
    public List<Area> listAreas(int id) {
        List<Area> areas = null;

        try{
            areas = areaCustomDao.listCitiesByCityCode(id+"");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return areas;
    }
}
