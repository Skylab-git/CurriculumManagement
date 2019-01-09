package com.imooc.course.service;

import com.imooc.course.data.Course;
import com.imooc.course.dto.ImportExcelResultDto;
import com.imooc.course.utils.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {


    public ImportExcelResultDto imp(FileItem fileItem,String operator) {

        ImportExcelResultDto resul = new ImportExcelResultDto();//数据传输对象

        List<Course> courseList = new ArrayList<>();//课程对象集合
        resul.setCourseList(courseList);


        String fileName = null;
        try {
            //保存文件到d:/upload 并返回保存文件名称
            fileName = FileUtil.save(fileItem, "d:/upload/");
        } catch (Exception e) {
            e.printStackTrace();
            resul.setMsg("保存上传文件失败!");
        }

        if (fileName != null) {//返回了文件名 说明保存成功
            Workbook workbook = null;
            try {
                //POI提供了WorkbookFactory 创建WorkBook --> Excel表格
                workbook = WorkbookFactory.create(new File("d:/upload/" + fileName));
                Sheet sheet = workbook.getSheetAt(0);
                //取出最后一行的数字
                int rowNum = sheet.getLastRowNum();
                //循环读取表格里的数据
                for (int i = 1; i <= rowNum; i++) {
                    //读取每一行数据 将数据存入Course对象里 并将Course对象存入数据传输对象的list集合中 用于JSP遍历信息
                    Row row = sheet.getRow(i);//Row: 行
                    Course course=new Course();
                    courseList.add(course);
                    course.setId((int)row.getCell(0).getNumericCellValue());
                    course.setCourse(row.getCell(1).getStringCellValue());
                    course.setCourseDirction(row.getCell(2).getStringCellValue());
                    course.setCourseDescribe(row.getCell(3).getStringCellValue());
                    course.setCourseTime(row.getCell(4).getStringCellValue());//课程时长
                    course.setOperator(operator);//操作人

//                    System.out.println("姓名：" + row.getCell(0).getStringCellValue());
//                    System.out.println("年龄：" + row.getCell(1).getNumericCellValue());
//                    System.out.println("时间：" + row.getCell(2).getDateCellValue());

                }
            } catch (Exception e) {
                e.printStackTrace();
                resul.setMsg("解析Excel失败!");
            } finally {
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return resul;

    }
}
