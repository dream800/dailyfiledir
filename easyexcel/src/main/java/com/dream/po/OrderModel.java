package com.dream.po;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.dream.converter.UserInfoConverter;
import lombok.Data;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@Data
//@ColumnWidth(30)
//@HeadRowHeight(50)
//@ContentRowHeight(20)
//@OnceAbsoluteMerge(firstRowIndex = 4, lastRowIndex = 5, firstColumnIndex = 0, lastColumnIndex = 0)
public class OrderModel {



    @ExcelProperty(value = {"订单", "订单ID"}, index = 0)
//    @ContentLoopMerge(eachRow = 2)
    private String orderId;

    @ExcelProperty(value = {"订单", "时间"}, index = 2)
    private String time;

    @ExcelProperty(value = {"订单", "标题"} , index = 1)
    private String title;


    @ExcelProperty(value = "性别" , index = 3, converter = UserInfoConverter.class)
    private Integer sex;

    @ExcelProperty(value = "生日")
    @DateTimeFormat(value = "yyyy年MM月dd日")
    @ColumnWidth(30)
//    @ExcelIgnore
    private Date birth;


//    @TableField(exist = false)
    @ExcelProperty(value = "File类型 图片")
    private File image1;

    @ExcelProperty(value = "byte[] 图片")
    private byte[] image2;

    @ExcelProperty(value = "InputStream 图片")
    private InputStream image3;

    @ExcelProperty(value = "URL 图片")
    private URL image4;

    @ExcelProperty(value = "String 图片", converter = StringImageConverter.class)
    private String image5;
}
