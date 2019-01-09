package com.imooc.course.utils;

import org.apache.commons.fileupload.FileItem;

import java.io.File;

public class FileUtil {//保存文件工具类
    public static String save(FileItem fileItem, String path) throws Exception {//path: 文件名
        //为防止上传相同名字的文件覆盖掉 给文件名加上时间
        String fileName = System.currentTimeMillis() + "_" + fileItem.getName();
        fileItem.write(new File(path + fileName));//path+filName: 路径+文件名
        return fileName;
    }
}
