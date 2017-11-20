package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.cookbook.*;
import com.goodsoft.hotel.domain.entity.param.PageParam;

import java.util.List;

/**
 * description:
 * ===>菜单管理业务类
 *
 * @author 严彬荣 Created on 2017-11-07 16:49
 * @version V1.0
 */
public interface CookBookService {

    //点餐主页大类小类数据展示业务方法，用于点餐时进入主页提供类型选择
    <T> T queryTypeAndSubtypeService(PageParam page) throws Exception;

    //前台下拉框菜单小类数据过滤
    <T> T queryMenuStypeService(String tid) throws Exception;

    //查询菜单类型，用于前台点餐时大类的数据展示或添加菜单数据用于定位小类型
    <T> T queryMenuTypeService() throws Exception;

    //查询菜单子类型，用于前台点餐时小类的数据展示或添加菜单数据用于定位菜名
    <T> T queryMenuStypeService(String tid, PageParam page) throws Exception;

    //前台下拉框菜单或多选框数据查询
    <T> T queryMenuService(String stid, String tid) throws Exception;

    //菜单数据查询，用于前台点餐时菜单数据的展示
    <T> T queryMenuDetailDao(String stid, String tid, PageParam page) throws Exception;

    //菜单做法查询，用于前台点餐时做法数据展示或添加菜单数据用于定位做法详情
    <T> T queryMenuMeansService(String cbid, PageParam page) throws Exception;

    //菜单做法详情查询，用于前台点餐时具体做法数据展示
    <T> T queryMenuMeansDetailService(String mid, PageParam page) throws Exception;

    //菜单类别与小类数据添加
    void addMenuTypeService(List<MenuSubType> msg1) throws Exception;

    //菜单数据、库存量数据添加
    void addMenuService(List<Menu> msg) throws Exception;

    //菜单做法数据添加
    void addMenuMeansService(List<MenuMeans> msg) throws Exception;

    //菜单详细做法数据添加
    void addMenuMeansDetailService(List<MenuMeansDetail> msg) throws Exception;

    //套餐数据添加
    void addSetMealService(List<SetMealDetail> msg) throws Exception;

}
