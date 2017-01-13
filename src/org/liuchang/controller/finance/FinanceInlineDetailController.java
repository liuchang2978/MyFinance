package org.liuchang.controller.finance;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.liuchang.bean.finance.PayVO;
import org.liuchang.bean.finance.SearchData;
import org.liuchang.service.finance.IFinanceDetailService;
import org.liuchang.service.finance.IFinanceInlineDetailService;
import org.liuchang.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
@RequestMapping("/finance")
public class FinanceInlineDetailController {

    @Resource
    private IFinanceInlineDetailService financeInlineDetailService;

    /**
     * 跳转到明细页面
     *
     * @param model
     * @param type  类型 1支出明细 2收入明细 3礼金明细
     * @return
     */
    @RequestMapping("/finance_inline_detail")
    public String financeDetail(Model model, String type) {
        model.addAttribute("type", type);
        return "finance/finance_inline_detail";
    }

    @RequestMapping("/getInlineDetailData")
    @ResponseBody
    public String getInlineDetailData(String type) {
        String json = financeInlineDetailService.getDataJson(type);
        return json;
    }

    @RequestMapping("/getInlineData")
    @ResponseBody
    public String getInlineData(SearchData searchData) {
        String json = financeInlineDetailService.getInlineDataJson(searchData);
        return json;
    }

    //@RequestMapping("/toAdd")
    //public String toAdd(Model model, String type) {
    //    model.addAttribute("time", DateUtil.getDateAsString(DateUtil.TODAY));
    //    model.addAttribute("type", type);
    //    return "finance/add_or_edit";
    //}
    //
    //@RequestMapping("/add")
    //@ResponseBody
    //public String add(PayVO pay) {
    //    if (pay.getId() == 0) {
    //        financeDetailService.addData(pay);
    //    } else {
    //        financeDetailService.modifyData(pay);
    //    }
    //    return "1";
    //}
    //
    //@RequestMapping("/del")
    //@ResponseBody
    //public String del(String id) {
    //    financeDetailService.delData(id);
    //    return "1";
    //}
    //
    //@RequestMapping("/exportExcel")
    //public void exportExcel(HttpServletRequest request, HttpServletResponse response, SearchData s) {
    //    String fileName = "";
    //    switch (s.getPage_type()){
    //        case "1":
    //            fileName = "支出明细.xls";
    //            break;
    //        case "2":
    //            fileName = "收入明细.xls";
    //            break;
    //        case "3":
    //            fileName = "礼金明细.xls";
    //            break;
    //        default:
    //            break;
    //
    //    }
    //
    //    try {
    //        OutputStream ouputStream = response.getOutputStream();
    //        HSSFWorkbook workbook = financeDetailService.getDataForExcel(s);
    //        // 设置response参数，可以打开下载页面
    //        response.reset();
    //        response.setContentType("application/vnd.ms-excel;charset=utf-8");
    //        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
    //
    //        workbook.write(ouputStream);
    //        ouputStream.flush();
    //        ouputStream.close();
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //}

    public static void main(String[] args) {
        System.out.println(DateUtil.getDateAsString(DateUtil.FIRST_DAY_OF_MONTH));
        System.out.println(DateUtil.getDateAsString(DateUtil.TODAY));

    }

}