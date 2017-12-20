package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.FileDao;
import com.goodsoft.hotel.domain.entity.file.FileData;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.exception.HotelDataBaseException;
import com.goodsoft.hotel.service.FileService;
import com.goodsoft.hotel.util.DomainNameUtil;
import com.goodsoft.hotel.util.FileUploadUtil;
import com.goodsoft.hotel.util.GetOsNameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * function 文件上传业务接口实现类
 * Created by  manjusaka[manjusakachn@gmail.com] on 2017/8/4.
 * version v1.1.2
 */
@SuppressWarnings("ALL")
@Service
public class FileServicelmpl implements FileService {

    @Resource
    private FileUploadUtil fileUploadUtil;
    @Resource
    private FileDao dao;
    //实例化服务器域名地址工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化获取操作系统类型工具类
    private GetOsNameUtil getOsNameUtil = GetOsNameUtil.getInstance();
    //实例化日志管理
    private final Logger logger = LoggerFactory.getLogger(FileServicelmpl.class);

    /**
     * 文件上传业务处理方法
     *
     * @param files    上传的文件,
     * @param fileType 上传文件类型（图片、文档等），
     * @param fileId   文件编号（用于查询文件）。
     * @return int 文件上传处理状态（0为成功，其余都失败）
     * @throws Exception
     */
    @Override
    @Transactional
    public int fileUploadService(MultipartFile[] files, String fileType, String fileId) throws HotelDataBaseException {
        int len = files.length;
        //判断文件是图片还是文档 start
        switch (fileType) {
            case "document":
                for (int i = 0; i < len; ++i) {
                    //判断文件是否为空
                    if (!(files[i].isEmpty())) {
                        //判断文件大小是否小于30M start
                        if (files[i].getSize() > 30000000) {
                            return 601;
                        }
                        //判断文件大小是否小于30M end
                        // 获取文件名
                        String fileName = files[i].getOriginalFilename().toLowerCase();
                        // 判断文件格式是否正确 start
                        if (!(fileName.endsWith("doc") || fileName.endsWith("docx") || fileName.endsWith("pdf"))) {
                            return 603;
                        }
                        // 判断文件格式是否正确 end
                    } else {
                        return 604;
                    }
                }
                // 判断文件格是否为空 end
                break;
            //判断文件是图片还是文档 end
            //判断文件是否为Excel start
            case "excel":
                for (int i = 0; i < len; ++i) {
                    //判断文件是否为空
                    if (!(files[i].isEmpty())) {
                        //判断文件大小是否小于10M start
                        if (files[i].getSize() > 10000000) {
                            return 601;
                        }
                        //判断文件大小是否小于30M end
                        // 获取文件名
                        String fileName = files[i].getOriginalFilename().toLowerCase();
                        // 判断文件格式是否正确 start
                        if (!(fileName.endsWith("xlsx") || fileName.endsWith("xls"))) {
                            return 603;
                        }
                        // 判断文件格式是否正确 end
                    } else {
                        return 604;
                    }
                }
                // 判断文件格是否为空 end
                break;
            //判断文件是否为Excel end
            //图片文件类型检查 start
            default:
                for (int i = 0; i < len; ++i) {
                    //判断文件是否为空 start
                    if (!(files[i].isEmpty())) {
                        //判断文件大小是否小于1.5M start
                        if (files[i].getSize() > 1500000) {
                            return 601;
                        }
                        //判断文件大小是否小于1.5M start
                        // 获取文件名
                        String fileName = files[i].getOriginalFilename().toLowerCase();
                        // 判断文件格式是否正确 start
                        if (!(fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("png") || fileName.endsWith("gif"))) {
                            return 603;
                        }
                        // 判断文件格式是否正确 end
                    } else {
                        return 604;
                    }
                    //判断文件是否为空 end
                }
                break;
            //图片文件类型检查 end
        }
        //文件保存根目录
        String var1 = null;
        if (this.getOsNameUtil.getOsName()) {
            //Linux文件路径
            var1 = "/usr/hotel";
        } else {
            //windows文件路径
            var1 = "D:/hotel";
        }
        //文件保存 start
        List<String> fileList = null;
        try {
            //初始化文件保存集合
            List<FileData> list = new ArrayList<FileData>();
            //保存文件到服务器并获取文件相对路径
            fileList = this.fileUploadUtil.fileUpload(files, fileType, var1);
            String sort = null;
            //获取文件类型 start
            switch (fileType) {
                case "images":
                    sort = "images";
                    break;
                case "document":
                    sort = "document";
                    break;
                case "excel":
                    sort = "excel";
                    break;
                default:
                    sort = "filed_under";
                    break;
            }
            //获取文件类型 end
            //文件信息保存 start
            for (int i = 0, length = fileList.size(); i < length; ++i) {
                FileData file = new FileData();
                //设置文件编号
                file.setFileId(fileId);
                //设置根目录
                file.setBases(var1);
                //设置文件类别
                file.setSort(sort);
                //截取新文件名字符位置
                int j = fileList.get(i).lastIndexOf("/") + 1;
                //截取文件后缀字符位置
                int s = files[i].getOriginalFilename().lastIndexOf(".");
                //获取文件新命名
                file.setNewFileName(fileList.get(i).substring(j, fileList.get(i).length()));
                //获取原文件名
                String fileName = files[i].getOriginalFilename();
                file.setFileName(fileName);
                //获取文件后缀
                file.setSuffix(fileName.substring(s, fileName.length()));
                //设置文件路径
                file.setPath(fileList.get(i));
                list.add(file);
            }
            this.dao.saveFileDao(list);
            return 0;
            //文件信息保存 end
        } catch (Exception e) {
            this.logger.error(e.toString());
            throw new HotelDataBaseException(e.getMessage());
        } finally {
            //清除集合里的内容  避免数据混乱
            fileList.clear();
        }
        //文件保存 end
    }

    /**
     * 获取文件数据业务方法
     *
     * @param request 请求
     * @param fileId  文件编号
     * @return 文件数据
     * @throws HotelDataBaseException
     */
    @Override
    public List<String> getFileData(HttpServletRequest request, String fileId) throws HotelDataBaseException {
        //获取服务器域名地址
        String var = this.domainName.getServerDomainName(request).toString();
        StringBuilder sb = new StringBuilder();
        //查询数据对应的图片信息
        List<FileData> path = null;
        try {
            path = this.dao.queryFileDao(fileId);
        } catch (Exception e) {
            this.logger.error(e.toString());
            throw new HotelDataBaseException(StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        //封装域名地址以及图片相对路径
        List<String> url = null;
        int p = path.size();
        if (p > 0) {
            url = new ArrayList<String>();
            for (int j = 0; j < p; ++j) {
                sb.append(var);
                sb.append(path.get(j).getPath());
                url.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return url;
    }
}
