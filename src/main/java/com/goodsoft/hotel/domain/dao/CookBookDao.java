package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.cookbook.Menu;
import com.goodsoft.hotel.domain.entity.cookbook.MenuMeans;
import com.goodsoft.hotel.domain.entity.cookbook.MenuSubType;
import com.goodsoft.hotel.domain.entity.cookbook.MenuType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:34
 */
@Repository
public interface CookBookDao {
    /**
     * 菜单子类型数据过滤查询
     *
     * @return 过滤数据
     * @throws Exception
     */
    List<MenuSubType> queryMenuStypeByIdDao(@Param("tid") String tid) throws Exception;

    List<MenuType> queryMenuTypeDao() throws Exception;

    List<MenuSubType> queryMenuSubtypeDao(@Param("tid") String tid) throws Exception;

    List<Menu> queryMenuDao(@Param("stid") String stid) throws Exception;

    List<MenuMeans> queryMenuMeansDao(@Param("cbid") String cbid) throws Exception;

}
