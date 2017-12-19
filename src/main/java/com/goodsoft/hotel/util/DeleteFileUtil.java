package com.goodsoft.hotel.util;

import com.goodsoft.hotel.domain.entity.file.FileData;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * function 文件删除工具类
 * Created by  manjusaka[manjusakachn@gmail.com] on 2017/9/11.
 *
 * @version v1.1.2
 */
@SuppressWarnings("ALL")
@Service
public class DeleteFileUtil {

    /**
     * 多文件文件删除方法(无返回值)
     *
     * @param list 文件数据
     * @return boolean
     */
    @Async
    public void deleteNAllFile(List<FileData> list) {
        int len = list.size();
        if (len > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                sb.append(list.get(i).getBases()).append(list.get(i).getPath());
                File file = new File(sb.toString());
                file.delete();
                sb.delete(0, sb.length());
            }
        }
    }

    /**
     * 多文件文件删除方法(有返回值)
     *
     * @param list 文件数据
     * @return boolean
     */
    public boolean deleteAllFile(List<FileData> list) {
        int len = list.size();
        if (len > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                sb.append(list.get(i).getBases()).append(list.get(i).getPath());
                File file = new File(sb.toString());
                file.delete();
                sb.delete(0, sb.length());
            }
            return true;
        }
        return false;
    }


    /**
     * 单文件文件删除方法(无返回值)
     *
     * @param fileData 文件数据
     * @return boolean
     */
    @Async
    public void deleteNFile(FileData fileData) {
        if (fileData != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(fileData.getBases()).append(fileData.getPath());
            File file = new File(sb.toString());
            file.delete();
            sb.delete(0, sb.length());
        }
    }

    /**
     * 单文件文件删除方法(有返回值)
     *
     * @param fileData 文件数据
     * @return boolean
     */
    public boolean deleteFile(FileData fileData) {
        if (fileData != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(fileData.getBases()).append(fileData.getPath());
            File file = new File(sb.toString());
            file.delete();
            sb.delete(0, sb.length());
            return true;
        }
        return false;
    }

}
