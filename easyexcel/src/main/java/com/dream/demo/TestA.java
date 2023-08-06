package com.dream.demo;

import com.dream.po.ContentAnalysisPo;

import java.util.ArrayList;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-05
 */
public class TestA {

    public static void main(String[] args) {

        ArrayList<ContentAnalysisPo> list = new ArrayList<ContentAnalysisPo>();

        list.add(new ContentAnalysisPo("subject", "test 111", "test", 1,101, 201));
        list.add(new ContentAnalysisPo("post", "test 222", "test1", 2,101, 201));
        list.add(new ContentAnalysisPo("subject", "test 333", "test3", 3,102, 202));
        list.add(new ContentAnalysisPo("post", "test 444", "test4", 4,102, 202));
        list.add(new ContentAnalysisPo("survey", "test 555", "test5", 5,102, 202));
        list.add(new ContentAnalysisPo("survey_answer", "test 666", "test6", 6,102, 202));
        list.add(new ContentAnalysisPo("post_reply", "test 777", "test7", 7,102, 202));


//        list.stream().



        System.out.println(list);

    }

}
