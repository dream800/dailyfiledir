package com.dream.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.dream.listener.UserInfoReadListener;
import com.dream.po.UserModel;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
public class TestB {

    @Test
    public void read()
    {
        File file = new File("D:\\code\\file\\excel\\test.xlsx");
        List<Object> objects = EasyExcel.read(file).sheet(0).doReadSync();
        System.out.println(JSON.toJSONString(objects, true));
    }


    @Test
    public void test1()
    {
        InputStream inputStream = TestB.class.getClassLoader().getResourceAsStream("test.xlsx");
        List<Object> objects = EasyExcel.read(inputStream).sheet(0).doReadSync();
        for (Object object : objects) {
            System.out.println(JSON.toJSONString(object));
        }

    }


    @Test
    public void test2()
    {
        InputStream inputStream = TestB.class.getClassLoader().getResourceAsStream("test.xlsx");
        List<Object> objects = EasyExcel.read(inputStream).sheet(0)
                .head(UserModel.class)
                .doReadSync();
        for (Object object : objects) {
            System.out.println(JSON.toJSONString(object));
        }

    }

    @Test
    public void test3()
    {
        InputStream inputStream = TestB.class.getClassLoader().getResourceAsStream("test.xlsx");
//        EasyExcel.read(inputStream).head(UserModel.class).registerReadListener(new UserInfoReadListener())
//                .doReadAllSync();
//        List<Object> objects = EasyExcel.read(inputStream, UserModel.class, new UserInfoReadListener())
//                .sheet(0).doReadSync();
        EasyExcel.read(inputStream, UserModel.class, new UserInfoReadListener())
                .sheet(0).doRead();
//        objects.forEach(item-> System.out.println(JSON.toJSONString(item)));
    }
}
