package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.cookbook.MenuMeans;
import com.goodsoft.hotel.domain.entity.cookbook.MenuSubType;
import com.goodsoft.hotel.domain.entity.cookbook.MenuType;
import com.goodsoft.hotel.domain.entity.cookbook.SetMeal;
import com.goodsoft.hotel.domain.entity.param.MeansParam;
import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.CookBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * description:
 * ===>菜单管理访问入口接口处理类
 *
 * @author 严彬荣 Created on 2017-11-07 16:27
 * @version V1.0
 */
@RestController
@RequestMapping("/cookbook")
public class CookBookController {
    @Resource
    private CookBookService service;
    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(CookBookController.class);

    /**
     * 点餐主页大类小类数据展示接口，用于点餐时进入主页提供类型选择相应的菜式
     *
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/index/mean/type/data.shtml")
    public Object queryMenuTypeAndSubtypeController(PageParam page) {
        try {
            return this.service.queryTypeAndSubtypeService(page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 前台下拉框菜单子类型数据过滤接口
     *
     * @param tid 菜单类型编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/sub/type/by/id/data.shtml")
    public Object queryMenuStypeByidController(String tid) {
        try {
            return this.service.queryMenuStypeService(tid);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 查询菜单类型接口，用于前台点餐时大类的数据展示或添加菜单数据用于定位小类型
     *
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/type/data.shtml")
    public Object queryMenuTypeController(PageParam page) {
        try {
            return this.service.queryMenuTypeService(page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单子类型查询接口，用于前台点餐时小类的数据展示或添加菜单数据用于定位菜名
     *
     * @param tid  菜单类型编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/sub/type/data.shtml")
    public Object queryMenuStypeController(String tid, PageParam page) {
        try {
            return this.service.queryMenuStypeService(tid, page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 前台下拉框菜单或多选框数据查询接口
     *
     * @param stid 菜单字类型编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/data.shtml")
    public Object queryMenuController(String stid, String tid) {
        try {
            return this.service.queryMenuService(stid, tid);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单数据查询接口，用于前台点餐时菜单数据的展示
     *
     * @param stid 类别编号
     * @param tid  小类别编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/detail/data.shtml")
    public Object queryMenuDetailController(String stid, String tid, PageParam page) {
        try {
            return this.service.queryMenuDetailDao(stid, tid, page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单做法查询接口，用于前台点餐时做法数据展示或添加菜单数据用于定位做法详情
     *
     * @param cbid 菜单编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/means/data.shtml")
    public Object queryMenuMeansController(String cbid, PageParam page) {
        try {
            return this.service.queryMenuMeansService(cbid, page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单做法详情查询接口，用于前台点餐时具体做法数据展示
     *
     * @param mid  做法编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/means/detail/data.shtml")
    public Object queryMenuMeansDetailController(String mid, PageParam page) {
        try {
            return this.service.queryMenuMeansDetailService(mid, page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 餐饮套餐查询接口，用于前台点餐时具体获取套餐系列菜品以及获取套餐具体明细
     *
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/setmeal/data.shtml")
    public Object queryMenuSetmealController(PageParam page) {
        try {
            return this.service.querySetMealDao(page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }

    /**
     * 菜单类别与小类数据添加接口
     *
     * @param msg 类别与小类别数据（存在一对多关系，前台需传入json格式数据。）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/type/data.shtml", method = RequestMethod.POST)
    public Status addMenuTypeService(@RequestBody MenuType msg) {
        try {
            this.service.addMenuTypeService(msg);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }
    }

    /**
     * 菜单数据、库存量数据添加接口
     *
     * @param msg 菜单数据及库存量数据（存在一对多关系，前台需传入json格式数据。）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/data.shtml", method = RequestMethod.POST)
    public Status addMenuService(@RequestBody MenuSubType msg) {
        if (msg.getMenus() != null) {
            if (msg.getMenus().size() > 0) {
                try {
                    this.service.addMenuService(msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
    }

    /**
     * 菜单做法数据添加接口
     *
     * @param msg 菜单做法数据（存在一对多关系，前台需传入json格式数据。）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/means/data.shtml", method = RequestMethod.POST)
    public Status addMenuMeansService(@RequestBody MeansParam msg) {
        if (msg.getMeans() != null) {
            if (msg.getMeans().size() > 0) {
                try {
                    this.service.addMenuMeansService(msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
    }

    /**
     * 菜单详细做法数据添加接口
     *
     * @param msg 菜单详细做法数据（存在一对多关系，前台需传入json格式数据。）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/means/detail/data.shtml", method = RequestMethod.POST)
    public Status addMenuMeansDetailService(@RequestBody MenuMeans msg) {
        if (msg.getMeansDetails() != null) {
            if (msg.getMeansDetails().size() > 0) {
                try {
                    this.service.addMenuMeansDetailService(msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
    }

    /**
     * 套餐数据添加接口
     *
     * @param msg 套餐数据（存在一对多关系，前台需传入json格式数据。）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/set/meal/data.shtml", method = RequestMethod.POST)
    public Status addSetMealService(@RequestBody SetMeal msg) {
        if (msg.getMealDetails() != null) {
            if (msg.getMealDetails().size() > 0) {
                try {
                    this.service.addSetMealService(msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/menu/type/data.shtml", method = RequestMethod.GET)
    public Status deleteMenuType(String... id) {
        try {
            return this.service.deleteMenuTypeService(id);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }
    }
}
