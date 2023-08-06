package com.dream.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@Data
public class UserModel {

//    {0:"dream1",1:"男",2:"2023.01.01",3:"123@qq.com",4:"1",5:"1"}
@ExcelProperty(value = "性别")
private String sex;

    @ExcelProperty(value = "昵称")
    private String name;



    private String birth;

    private String email;

    private Integer score;

    private Integer rank;


//    @DateTimeFormat
//    @NumberFormat
}
