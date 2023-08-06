package com.dream.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String id;
    private String name;
    private String cardNo;
}