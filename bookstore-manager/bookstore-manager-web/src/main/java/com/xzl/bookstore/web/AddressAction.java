package com.xzl.bookstore.web;

import com.xzl.bookstore.pojo.po.Address;
import com.xzl.bookstore.pojo.po.Area;
import com.xzl.bookstore.pojo.po.City;
import com.xzl.bookstore.pojo.po.Province;
import com.xzl.bookstore.service.AreaService;
import com.xzl.bookstore.service.CityService;
import com.xzl.bookstore.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AreaService areaService;

    @ResponseBody
    @RequestMapping("/add")
    public int addAddress(){
        //todo 后台管理员的地址管理
        return 0;
    }

    @ResponseBody
    @RequestMapping
    public int updateAddress(){
        //todo 后台管理员的地址管理
     return 0;
    }

    @ResponseBody
    @RequestMapping("/provinces")
    public List<Province> listProvinces(){
        List<Province> provinces = null;
        try{
            provinces = provinceService.listProviders();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return provinces;
    }
    @ResponseBody
    @RequestMapping("/cities")
    public List<City> listCities(int id){
        List<City> cities = null;
        try{
            cities = cityService.listCities(id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return cities;
    }

    @ResponseBody
    @RequestMapping("/areas")
    public List<Area> listAreas(int id){
        List<Area> areas = null;
        try{
            areas = areaService.listAreas(id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return areas;
    }
}
