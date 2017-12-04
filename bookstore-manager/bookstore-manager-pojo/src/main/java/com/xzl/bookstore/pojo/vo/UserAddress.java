package com.xzl.bookstore.pojo.vo;

import com.xzl.bookstore.pojo.po.Address;
import com.xzl.bookstore.pojo.po.Area;
import com.xzl.bookstore.pojo.po.City;
import com.xzl.bookstore.pojo.po.Province;

public class UserAddress {

    private Address address;
    private Province province;
    private City city;
    private Area area;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
