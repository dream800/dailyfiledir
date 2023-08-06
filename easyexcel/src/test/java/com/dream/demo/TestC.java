package com.dream.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.DateUtils;
import com.dream.po.ContentAnalysisPo;
import com.dream.po.OrderModel;
import com.dream.po.UserInfoModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@Slf4j
public class TestC {

    private final String EXPORT_PATH = "D:\\code\\file\\excel\\export.xlsx";

    @Test
    public void test1()
    {

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<String> list2 = Arrays.asList("郭德纲", "于谦", "郭麒麟");

        List<Object> lists = Arrays.asList(list1, list2);

        EasyExcel.write(EXPORT_PATH)
                .sheet("导出数据")
                .doWrite(lists);
    }

    @Test
    public void test2() throws ParseException {
        HashMap<Integer, Object> map1 = new HashMap<>();
        map1.put(0, "郭德纲");
        map1.put(1, 1);
        map1.put(2, DateUtils.parseDate("1976-07-13"));

        HashMap<Integer, Object> map2 = new HashMap<>();
        map2.put(0, "于谦");
        map2.put(1, 2);
        map2.put(2, DateUtils.parseDate("1977-07-13"));


        List<HashMap<Integer, Object>> list = Arrays.asList(map1, map2);
        EasyExcel.write(EXPORT_PATH)
                .sheet("导出数据")
                .doWrite(list);

    }

    @Test
    public void test3() throws ParseException {

        UserInfoModel user1 = new UserInfoModel();
        user1.setName("郭德纲");
        user1.setSex(1);
        user1.setBirth(DateUtils.parseDate("2023-07-15"));

        OrderModel order = new OrderModel();
        order.setOrderId("111111");
        order.setTitle("苹果");
        order.setTime("123");

        UserInfoModel user2 = new UserInfoModel();
        user2.setName("于谦");
        user2.setSex(2);
        user2.setBirth(DateUtils.parseDate("2023-07-16"));

        List<Object> list = Arrays.asList(user1, order, user2);
        EasyExcel.write(EXPORT_PATH)
                .sheet("导出数据")
                .doWrite(list);

    }



}
