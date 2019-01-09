package com.imooc.course.utils;

import com.imooc.course.dto.ParmDto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestUtil {
    /**
     * 从request流中解析参数与上传的文件
     * @param request
     */
    public  static Map<String, FileItem> parseParam(HttpServletRequest request){
        //将两种数据封装到ParmDto对象里的两种Map集合返回出去 表单数据和fileItem文件
        ParmDto result=new ParmDto();
        Map<String, FileItem> fileMap = new HashMap<>();//文件     key:文件名         valus：文件流
        //从reques流里解析文件 需要第三方组件  ServletFileUpload：导入的包的对象 用来解析文件
        ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        try {
            //传入request 解析request流 取出FileItem对象  相当于把整个表单组件全拿到了
            List<FileItem> fileItemList=upload.parseRequest(request);
            for (FileItem fileItem:fileItemList){
                    //文件流 文件表单  如Excel表

                fileMap.put(fileItem.getFieldName(),fileItem);


            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileMap;
    }
}
