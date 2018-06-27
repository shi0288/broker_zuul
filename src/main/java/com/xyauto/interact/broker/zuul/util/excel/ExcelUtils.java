package com.xyauto.interact.broker.zuul.util.excel;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * excel工具类
 *
 * @author zhangbh
 *
 */
public class ExcelUtils {

    /**
     * 导出excel表格---单excel，多个sheet
     *
     * @param map
     */
    public static void exportExcel(String excelName, List<ExcelVo> list, HttpServletResponse response) {
        //创建表格
        HSSFWorkbook excel = new HSSFWorkbook();
        try {
            for (ExcelVo excelVo : list) {
                //创建sheet
                createSheet(excelVo, excel);
            }
            String headStr = "attachment; filename=\"" + new String(excelName.getBytes("gb2312"), "ISO8859-1") + "\"";
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setHeader("Content-Disposition", headStr);
            response.setCharacterEncoding("utf-8");
            OutputStream out = response.getOutputStream();
            if (excel != null) {
                excel.write(out);
                excel.close();
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建单个sheet
    static void createSheet(ExcelVo excelVo, HSSFWorkbook excel) {
        //创建sheet
        HSSFSheet sheet = excel.createSheet(excelVo.getTitle());
        //设置标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < excelVo.getRowName().length; i++) {
            //设置标题行每一列内容
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(excelVo.getRowName()[i]);
            cell.setCellValue(text);
        }
        //封装sheet数据
        for (int i = 0; i < excelVo.getDataList().size(); i++) {
            Object[] obj = excelVo.getDataList().get(i);
            //从第二行开始设置数据
            row = sheet.createRow(i + 1);
            for (int j = 0; j < obj.length; j++) {
                row.createCell(j).setCellValue(new HSSFRichTextString(obj[j].toString()));;
            }
        }
    }
}
