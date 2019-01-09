package com.imooc.course.dto;

import org.apache.commons.fileupload.FileItem;

import java.util.HashMap;
import java.util.Map;

public class ParmDto {//Dto:数据传输对象
    private Map<String, FileItem> fileMap;//文件     key:文件名         valus：文件流

    public ParmDto() {
        fileMap = new HashMap<>();
    }


    public Map<String, FileItem> getFileMap() {
        return fileMap;
    }


    public void setFileMap(Map<String, FileItem> fileMap) {
        this.fileMap = fileMap;
    }
}
