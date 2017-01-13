package org.liuchang.service.finance.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.liuchang.bean.finance.SearchData;
import org.liuchang.dao.finance.IFinanceInlineDetailDao;
import org.liuchang.service.finance.IFinanceInlineDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/15.
 */
@Service("financeinlineDetailService")
public class FinanceInlineDetailServiceImpl implements IFinanceInlineDetailService {

    @Resource
    IFinanceInlineDetailDao financeInlineDetailDao;

    @Override
    public String getDataJson(String type) {
        String json = "";
        try {
            Map dataMap = new HashMap();
            dataMap.put("data", financeInlineDetailDao.getData(type));
            //dataMap.put("total",100);
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public String getInlineDataJson(SearchData searchData) {
        String json = "";
        try {
            Map dataMap = new HashMap();
            dataMap.put("data", financeInlineDetailDao.getInlineData(searchData));
            //dataMap.put("total",100);
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


}
