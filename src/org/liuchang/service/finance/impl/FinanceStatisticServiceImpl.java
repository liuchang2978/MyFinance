package org.liuchang.service.finance.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.liuchang.dao.finance.IFinanceStatisticDao;
import org.liuchang.service.finance.IFinanceStatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/13.
 */
@Service("financeStatisticService")
public class FinanceStatisticServiceImpl implements IFinanceStatisticService {

    @Resource
    IFinanceStatisticDao financeStatisticDao;

    @Override
    public String getDataJson(String type) {
        String json = "";
        try {
            Map dataMap = new HashMap();

            List title = this.getTitle(type);

            dataMap.put("title", title);
            dataMap.put("data", this.getData(type));


            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private List getTitle(String type) {
        Map map = new HashMap<>();
        List title = financeStatisticDao.getTitle(type);

        map.put("ID", "month");
        map.put("NAME", "月份");
        title.add(0, map);

        map = new HashMap<>();
        map.put("ID", "total");
        map.put("NAME", "合计");
        title.add(map);

        return title;
    }

    private List getData(String type) {
        List<Map> data = financeStatisticDao.getData(type);

        String monStr = data.get(0).get("MONTH").toString();
        List result = new ArrayList<>();
        Map rowData = new HashMap<>();
        rowData.put("month", monStr);
        int count = data.size();
        int total = 0;
        for (int i = 0; i < count; i++) {
            Map m = data.get(i);
            if (!monStr.equals(m.get("MONTH").toString())) {
//                if (i != 0) {
                rowData.put("total", total);
                result.add(rowData);
                total = 0;
                rowData = new HashMap<>();
                rowData.put("month", m.get("MONTH").toString());
//                }
            }

            rowData.put(m.get("TYPE").toString(), m.get("MONEY").toString());
            total += Integer.parseInt(m.get("MONEY").toString());
            monStr = m.get("MONTH").toString();

        }
        rowData.put("total", total);
        result.add(rowData);

        List<Map> dataTotal = financeStatisticDao.selectDataTotal(type);
        rowData = new HashMap<>();
        total = 0;
        for (Map m : dataTotal) {
            rowData.put(m.get("TYPE").toString(), m.get("MONEY").toString());
            total += Integer.parseInt(m.get("MONEY").toString());
        }

        rowData.put("total", total);
        rowData.put("month", "合计");
        result.add(rowData);
        return result;
    }

    @Override
    public String getDetailJson(String id, String month) {
        String json = "";
        try {
            //Map dataMap = new HashMap();
            //dataMap.put("data", payDao.getDetail(id, month));
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(financeStatisticDao.getDetail(id, month));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
