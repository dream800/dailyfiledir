package com.dream.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.data.HyperlinkData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.util.FileUtils;
import com.dream.Strategy.CustomStrategy;
import com.dream.po.OrderModel;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
public class TestD {


    private final String EXPORT_PATH = "D:\\code\\file\\excel\\export.xlsx";

    @Test
    public void test1() throws Exception {

//        HyperlinkData hyperlinkData = new HyperlinkData();
//        hyperlinkData.setHyperlinkType(HyperlinkData.HyperlinkType.URL);
//        hyperlinkData.setAddress("http://www.xxx.com/user/");
//        WriteCellData writeCellData = new WriteCellData<>(nickname);
//        writeCellData.setHyperlinkData(hyperlinkData);
//    model.setNickname(writeCellData);

        List<OrderModel> list = getList();
        EasyExcel.write(EXPORT_PATH)
                .head(OrderModel.class)
//                .excludeColumnFieldNames(Arrays.asList("birth", "sex"))
//                .includeColumnFieldNames(Arrays.asList("title"))
//                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet("导出数据")
//                .registerWriteHandler(new OnceAbsoluteMergeStrategy(2, 3, 0 ,0 ))
//                .registerWriteHandler(new LoopMergeStrategy(2, 0))
                .registerWriteHandler(new CustomStrategy(Arrays.asList("orderId")))
                .doWrite(list);
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
