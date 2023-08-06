package com.dream.Strategy;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;
import java.util.Objects;

/**
 * 描述信息
 *
 * @author dream
 * @create 2023-08-06
 */
public class CustomStrategy implements CellWriteHandler {

    private final List<String> mergeColumnNames;

    public CustomStrategy(List<String> mergeColumnNames) {
        this.mergeColumnNames = mergeColumnNames;
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        if (isHead) {
            return;
        }

        if (relativeRowIndex == 0) {
            return;
        }

        // 校验当前列表不与合并列表中，不予处理
        if (!this.mergeColumnNames.contains(head.getFieldName())) {
            return;
        }

        Sheet sheet = cell.getSheet();
        // 当前行下标 上一行 上一行对象  上一列对象
        int rowIndexCurrent = cell.getRowIndex();
        int rowIndexPrev = rowIndexCurrent - 1;

        Row rowCurrent = sheet.getRow(rowIndexCurrent);
        Row rowPrev = sheet.getRow(rowIndexPrev);

        Cell cellPrev = rowPrev.getCell(cell.getColumnIndex());

        // 获取单元格 上一单元格值
        Object cellValueCurrent = cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.getNumericCellValue();
        Object cellValuePrev = cellPrev.getCellType() == CellType.STRING ? cellPrev.getStringCellValue() : cellPrev.getNumericCellValue();

        if (!Objects.equals(cellValueCurrent, cellValuePrev)) {
            return;
        }

        List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
        boolean merged = false;
        for (int i = 0; i < mergedRegions.size(); i++) {
            CellRangeAddress cellAddresses = mergedRegions.get(i);
            if (cellAddresses.isInRange(rowIndexPrev, cell.getColumnIndex())) {
                sheet.removeMergedRegion(i);
                cellAddresses.setLastRow(rowIndexCurrent);
                sheet.addMergedRegion(cellAddresses);
                merged = true;
                break;
            }
        }

        if (!merged) {
            CellRangeAddress cellAddresses = new CellRangeAddress(rowIndexPrev, rowIndexCurrent, cell.getColumnIndex(), cell.getColumnIndex());
            sheet.addMergedRegion(cellAddresses);
        }


    }
}
