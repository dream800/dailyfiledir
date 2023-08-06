package com.dream.po;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@Data
public class UserInfoModel {



    @ExcelProperty(value = "昵称")
    private String name;

    @ExcelProperty(value = "性别")
    private Integer sex;

    @ExcelProperty(value = "生日")
    private Date birth;

//    private String email;
//
//    private Integer score;
//
//    private Integer rank;

}
