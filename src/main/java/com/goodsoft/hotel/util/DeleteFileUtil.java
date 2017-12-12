package com.goodsoft.hotel.util;

import com.goodsoft.hotel.domain.entity.file.FileData;

import java.io.File;
import java.util.List;

/**
 * function 文件删除工具类
 * Created by  manjusaka[manjusakachn@gmail.com] on 2017/9/11.
 * @version v1.0
 */
@SuppressWarnings("ALL")
public class DeleteFileUtil {
    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类） start
     */
    private volatile static DeleteFileUtil instance;

    private DeleteFileUtil() {
    }

    public static DeleteFileUtil getInstance() {
        if (instance == null) {
            synchronized (DeleteFileUtil.class) {
                if (instance == null) {
                    instance = new DeleteFileUtil();
                }
            }
        }
        return instance;
        //创建本类的单例模式（具体说明参见本包下的UUIDUtil类） end
    }

    /**
     * 多文件文件删除方法
     *
     * @param list 文件数据
     * @return boolean
     */
    public boolean deleteAllFile(List<FileData> list) {
        int len = list.size();
        if (len > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                sb.append(list.get(i).getBases());
                sb.append(list.get(i).getPath());
                File file = new File(sb.toString());
                file.delete();
                sb.delete(0, sb.length());
            }
            return true;
        }
        return false;
    }

    /**
     * 单文件文件删除方法
     *
     * @param fileData 文件数据
     * @return boolean
     */
    public boolean deleteFile(FileData fileData) {

        if (fileData != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(fileData.getBases());
            sb.append(fileData.getPath());
            File file = new File(sb.toString());
            file.delete();
            sb.delete(0, sb.length());
            return true;
        }
        return false;
    }

}
