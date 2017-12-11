package com.goodsoft.hotel.service.supp;

import com.goodsoft.hotel.domain.dao.FileDao;
import com.goodsoft.hotel.domain.entity.file.FileData;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.exception.HotelDataBaseException;
import com.goodsoft.hotel.service.FileService;
import com.goodsoft.hotel.util.DomainNameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * function 获取文件辅助功能类
 * Created by 严彬荣 on 2017/9/21.
 * version v1.0
 */
@SuppressWarnings("ALL")
@Service
public class ServicelmplGetFileSupp {
    @Resource
    private FileService fileService;
    @Resource
    private FileDao fileDao;
    //实例化服务器域名地址工具类
    private DomainNameUtil domainName = DomainNameUtil.getInstance();
    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(ServicelmplGetFileSupp.class);

    /**
     * 获取苗木文件数据业务实现辅助方法
     *
     * @param request 请求
     * @param fileId  文件编号
     * @return 文件数据
     * @throws Exception
     */
    public List<String> getFileData(HttpServletRequest request, String fileId) throws HotelDataBaseException {
        //获取服务器域名地址
        String var = this.domainName.getServerDomainName(request).toString();
        StringBuilder sb = new StringBuilder();
        //查询数据对应的图片信息
        List<FileData> path = null;
        try {
            path = this.fileDao.queryFileDao(fileId);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            throw new HotelDataBaseException(StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        //封装域名地址以及图片相对路径
        List url = null;
        int p = path.size();
        if (p > 0) {
            url = new ArrayList();
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
