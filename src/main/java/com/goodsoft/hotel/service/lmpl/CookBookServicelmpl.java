package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.CookBookDao;
import com.goodsoft.hotel.domain.entity.cookbook.Menu;
import com.goodsoft.hotel.domain.entity.cookbook.MenuMeans;
import com.goodsoft.hotel.domain.entity.cookbook.MenuSubType;
import com.goodsoft.hotel.domain.entity.cookbook.MenuType;
import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.CookBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>
 *
 * @author 严彬荣 Created on 2017-11-07 16:50
 */
@SuppressWarnings("ALL")
@Service
public class CookBookServicelmpl implements CookBookService {

    @Resource
    private CookBookDao dao;

    /**
     * 菜单子类型数据过滤业务方法
     *
     * @param tid 菜单类型编号
     * @param <T>
     * @return 过滤数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuStypeService(String tid) throws Exception {
        List<MenuSubType> data = this.dao.queryMenuStypeByIdDao(tid);
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(0, "无");
    }

    /**
     * 查询菜单数据业务方法
     *
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuTypeService() throws Exception {
        List<MenuType> data = this.dao.queryMenuTypeDao();
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单子类型数据业务方法
     *
     * @param tid  菜单类型编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuStypeService(String tid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTatol());
        List<MenuSubType> data = this.dao.queryMenuSubtypeDao(tid);
        if (data.size() > 0) {
            PageInfo<MenuSubType> pageInfo = new PageInfo<>(data);
            Result result = new Result();
            result.setData(data);
            result.setErrorCode(0);
            result.setFirstPage(pageInfo.isIsFirstPage());
            result.setLastPage(pageInfo.isIsLastPage());
            result.setTatol(pageInfo.getTotal());
            result.setPage(pageInfo.getPages());
            result.getPageSize(pageInfo.getPageSize());
            return (T) result;
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单数据业务方法
     *
     * @param stid 菜单字类型编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuService(String stid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTatol());
        List<Menu> data = this.dao.queryMenuDao(stid);
        if (data.size() > 0) {
            PageInfo<Menu> pageInfo = new PageInfo<>(data);
            Result result = new Result();
            result.setData(data);
            result.setErrorCode(0);
            result.setFirstPage(pageInfo.isIsFirstPage());
            result.setLastPage(pageInfo.isIsLastPage());
            result.setTatol(pageInfo.getTotal());
            result.setPage(pageInfo.getPages());
            result.getPageSize(pageInfo.getPageSize());
            return (T) result;
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单做法数据业务方法
     *
     * @param cbid 菜单编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuMeansService(String cbid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTatol());
        List<MenuMeans> data = this.dao.queryMenuMeansDao(cbid);
        if (data.size() > 0) {
            PageInfo<MenuMeans> pageInfo = new PageInfo<>(data);
            Result result = new Result();
            result.setData(data);
            result.setErrorCode(0);
            result.setFirstPage(pageInfo.isIsFirstPage());
            result.setLastPage(pageInfo.isIsLastPage());
            result.setTatol(pageInfo.getTotal());
            result.setPage(pageInfo.getPages());
            result.getPageSize(pageInfo.getPageSize());
            return (T) result;
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }
}
