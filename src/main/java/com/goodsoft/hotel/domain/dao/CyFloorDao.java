package com.goodsoft.hotel.domain.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by duyuxiang on 2017/11/17.
 * 餐饮楼面
 */
@Repository
public interface CyFloorDao {

    //查询所有餐台
    public List<Map> selectTableInfos(Map map);



}
