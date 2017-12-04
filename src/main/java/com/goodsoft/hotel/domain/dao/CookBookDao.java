package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.cookbook.*;
import com.goodsoft.hotel.domain.entity.param.DatabasesParam;
import com.goodsoft.hotel.domain.entity.param.HotelParam;
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

    //查询部门类别是否重复
    String queryMenuTypeByNameDao(@Param("tName") String tName) throws Exception;

    //查询菜单子类型，用于前台点餐时小类的数据展示或添加菜单数据用于定位菜名
    List<MenuSubType> queryMenuSubtypeDao(HotelParam msg) throws Exception;

    //前台下拉框菜单或多选框数据查询
    List<Map> queryMenuDao(@Param("stid") String stid, @Param("tid") String tid) throws Exception;

    //菜单数据查询，用于前台点餐时菜单数据的展示
    List<Menu> queryMenuDetailDao(HotelParam msg) throws Exception;

    //菜单做法查询，用于前台点餐时做法数据展示或添加菜单数据用于定位做法详情
    List<MenuMeans> queryMenuMeansDao(HotelParam msg) throws Exception;

    //菜单做法详情查询，用于前台点餐时具体做法数据展示
    List<MenuMeansDetail> queryMenuMeansDetailDao(HotelParam msg) throws Exception;

    //餐饮套餐查询，用于前台点餐时具体获取套餐系列菜品
    List<SetMeal> querySetMealDao(HotelParam param) throws Exception;

    //餐饮套餐详细菜品查询，用于前台点餐时具体获取套餐系列具体菜品数据
    List<SetMealDetail> querySetMealDetailDao(@Param("smid") String smid) throws Exception;

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

    //部门类别更新
    int updateMenuTypeDao(MenuType msg) throws Exception;

    //小类更新
    int updateMenuSubTypeDao(MenuSubType msg) throws Exception;

    //菜品更新
    int updateMenuDao(Menu msg) throws Exception;

    //库存量更新
    int updateInventoryDao(Inventory msg) throws Exception;

    //菜品做法更新
    int updateMenuMeansDao(MenuMeans msg) throws Exception;

    //菜品做法明细更新
    int updateMenuMeansDetailDao(MenuMeansDetail msg) throws Exception;

    //套餐更新
    int updateSetMealDao(SetMeal msg) throws Exception;

    //套餐明细更新
    int updateSetMealDetailDao(SetMealDetail msg) throws Exception;

    //更新餐饮菜品管理表关联数据通用dao方法
    int updateCookBookAllDao(DatabasesParam msg) throws Exception;

    //部门类别删除
    int deleteMenuTypeDao(@Param("id") String... id) throws Exception;

    //小类删除
    int deleteMenuSubTypeDao(@Param("id") String[] id, @Param("rel") int rel) throws Exception;

    //菜品删除
    int deleteMenuDao(@Param("id") String[] id, @Param("rel") int rel) throws Exception;

    //菜品做法删除
    int deleteMenuMeansDao(@Param("id") String[] id, @Param("rel") int rel) throws Exception;

    //菜品做法明细删除
    int deleteMenuMeansDetailDao(@Param("id") String[] id, @Param("rel") int rel) throws Exception;

    //套餐删除
    int deleteSetMealDao(String... id) throws Exception;

    //套餐明细删除
    int deleteSetMealDetailDao(@Param("id") String[] id, @Param("rel") int rel) throws Exception;

}
