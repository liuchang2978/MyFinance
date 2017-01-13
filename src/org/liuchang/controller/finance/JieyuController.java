package org.liuchang.controller.finance;

import org.liuchang.service.finance.IJieyuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/finance")
public class JieyuController {

    @Resource
    private IJieyuService jieyuService;


    @RequestMapping("/jieyu")
    public String jieyu() {
        return "finance/jieyu";
    }

    @RequestMapping("/jieyuData")
    @ResponseBody
    public String jieyuData() {
        //System.out.println(s);
        String json = jieyuService.getDataJson();
        //System.out.println(json);
        //out.print(json);
        //out.close();
        return json;
    }
//
//    @RequestMapping("/toAdd")
//    public String toAdd(Model model) {
//        model.addAttribute("time", DateUtil.getDateAsString(DateUtil.TODAY));
//        return "finance/tianjia";
//    }
//
//    @RequestMapping("/add")
//    @ResponseBody
//    public String add(PayVO pay) {
//        if (pay.getId() == 0) {
//            payService.addData(pay);
//        } else {
//            payService.modifyData(pay);
//        }
//        return "1";
//    }
//
//    @RequestMapping("/del")
//    @ResponseBody
//    public String del(String id) {
//        payService.delData(id);
//        return "1";
//    }
//
//    public static void main(String[] args) {
//        System.out.println(DateUtil.getDateAsString(DateUtil.FIRST_DAY_OF_MONTH));
//        System.out.println(DateUtil.getDateAsString(DateUtil.TODAY));
//
//    }

}