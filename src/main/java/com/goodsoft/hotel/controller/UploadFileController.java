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
    /**
     * 实例化日志管理类
     */
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * 文件上传接口
     * 此接口只支持图片、文档和表格文件上传且文件不宜过大（图片限制1.5M以内、表格10M以内、文档30M以内）
     * 若是其它超大文件，请走ftp文件上传接口
     *
     * @param files  文件
     * @param flag   文件标识，用于获取上传文件数据
     * @param f_type 文件类型（默认获取图片，格式为jpg、jpeg、gif、png、bmp）
     *               1.f_type=document 获取文档（pdf、doc、docx）
     *               2.f_type=excel 获取表格（xls、xlsx）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/upload/files/data.shtml", method = RequestMethod.POST)
    public Status uploadFileController(@RequestParam("files") MultipartFile[] files, String f_type, String flag) {
        if (f_type == null || "".equals(f_type)) {
            f_type = "images";
        }
        if (flag == null || "".equals(flag)) {
            flag = this.uuid.getUUID("WZ").toString();
        }
        try {
            if (files != null && !("".equals(flag))) {
                int status = this.service.fileUploadServiceImpl(files, f_type, flag);
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
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因可能是files、flag为null或为空");
        } catch (HotelDataBaseException e) {
            this.LOG.error(e.toString());
            return new Status(StatusEnum.FILE_UPLOAD.getCODE(), StatusEnum.FILE_UPLOAD.getEXPLAIN());
        }
    }
}
