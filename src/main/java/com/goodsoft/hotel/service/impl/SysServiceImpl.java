package com.goodsoft.hotel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.SysDao;
import com.goodsoft.hotel.domain.entity.dto.HotelDTO;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.domain.entity.sys.PrinterDO;
import com.goodsoft.hotel.service.SysService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>系统组件业务接口实现类,设置系统功能属性
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-09 16:18
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service("sysServiceImpl")
public class SysServiceImpl implements SysService {
    @Resource
    private SysDao dao;
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /**
     * 获取系统打印机业务方法
     *
     * @param param 分页信息
     * @return Result 打印机数据
     * @throws Exception 异常
     */
    @Override
    public <T> T queryPrinterService(HotelDTO param) throws Exception {
        Page<T> page = PageHelper.startPage(param.getPage(), param.getTotal());
        List<PrinterDO> list = this.dao.queryPrinterDao();
        if (list.size() > 0) {
            PageInfo<PrinterDO> data = new PageInfo<PrinterDO>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 添加系统打印机业务方法
     *
     * @param msg 打印机数据
     * @return 添加结果
     * @throws Exception 异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Status addPrinterService(PrinterDO msg) throws Exception {
        msg.setId(this.uuid.getUUID().toString());
        int row = this.dao.addPrinterDao(msg);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.INSERT_DEFEAT.getCODE(), StatusEnum.INSERT_DEFEAT.getEXPLAIN());
    }

    /**
     * 更新打印机业务方法
     *
     * @param msg 打印机数据
     * @return 添加结果
     * @throws Exception 异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Status updatePrinterService(PrinterDO msg) throws Exception {
        int row = this.dao.updatePrinterDao(msg);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.UPDATE_DEFEAT.getCODE(), StatusEnum.UPDATE_DEFEAT.getEXPLAIN());
    }

    /**
     * 删除打印机业务方法
     *
     * @param id 数据id
     * @return 添加结果
     * @throws Exception 异常
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Status deletePrinterService(String... id) throws Exception {
        int row = this.dao.deletePrinterDao(id);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DELETE_DEFEAT.getCODE(), StatusEnum.DELETE_DEFEAT.getEXPLAIN());
    }
}
