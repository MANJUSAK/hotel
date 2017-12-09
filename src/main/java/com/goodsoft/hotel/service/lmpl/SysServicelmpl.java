package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.SysDao;
import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.domain.entity.sys.Printer;
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
 * @author manjusaka Created on 2017-12-09 16:18
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service
public class SysServicelmpl implements SysService {
    @Resource
    private SysDao dao;
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /**
     * 获取系统打印机业务方法
     *
     * @param param 分页信息
     * @return Result 打印机数据
     * @throws Exception
     */
    @Override
    public <T> T queryPrinterService(HotelParam param) throws Exception {
        Page<Object> page = PageHelper.startPage(param.getPage(), param.getTotal());
        List<Printer> list = this.dao.queryPrinterDao();
        if (list.size() > 0) {
            PageInfo<Printer> data = new PageInfo<Printer>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 添加系统打印机业务方法
     *
     * @param msg 打印机数据
     * @return 添加结果
     * @throws Exception
     */
    @Transactional
    @Override
    public Status addPrinterService(Printer msg) throws Exception {
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
     * @throws Exception
     */
    @Transactional
    @Override
    public Status updatePrinterService(Printer msg) throws Exception {
        int row = this.dao.updatePrinterDao(msg);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.UPDATE_DEFEAT.getCODE(), StatusEnum.UPDATE_DEFEAT.getEXPLAIN());
    }
}
