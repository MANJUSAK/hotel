package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.CookBookDao;
import com.goodsoft.hotel.domain.entity.cookbook.*;
import com.goodsoft.hotel.domain.entity.param.MeansParam;
import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.CookBookService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * description:
 * ===>菜单管理业务接口实现类,用于管理菜单各类数据查询，添加。
 *
 * @author 严彬荣 Created on 2017-11-07 16:50
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service
public class CookBookServicelmpl implements CookBookService {

    @Resource
    private CookBookDao dao;
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /**
     * 点餐主页大类小类数据展示业务方法，用于点餐时进入主页提供类型选择相应的菜式
     *
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryTypeAndSubtypeService(PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<MenuType> list = this.dao.queryMenuTypeDao();
        int len = list.size();
        if (len > 0) {
            List<MenuSubType> list1 = this.dao.queryMenuSubtypeDao(list.get(0).getId());
            if (list1.size() > 0) {
                list.get(0).setMenuSubTypes(list1);
            }
            PageInfo<MenuType> data = new PageInfo<MenuType>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 前台下拉框菜单小类数据过滤业务方法
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
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单类型，用于前台点餐时大类的数据展示或添加菜单数据用于定位小类型业务方法
     *
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuTypeService(PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<MenuType> list = this.dao.queryMenuTypeDao();
        if (list.size() > 0) {
            PageInfo<MenuType> data = new PageInfo<MenuType>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询菜单子类型，用于前台点餐时小类的数据展示或添加菜单数据用于定位菜名业务方法
     *
     * @param tid  菜单类型编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuStypeService(String tid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<MenuSubType> list = this.dao.queryMenuSubtypeDao(tid);
        if (list.size() > 0) {
            PageInfo<T> data = (PageInfo<T>) new PageInfo<>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 前台下拉框菜单或多选框数据查询业务方法
     *
     * @param stid 菜单字类型编号
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuService(String stid, String tid) throws Exception {
        List<Map> data = this.dao.queryMenuDao(stid, tid);
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 菜单数据查询，用于前台点餐时菜单数据的展示业务方法
     *
     * @param stid 类别编号
     * @param tid  小类别编号
     * @param page 分页数据
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuDetailDao(String stid, String tid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<Menu> list = this.dao.queryMenuDetailDao(stid, tid);
        if (list.size() > 0) {
            PageInfo<Menu> data = new PageInfo<Menu>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 菜单做法查询，用于前台点餐时做法数据展示或添加菜单数据用于定位做法详情业务方法
     *
     * @param cbid 菜单编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuMeansService(String cbid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<MenuMeans> list = this.dao.queryMenuMeansDao(cbid);
        if (list.size() > 0) {
            PageInfo<MenuMeans> data = new PageInfo<>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 菜单做法详情查询，用于前台点餐时具体做法数据展示业务方法
     *
     * @param mid  做法编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryMenuMeansDetailService(String mid, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<MenuMeansDetail> list = this.dao.queryMenuMeansDetailDao(mid);
        if (list.size() > 0) {
            PageInfo<MenuMeansDetail> data = new PageInfo<>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 餐饮套餐查询业务方法，用于前台点餐时具体获取套餐系列菜品以及获取套餐具体明细
     *
     * @param page 分页信息
     * @param <T>
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T querySetMealDao(PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        List<SetMeal> list = this.dao.querySetMealDao();
        int len = list.size();
        if (len > 0) {
            for (int i = 0; i < len; ++i) {
                List<SetMealDetail> detailList = this.dao.querySetMealDetailDao(list.get(i).getId());
                list.get(i).setMealDetails(detailList);
            }
            PageInfo<SetMeal> data = new PageInfo<SetMeal>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }


    /**
     * 菜单类别与小类数据添加
     *
     * @param msg1 菜单类别及小类数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addMenuTypeService(MenuType msg) throws Exception {
        //设置菜单类别编号用于关联小类别表
        String id = this.uuid.getUUID().toString();
        msg.setId(id);
        if (msg.getMenuSubTypes() != null) {
            int len = msg.getMenuSubTypes().size();
            if (len > 0) {
                List<MenuSubType> msg1 = msg.getMenuSubTypes();
                for (int i = 0; i < len; ++i) {
                    msg1.get(i).setId(this.uuid.getUUID().toString());
                    //设置小类别表关联类别表id
                    msg1.get(i).setTid(id);
                }
                //小类别数据添加
                this.dao.addMenuSubtypeDao(msg1);
            }
        }
        //类别数据添加
        this.dao.addMenuTypeDao(msg);
    }

    /**
     * 菜单数据、库存量数据添加
     *
     * @param msg 菜单数据及库存量数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addMenuService(MenuSubType msg) throws Exception {
        List<Menu> menus = msg.getMenus();
        //获取类别编号用于关联类别表
        String tid = msg.getTid();
        //获取小类别编号用于关联小类别表
        String stid = msg.getSbid();
        //设置菜单添加时间
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //设置库存量数据集合容器
        List<Inventory> msg1 = new ArrayList<Inventory>();
        for (int i = 0, len = menus.size(); i < len; ++i) {
            //实例化库存量实体，用于设置菜单库存量数据
            Inventory inv = new Inventory();
            //设置菜单数据编号
            String id = this.uuid.getUUID().toString();
            //设置库存量数据编号
            String ids = this.uuid.getUUID().toString();
            menus.get(i).setId(id);
            menus.get(i).setTid(tid);
            menus.get(i).setStid(stid);
            inv.setId(ids);
            inv.setTid(tid);
            inv.setStid(stid);
            inv.setNum(menus.get(i).getNum());
            inv.setDate(date);
            //设置关联菜单表id
            inv.setCbid(id);
            msg1.add(inv);
        }
        //库存量数据添加
        this.dao.addInventoryDao(msg1);
        //菜单数据添加
        this.dao.addMenuDao(menus);
    }

    /**
     * 菜单做法数据添加
     *
     * @param msg 菜单做法数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addMenuMeansService(MeansParam msg) throws Exception {
        String tid = msg.getTid();
        String stid = msg.getStid();
        String cbid = msg.getCbid();
        List<MenuMeans> means = msg.getMeans();
        for (int i = 0, len = means.size(); i < len; ++i) {
            means.get(i).setId(this.uuid.getUUID().toString());
            means.get(i).setTid(tid);
            means.get(i).setStid(stid);
            //设置关联菜单表id
            means.get(i).setCbid(cbid);
        }
        this.dao.addMenuMeansDao(means);
    }

    /**
     * 菜单详细做法数据添加
     *
     * @param msg 菜单详细做法数据
     * @throws Exception
     */
    @Transactional
    @Override
    public void addMenuMeansDetailService(MenuMeans msg) throws Exception {
        if (msg != null) {
            //获取做法编号用于关联详细做法，并移除集合中的做法编号
            String mid = msg.getMdid();
            String tid = msg.getTid();
            String stid = msg.getStid();
            String cbid = msg.getCbid();
            List<MenuMeansDetail> mdt = msg.getMeansDetails();
            for (int i = 0, len = mdt.size(); i < len; ++i) {
                mdt.get(i).setId(this.uuid.getUUID().toString());
                //设置关联做法表id
                mdt.get(i).setMid(mid);
                mdt.get(i).setTid(tid);
                mdt.get(i).setStid(stid);
                mdt.get(i).setCbid(cbid);
            }
            this.dao.addMenuMeansDetailDao(mdt);
        }
    }

