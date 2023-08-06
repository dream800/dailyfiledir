package com.dream.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.dream.po.Student;

import java.util.List;
import java.util.Map;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
public class Demo1Listener implements ReadListener<Student> {


    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<Student> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {

    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {

    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {

    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return false;
    }

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
//        log.info("解析到一条数据:{}", JSON.toJSONString(student));
        System.out.println(JSON.toJSONString(student));
        cachedDataList.add(student);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    private void saveData() {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
