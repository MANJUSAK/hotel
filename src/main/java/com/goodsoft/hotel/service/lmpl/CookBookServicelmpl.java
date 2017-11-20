package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.CookBookDao;
import com.goodsoft.hotel.domain.entity.cookbook.*;
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
            for (int i = 0; i < len; ++i) {
                List<MenuSubType> list1 = this.dao.queryMenuSubtypeDao(list.get(i).getId());
                if (list1.size() > 0) {
                    list.get(i).setMenuSubTypes(list1);
                }
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
    public <T> T queryMenuTypeService() throws Exception {
        List<MenuType> data = this.dao.queryMenuTypeDao();
        if (data.size() > 0) {
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
     * 菜单类别与小类数据添加
     *
     * @param msg1 菜单类别及小类数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addMenuTypeService(List<MenuSubType> msg1) throws Exception {
        if (msg1 != null) {
            //设置菜单类别编号用于关联小类别表
            String id = this.uuid.getUUID().toString();
            //实例化类别实体用于设置类别数据
            MenuType msg = new MenuType();
            msg.setId(id);
            msg.settName(msg1.get(0).gettName());
            //移除集合中的类别数据
            msg1.remove(0);
            int len = msg1.size();
            if (len > 0) {
                for (int i = 0; i < len; ++i) {
                    msg1.get(i).setId(this.uuid.getUUID().toString());
                    //设置小类别表关联类别表id
                    msg1.get(i).setTid(id);
                }
                //小类别数据添加
                this.dao.addMenuSubtypeDao(msg1);
            }
            //类别数据添加
            this.dao.addMenuTypeDao(msg);
        }
    }

    /**
     * 菜单数据、库存量数据添加
     *
     * @param msg 菜单数据及库存量数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addMenuService(List<Menu> msg) throws Exception {
        if (msg != null) {
            //获取类别编号用于关联类别表
            String tid = msg.get(0).getTid();
            //获取小类别编号用于关联小类别表
            String stid = msg.get(0).getStid();
            //移除集合中类别与小类别数据
            msg.remove(0);
            int len = msg.size();
            //设置菜单添加时间
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (len > 0) {
                //设置库存量数据集合容器
                List<Inventory> msg1 = new ArrayList<Inventory>();
                for (int i = 0; i < len; ++i) {
                    //实例化库存量实体，用于设置菜单库存量数据
                    Inventory inv = new Inventory();
                    //设置菜单数据编号
                    String id = this.uuid.getUUID().toString();
                    //设置库存量数据编号
                    String ids = this.uuid.getUUID().toString();
                    msg.get(i).setId(id);
                    msg.get(i).setTid(tid);
                    msg.get(i).setStid(stid);
                    inv.setId(ids);
                    inv.setNum(msg.get(i).getNum());
                    inv.setDate(date);
                    //设置关联菜单表id
                    inv.setCbid(id);
                    msg1.add(inv);
                }
                //库存量数据添加
                this.dao.addInventoryDao(msg1);
            }
            //菜单数据添加
            this.dao.addMenuDao(msg);
        }
    }

    /**
     * 菜单做法数据添加
     *
     * @param msg 菜单做法数据
     * @throws Exception
     */
    @Override
    @Transactional
    public void addMenuMeansService(List<MenuMeans> msg) throws Exception {
        if (msg != null) {
            //获取菜单编号用于关联菜单表，并移除集合中的菜单编号
            String cbid = msg.get(0).getCbid();
            msg.remove(0);
            int len = msg.size();
            //设置做法数据
            if (len > 0) {
                for (int i = 0; i < len; ++i) {
                    msg.get(i).setId(this.uuid.getUUID().toString());
                    //设置关联菜单表id
                    msg.get(i).setCbid(cbid);
                }
                this.dao.addMenuMeansDao(msg);
            }
        }
    }

    /**
     * 菜单详细做法数据添加
     *
     * @param msg 菜单详细做法数据
     * @throws Exception
     */
    @Transactional
    @Override
    public void addMenuMeansDetailService(List<MenuMeansDetail> msg) throws Exception {
        if (msg != null) {
            //获取做法编号用于关联详细做法，并移除集合中的做法编号
            String mid = msg.get(0).getMid();
            msg.remove(0);
            int len = msg.size();
            //设置详细做法数据
            if (len > 0) {
                for (int i = 0; i < len; ++i) {
                    msg.get(i).setId(this.uuid.getUUID().toString());
                    //设置关联做法表id
                    msg.get(i).setMid(mid);
                }
                this.dao.addMenuMeansDetailDao(msg);
            }
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
    public void addSetMealService(List<SetMealDetail> msg) throws Exception {
        if (msg != null) {
            //设置套餐编号，用于关联套餐明细表
            String id = this.uuid.getUUID().toString();
            //设置套餐数据
            SetMeal meal = new SetMeal();
            meal.setId(id);
            meal.setSmName(msg.get(0).getSmName());
            meal.setIsdd(msg.get(0).getIsdd());
            meal.setIsNo(msg.get(0).getIsNo());
            meal.setStPrice(msg.get(0).getStPrice());
            //设置套餐明细数据，需移除套餐数据以保证数据单一性
            msg.remove(0);
            int len = msg.size();
            if (len > 0) {
                for (int i = 0; i < len; ++i) {
                    //若明细数据不合法需移除
                    if (msg.get(i).getCbid() == null) {
                        msg.remove(i);
                        --i;
                        len = msg.size();
                    }
                    msg.get(i).setId(this.uuid.getUUID().toString());
                    //关联套餐编号
                    msg.get(i).setSmid(id);
                }
                //套餐明细数据添加
                this.dao.addSetMealDetailDao(msg);
            }
            //套餐数据添加
            this.dao.addSetMealDao(meal);
        }
    }
}
