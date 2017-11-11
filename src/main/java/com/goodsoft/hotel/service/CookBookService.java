package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.param.PageParam;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:49
 */
public interface CookBookService {
    <T> T queryMenuStypeService(String tid) throws Exception;

    <T> T queryMenuTypeService() throws Exception;

    <T> T queryMenuStypeService(String tid, PageParam page) throws Exception;

    <T> T queryMenuService(String stid, PageParam page) throws Exception;

    <T> T queryMenuMeansService(String cbid, PageParam page) throws Exception;

}
