package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.exception.HotelDataBaseException;
import com.goodsoft.hotel.service.FileService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * description:
 * ===>文件上传api，对外部系统提供文件上传接口
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-20 20:53
 * @version V1.1.2
 */
@RestController
@RequestMapping("/list")
public class UploadFileController {
    @Resource
    private FileService service;
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化日志管理类
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 文件上传接口
     *
     * @param files 文件
     * @param var   文件标识，用于获取上传文件数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/upload/files/data.shtml", method = RequestMethod.POST)
    public Status uploadFileController(@RequestParam("files") MultipartFile[] files, String var) {
        try {
            if (files != null && var != null && !("".equals(var))) {
                int status = this.service.fileUploadService(files, "images", var);
                switch (status) {
                    case 0:
                        return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                    case 601:
                        return new Status(StatusEnum.FILE_SIZE.getCODE(), StatusEnum.FILE_SIZE.getEXPLAIN());
                    case 603:
                        return new Status(StatusEnum.FILE_FORMAT.getCODE(), StatusEnum.FILE_FORMAT.getEXPLAIN());
                    case 604:
                        return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                    default:
                        return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
                }
            }
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "files、var为空或为null");
        } catch (HotelDataBaseException e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
        }
    }
}
