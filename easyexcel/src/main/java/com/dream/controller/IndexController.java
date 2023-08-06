package com.dream.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.util.FileUtils;
import com.dream.Strategy.CustomStrategy;
import com.dream.po.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@RestController
@RequestMapping("/index")
public class IndexController {



    @GetMapping("")
    public String getIndex(HttpServletResponse response) throws Exception {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        List<OrderModel> list = getList();
        EasyExcel.write(response.getOutputStream(), OrderModel.class).sheet("导出数据").doWrite(list);

//        EasyExcel.write(EXPORT_PATH)
//                .head(OrderModel.class)
////                .excludeColumnFieldNames(Arrays.asList("birth", "sex"))
////                .includeColumnFieldNames(Arrays.asList("title"))
////                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
//                .sheet("导出数据")
////                .registerWriteHandler(new OnceAbsoluteMergeStrategy(2, 3, 0 ,0 ))
////                .registerWriteHandler(new LoopMergeStrategy(2, 0))
//                .registerWriteHandler(new CustomStrategy(Arrays.asList("orderId")))
//                .doWrite(list);

        return "hello";
    }



    private List<OrderModel> getList() throws Exception {

        OrderModel order = new OrderModel();
        order.setOrderId("111111");
        order.setTitle("苹果");
        order.setTime("123");
        order.setSex(1);
        order.setBirth(DateUtils.parseDate("2023-07-15"));
        order.setImage1(new File("C:\\code\\java\\project\\java2023\\easyexcel\\src\\main\\resources\\3.jpg"));

        OrderModel order4 = new OrderModel();
        order4.setOrderId("111111");
        order4.setTitle("苹果");
        order4.setTime("123");
        order4.setSex(1);
        order4.setBirth(DateUtils.parseDate("2023-07-15"));
        order4.setImage2(FileUtils.readFileToByteArray(new File("C:\\code\\java\\project\\java2023\\easyexcel\\src\\main\\resources\\3.jpg")));

        OrderModel order1 = new OrderModel();
        order1.setOrderId("222");
        order1.setTitle("苹果1");
        order1.setTime("222");
        order1.setSex(2);
        order1.setBirth(DateUtils.parseDate("2023-07-15"));
        order1.setImage4(new URL("https://easyexcel.opensource.alibaba.com/img/logo.png"));

        OrderModel order2 = new OrderModel();
        order2.setOrderId("333");
        order2.setTitle("苹果3");
        order2.setTime("333");
        order2.setSex(1);
        order2.setBirth(DateUtils.parseDate("2023-07-15"));
        order2.setImage3(FileUtils.openInputStream(new File("C:\\code\\java\\project\\java2023\\easyexcel\\src\\main\\resources\\3.jpg")));


        OrderModel order3 = new OrderModel();
        order3.setOrderId("333");
        order3.setTitle("苹果4");
        order3.setTime("333");
        order3.setSex(1);
        order3.setBirth(DateUtils.parseDate("2023-07-15"));
        order3.setImage5("C:\\code\\java\\project\\java2023\\easyexcel\\src\\main\\resources\\3.jpg");

        List<OrderModel> orderModels = Arrays.asList(order,order4, order1, order2, order3);
        return orderModels;
    }

}
