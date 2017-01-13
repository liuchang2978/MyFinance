package org.liuchang.controller.finance;

import org.liuchang.service.finance.IFinanceStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/finance")
public class FinanceStatisticController {

    @Resource
    private IFinanceStatisticService financeStatisticService;


    @RequestMapping("/finance_statistic")
    public String financeStatistic(Model model, String type) {
        model.addAttribute("type", type);
        return "finance/finance_statistic";
    }

    @RequestMapping("/getData")
    @ResponseBody
    public String zhichutongjiData(String type) {
        //System.out.println(s);
        String json = financeStatisticService.getDataJson(type);
        //System.out.println(json);
        //out.print(json);
        //out.close();
        return json;
    }

    @RequestMapping("/toMingxi")
    public String toMingxi(Model model, String id, String month) {
        model.addAttribute("dataJson", financeStatisticService.getDetailJson(id, month));
        return "finance/mingxi";
    }

}