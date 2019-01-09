package com.imooc.course.dto;

import org.apache.commons.fileupload.FileItem;

public class ImportExcelParamDto {
    private FileItem excel;


    public FileItem getExcel() {
        return excel;
    }

    public void setExcel(FileItem excel) {
        this.excel = excel;
    }
}
