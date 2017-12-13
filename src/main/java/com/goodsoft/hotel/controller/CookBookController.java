package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.cookbook.MenuMeans;
import com.goodsoft.hotel.domain.entity.cookbook.MenuMeansDetail;
import com.goodsoft.hotel.domain.entity.cookbook.MenuType;
import com.goodsoft.hotel.domain.entity.cookbook.SetMeal;
import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.param.MeansParam;
import com.goodsoft.hotel.domain.entity.param.MenuParam;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.exception.HotelDataBaseException;
import com.goodsoft.hotel.service.CookBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * ===>菜单管理访问入口接口处理类
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-07 16:27
 * @version V1.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/cookbook")
public class CookBookController {
    @Resource
    private CookBookService service;
    //实例化日志管理工具类
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 部门类别数据查询接口，用于前台下拉框或其他方式查询部门类别、
     * 用于前台点餐时大类的数据展示或添加菜单数据用于定位小类型
     * 无分页
     *
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/no/page/type/data.shtml")
    public <T> T queryTypeController() {
        try {
            return this.service.queryTypeService();
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 前台下拉框小类数据查询接口
     * 无分页
     *
     * @param tid 部门类别编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/sub/type/by/id/data.shtml")
    public <T> T queryMenuStypeByidController(String tid) {
        try {
            return this.service.queryMenuStypeService(tid);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 查询部门类别接口，用于前台点餐时大类的数据展示或添加菜单数据用于定位小类型
     * 有分页
     *
     * @param param 可传入参数：page 页码、total 总记录数
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/type/data.shtml")
    public <T> T queryMenuTypeController(HotelParam param) {
        try {
            return this.service.queryMenuTypeService(param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }

    /**
     * 小类查询接口，用于前台点餐时小类的数据展示或添加菜单数据用于定位菜名
     * 该接口下如果部门类别下无小类数据则会自动获取该部门下菜品数据
     * 传参 tid 则会自动过滤
     * 不传参 默认查询所有
     *
     * @param param 可传入参数：page 页码、total 总记录数、tid 部门类别编号、
     *              id 小类编号（注：赋值id传入数据为小类编号stid而非数据编号id）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/sub/type/data.shtml")
    public <T> T queryMenuStypeController(HotelParam param) {
        try {
            return this.service.queryMenuStypeService(param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }

    /**
     * 前台下拉框菜单或多选框数据查询接口
     * 无分页
     *
     * @param tid  部门类别编号
     * @param stid 菜单字类型编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/data.shtml")
    public <T> T queryMenuController(String stid, String tid) {
        try {
            return this.service.queryMenuService(stid, tid);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单数据查询接口，用于前台点餐或设置套餐时菜单数据的展示
     * 该接口下涵盖菜品完整数据信息
     * 注：该接口下如需查询菜品对应的图片信息时前台需传入参数setFindFile=0
     * 默认状况下不查询图片文件
     *
     * @param param 可传入参数：page 页码、total 总记录数
     *              id 菜品编号（注：赋值id传入数据为菜品编号cbid而非数据编号id）、
     *              stid 小类编号、tid 部门类别编号、keyWord 菜品名称、isSub 无小类时必传值为1、
     *              setFindFile 是否查询图片数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/detail/data.shtml")
    public <T> T queryMenuDetailController(HttpServletRequest request, HotelParam param) {
        try {
            return this.service.queryMenuDetailService(param, request);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
    }

    /**
     * 菜单做法查询接口，用于前台点餐时做法数据展示或添加菜单数据用于定位做法详情
     *
     * @param param 可传入参数：page 页码、total 总记录数
     *              id 做法编号（注：赋值id传入数据为做法编号mid而非数据编号id）、
     *              stid 小类编号、tid 部门类别编号、keyWord 做法名称、cbid 菜品编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/means/data.shtml")
    public <T> T queryMenuMeansController(HotelParam param) {
        try {
            return this.service.queryMenuMeansService(param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单做法详情查询接口，用于前台点餐时具体做法数据展示
     *
     * @param param 可传入参数：page 页码、total 总记录数
     *              id 做法详情编号（注：赋值id传入数据为做法详情编号mdid而非数据编号id）、
     *              stid 小类编号、tid 部门类别编号、keyWord 做法名称、cbid 菜品编号、mid 做法编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/means/detail/data.shtml")
    public <T> T queryMenuMeansDetailController(HotelParam param) {
        try {
            return this.service.queryMenuMeansDetailService(param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 该接口用于套餐添加过程中检查套餐是否存在
     *
     * @param sName 套餐名
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/setmeal/by/name/data.shtml")
    public String queryMenuSetmealByNameController(String sName) {
        try {
            return this.service.querySetMealByNameService(sName);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return e.getMessage();
        }
    }

    /**
     * 餐饮套餐查询接口，用于前台点餐时具体获取套餐系列菜品以及获取套餐具体明细
     * 该接口下涵盖了套餐所有明细数据
     * 注：该接口下如需查询套餐对应的图片信息时前台需传入参数setFindFile=0
     * 默认状况下不查询图片文件
     *
     * @param param 可传入参数：page 页码、total 总记录数
     *              id 套餐编号（注：赋值id传入数据为套餐编号smid而非数据编号id）、keyWord 套餐名称
     *              setFindFile 是否查询图片数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/menu/setmeal/data.shtml")
    public <T> T queryMenuSetmealController(HttpServletRequest request, HotelParam param) {
        try {
            return this.service.querySetMealService(request, param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
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
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 菜单数据、库存量数据添加接口
     *
     * @param msg 菜单数据及库存量数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/data.shtml", method = RequestMethod.POST)
    public Status addMenuService(MenuParam msg) {
        if (msg.getMenu() != null) {
            if (msg.getMenu().size() > 0) {
                try {
                    return this.service.addMenuService(msg);
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DATABASE_ERROR.getCODE(), e.getMessage());
                }
            } else {
                return new Status(StatusEnum.NO_PARAM_DATA.getCODE(), StatusEnum.NO_PARAM_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
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
                    return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_PARAM_DATA.getCODE(), StatusEnum.NO_PARAM_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
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
                    return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_PARAM_DATA.getCODE(), StatusEnum.NO_PARAM_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
    }

    /**
     * 套餐数据添加接口
     * 该接口添加数据会自动检查套餐是否存在，如果存在则是追加套餐明细，否则增加一份新的套餐。
     * 注：追加套餐明细之前会检查该套餐下是否存在相同菜品，有则覆盖追加否则迭代追加。
     *
     * @param msg 套餐数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/set/meal/data.shtml", method = RequestMethod.POST)
    public Status addSetMealController(SetMeal msg) {
        if (msg.getMealDetails() != null) {
            if (msg.getMealDetails().size() > 0) {
                try {
                    return this.service.addSetMealService(msg);
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
                }
            } else {
                return new Status(StatusEnum.NO_PARAM_DATA.getCODE(), StatusEnum.NO_PARAM_DATA.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
    }

    /**
     * 现有套餐中增加菜品接口
     *
     * @param msg 菜品数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/menu/set/meal/detail/data.shtml", method = RequestMethod.POST)
    public Status addSetMealDetailController(SetMeal msg) {
        if (msg.getMealDetails() != null) {
            try {
                return this.service.addSetMealDetailService(msg);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：mealDetails参数为空或null");
        }
    }

    /**
     * 部门类别更新接口
     * 注意：该接口下将会更新与该部门下关联的基本数据
     * （如：小类更新到其它部门那么该小类下所有关联数据都将会更新到更新的部门）
     * 传入数据必须为json
     *
     * @param msg 更新数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/menu/type/data.shtml", method = RequestMethod.POST)
    public Status updateMenuType(@RequestBody MenuType msg) {
        try {
            return this.service.updateMenuTypeService(msg);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 菜品数据及库存更新接口
     * 注意：该接口下将会更新与该菜品下关联的基本数据
     * （如：菜品更新到其它部门那么该菜品下所有关联数据都将会更新到更新的部门）
     *
     * @param msg 更新数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/menu/data.shtml", method = RequestMethod.POST)
    public Status updateMenuContorller(MenuParam msg) {
        try {
            return this.service.updateMenuService(msg);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 菜品做法数据更新接口
     * 注意：该接口下将会更新与该菜品做法下关联的基本数据
     * （如：菜品做法更新到其它部门那么该菜品下所有关联数据都将会更新到更新的部门）
     *
     * @param msg 更新数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/menu/means/data.shtml", method = RequestMethod.POST)
    public Status updateMenuMeansController(MenuMeans msg) {
        try {
            return this.service.updateMenuMeansService(msg);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 菜品做法详情数据更新接口
     *
     * @param msg 更新数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/menu/means/detail/data.shtml", method = RequestMethod.POST)
    public Status updateMenuMeansDetailController(MenuMeansDetail msg) {
        try {
            return this.service.updateMenuMeansDetailService(msg);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 部门类别数据删除接口
     * 注意：此接口下将会删除与部门类别相关联的所有数据
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/menu/type/data.shtml", method = RequestMethod.GET)
    public Status deleteMenuType(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteMenuTypeService(id);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

    /**
     * 小类数据删除接口
     * 注意：此接口下将会删除与小类相关联的所有数据
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/menu/sub/type/data.shtml", method = RequestMethod.GET)
    public Status deleteMenuSubTypeController(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteMenuSubTypeService(id);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

    /**
     * 菜品数据删除接口
     * 注意：此接口下将会删除与菜品相关联的所有数据
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/menu/data.shtml", method = RequestMethod.GET)
    public Status deleteMenuContorller(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteMenuService(id);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

    /**
     * 菜品做法数据删除接口
     * 注意：此接口下将会删除与菜品做法相关联的所有数据
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/menu/means/data.shtml", method = RequestMethod.GET)
    public Status deleteMenuMeansController(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteMenuMeansService(id);
            } catch (HotelDataBaseException e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

    /**
     * 菜品做法明细数据删除接口
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/menu/means/detail/data.shtml", method = RequestMethod.GET)
    public Status deleteMenuMeansDetailController(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteMenuMeansDetailService(id);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

    /**
     * 套餐数据删除接口
     * 注意：该接口下将会删除该套餐下说有明细数据
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/set/meal/data.shtml", method = RequestMethod.GET)
    public Status deleteSetMealController(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteSetMealService(id);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

    /**
     * 套餐明细数据删除接口
     *
     * @param id 数据id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/delete/set/meal/detail/data.shtml", method = RequestMethod.GET)
    public Status deleteSetMealDetailController(String... id) {
        if (id != null && id.length > 0) {
            try {
                return this.service.deleteSetMealDetailService(id);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id参数为空或null");
        }
    }

}