    /**
     * 套餐数据添加,包含有套餐明细数据
     *
     * @param msg 套餐数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addSetMealService(SetMeal msg) throws Exception {
        //设置套餐编号，用于关联套餐明细表
        String id = this.uuid.getUUID().toString();
        msg.setId(id);
        List<SetMealDetail> mealDetails = msg.getMealDetails();
        for (int i = 0, len = mealDetails.size(); i < len; ++i) {
            mealDetails.get(i).setId(this.uuid.getUUID().toString());
            //关联套餐编号
            mealDetails.get(i).setSmid(id);
        }
        //套餐明细数据添加
        this.dao.addSetMealDetailDao(mealDetails);
        //套餐数据添加
        this.dao.addSetMealDao(msg);
    }

    @Override
    public Status updateMenuTypeService(MenuType msg) throws Exception {
        return null;
    }

    @Override
    public Status updateMenuService(MenuSubType msg) throws Exception {
        return null;
    }

    @Override
    public Status updateMenuMeansService(MeansParam msg) throws Exception {
        return null;
    }

    @Override
    public Status updateMenuMeansDetailService(MenuMeans msg) throws Exception {
        return null;
    }

    @Override
    public Status updateSetMealService(SetMeal msg) throws Exception {
        return null;
    }

    /**
     * 删除部门类别业务方法
     *
     * @param id 数据编号
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteMenuTypeService(String... id) throws Exception {
        int row = this.dao.deleteMenuTypeDao(id);
        if (row > 0) {
            //删除部门类别数据同时删除该部门类别数据下所有相关联的数据
            try {
                //小类数据
                this.dao.deleteMenuSubTypeDao(id, 1);
                //菜品数据
                this.dao.deleteMenuDao(id, 1);
                //菜品做法数据
                this.dao.deleteMenuMeansDao(id, 1);
                //菜品明细做法数据
                this.dao.deleteMenuMeansDetailDao(id, 1);
                //套餐明细数据
                this.dao.deleteSetMealDetailDao(id, 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除小类业务方法
     *
     * @param id 数据id
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteMenuSubTypeService(String... id) throws Exception {
        int row = this.dao.deleteMenuSubTypeDao(id, 0);
        if (row > 0) {
            //删除小类数据同时删除该小类下所有相关联数据
            try {
                //菜品数据
                this.dao.deleteMenuDao(id, 2);
                //菜品做法数据
                this.dao.deleteMenuMeansDao(id, 2);
                //菜品做法明细数据
                this.dao.deleteMenuMeansDetailDao(id, 2);
                //套餐明细数据
                this.dao.deleteSetMealDetailDao(id, 11);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除菜品数据业务方法
     *
     * @param id 数据编号
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteMenuService(String... id) throws Exception {
        int row = this.dao.deleteMenuDao(id, 0);
        if (row > 0) {
            //删除菜品数据同时删除该菜品下关联的所有数据
            try {
                //做法数据
                this.dao.deleteMenuMeansDao(id, 3);
                //明细做法数据
                this.dao.deleteMenuMeansDetailDao(id, 3);
                //套餐明细数据
                this.dao.deleteSetMealDetailDao(id, 12);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除菜品做法业务方法
     *
     * @param id 数据编号
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteMenuMeansService(String... id) throws Exception {
        int row = this.dao.deleteMenuMeansDao(id, 0);
        if (row > 0) {
            //删除菜品做法数据同时删除该做法下所有相关数据
            try {
                this.dao.deleteMenuMeansDetailDao(id, 4);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除菜品明细做法业务方法
     *
     * @param id 数据编号
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteMenuMeansDetailService(String... id) throws Exception {
        int row = this.dao.deleteMenuMeansDetailDao(id, 0);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除套餐数据业务方法
     *
     * @param id 数据编号
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteSetMealService(String... id) throws Exception {
        int row = this.dao.deleteSetMealDao(id);
        if (row > 0) {
            //删除套餐数据同时删除与此套餐相关联数据
            try {
                this.dao.deleteSetMealDetailDao(id, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除套餐明细数据业务方法
     *
     * @param id 数据编号
     * @return 删除结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status deleteSetMealDetailService(String... id) throws Exception {
        int row = this.dao.deleteSetMealDetailDao(id, 0);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }

}
