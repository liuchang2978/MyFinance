package org.liuchang.service.finance.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.liuchang.bean.finance.PayVO;
import org.liuchang.bean.finance.SearchData;
import org.liuchang.dao.finance.IFinanceDetailDao;
import org.liuchang.service.finance.IFinanceDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/6.
 */
@Service("financeDetailService")
public class FinanceDetailServiceImpl implements IFinanceDetailService {

    @Resource
    IFinanceDetailDao financeDetailDao;

    @Override
    public void sayHello() {
        System.out.println("Hello Mybatis!");
    }

    @Override
    public int count() {
        return financeDetailDao.count();
    }

    @Override
    public String getDataJson(SearchData searchData) {
        String json = "";
        try {
            Map dataMap = new HashMap();
            dataMap.put("data", financeDetailDao.getData(searchData));
            dataMap.put("sum", financeDetailDao.getDataTotal(searchData));
            //dataMap.put("total",100);
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public HSSFWorkbook getDataForExcel(SearchData searchData) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        //// 声明一个画图的顶级管理器
        //HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        //// 定义注释的大小和位置,详见文档
        //HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        //// 设置注释内容
        //comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        //// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        //comment.setAuthor("leno");

        String[] headers = {"日期", "类型", "名称", "金额"};

        //产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //遍历集合数据，产生数据行
        List<PayVO> list = financeDetailDao.getData(searchData);
        for (int i = 0; i < list.size(); i++) {
            PayVO p = list.get(i);
            row = sheet.createRow(i + 1);

            HSSFCell cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(p.getDate());

            cell = row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue(p.getType_name());

            cell = row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(p.getName());

            cell = row.createCell(3);
            cell.setCellStyle(style);
            cell.setCellValue(p.getMoney());
        }
        return workbook;
    }

    @Override
    public void addData(PayVO payVO) {
        financeDetailDao.addData(payVO);
    }

    @Override
    public void modifyData(PayVO payVO) {
        financeDetailDao.modifyData(payVO);
    }

    @Override
    public void delData(String id) {
        financeDetailDao.delData(id);
    }

}
