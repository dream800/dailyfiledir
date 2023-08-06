package com.dream.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.dream.po.Student;
import com.dream.po.UserModel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
@Slf4j
public class UserInfoReadListener implements ReadListener<UserModel> {

    private int batchSize;

    public UserInfoReadListener(int batchSize) {
        this.batchSize = batchSize;
        this.cachedList = new ArrayList<UserModel>(this.batchSize);
    }

    public UserInfoReadListener() {
        this(5);
    }

    private List<UserModel> cachedList;

    @Override
    public void invoke(UserModel userModel, AnalysisContext analysisContext) {
        log.info("invoke: {}", userModel);

    }



    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("all analysed: {}", this.cachedList.size());
    }
}
