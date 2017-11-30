package com.goodsoft.hotel.service.supp;

import com.goodsoft.hotel.domain.dao.FileDao;
import com.goodsoft.hotel.domain.entity.file.FileData;
import com.goodsoft.hotel.service.FileService;
import com.goodsoft.hotel.util.DomainNameUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * function 苗圃管理接口实现获取文件辅助功能类
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

    /**
     * 获取苗木文件数据业务实现辅助方法
     *
     * @param request 请求
     * @param fileId  文件编号
     * @return 文件数据
     * @throws Exception
     */
    public List<String> getFileData(HttpServletRequest request, String fileId) throws Exception {
        //获取服务器域名地址
        String var = this.domainName.getServerDomainName(request).toString();
        StringBuilder sb = new StringBuilder();
        //查询数据对应的图片信息
        List<FileData> path = this.fileDao.queryFileDao(fileId);
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
