package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.cookbook.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:34
 */
@Repository
public interface CookBookDao {

    //菜单子类型数据过滤查询
    List<MenuSubType> queryMenuStypeByIdDao(@Param("tid") String tid) throws Exception;

    //查询菜单类型，用于前台点餐时大类的数据展示或添加菜单数据用于定位小类型
    List<MenuType> queryMenuTypeDao() throws Exception;

    //查询菜单子类型，用于前台点餐时小类的数据展示或添加菜单数据用于定位菜名
    List<MenuSubType> queryMenuSubtypeDao(@Param("tid") String tid) throws Exception;

    //前台下拉框菜单或多选框数据查询
    List<Map> queryMenuDao(@Param("stid") String stid, @Param("tid") String tid) throws Exception;

    //菜单数据查询，用于前台点餐时菜单数据的展示
    List<Menu> queryMenuDetailDao(@Param("stid") String stid, @Param("tid") String tid) throws Exception;

    //菜单做法查询，用于前台点餐时做法数据展示或添加菜单数据用于定位做法详情
    List<MenuMeans> queryMenuMeansDao(@Param("cbid") String cbid) throws Exception;

    //菜单做法详情查询，用于前台点餐时具体做法数据展示
    List<MenuMeansDetail> queryMenuMeansDetailDao(@Param("mid") String mid) throws Exception;

    //类别数据添加
    void addMenuTypeDao(MenuType msg) throws Exception;

    //小类别数据添加
    void addMenuSubtypeDao(List<MenuSubType> msg) throws Exception;

    //菜单数据添加
    void addMenuDao(List<Menu> msg) throws Exception;

    //菜单库存量数据添加
    void addInventoryDao(List<Inventory> msg) throws Exception;

    //菜单做法数据添加
    void addMenuMeansDao(List<MenuMeans> msg) throws Exception;

    //菜单详细做法数据添加
    void addMenuMeansDetailDao(List<MenuMeansDetail> msg) throws Exception;

    //套餐数据添加
    void addSetMealDao(SetMeal msg) throws Exception;

    //套餐明细数据添加
    void addSetMealDetailDao(List<SetMealDetail> msg) throws Exception;

}
