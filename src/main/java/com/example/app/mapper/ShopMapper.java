package com.example.app.mapper;

import com.example.app.entity.Dish;
import com.example.app.entity.Shop;
import com.example.app.entity.Shop_Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/17
 * Time: 2:53
 * To change this template use File | Settings | File Templates.
 **/
@Mapper
public interface ShopMapper {
    List<Shop_Type> getShopType();
    List<Shop> getAllShop();
    List<Shop> getAllShopByType(Shop_Type shop_type);
    List<Dish> getAllDish();
    List<Dish> getAllDishByShop();
}

