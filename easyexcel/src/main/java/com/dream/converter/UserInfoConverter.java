package com.dream.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
public class UserInfoConverter implements Converter<Integer> {

    @Override
    public WriteCellData<?> convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        switch (value) {
            case 1:
                return new WriteCellData<>("男");
            case 2:
                return new WriteCellData<>("女");
            default:
                return new WriteCellData<>("未知");

        }
    }
}
