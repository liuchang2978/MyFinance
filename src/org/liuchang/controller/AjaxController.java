package org.liuchang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.liuchang.bean.finance.Pay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/5.
 */
@Controller
@RequestMapping("/")
public class AjaxController {

    @RequestMapping("/ajax")
    public void ajax(PrintWriter out, String name) throws JsonProcessingException {
        System.out.println("ajax");
        System.out.println(name);
        Map<String,Object> data = new HashMap<String,Object>();

        List<Pay> list = new ArrayList<Pay>();

        Pay p = new Pay();
        p.setId(0);
        p.setMoney(200);
        p.setName("abc");
        p.setType(4);

        Pay p1 = new Pay();
        p.setId(2);
        p.setMoney(3300);
        p.setName("纲常");
        p.setType(4);

        list.add(p);
        list.add(p1);

        data.put("total",2);
        data.put("data",list);
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(data);

        out.print(json);

    }
}
