package com.goodsoft.hotel.service;

import com.goodsoft.hotel.exception.HotelDataBaseException;
import org.springframework.web.multipart.MultipartFile;

/**
 * function 文件上传业务接口
 * Created by 严彬荣 on 2017/8/4.
 * version v1.0
 */
public interface FileService {
    //文件上传业务处理
    public int fileUploadService(MultipartFile[] files, String fileType, String fileId) throws HotelDataBaseException;
}
