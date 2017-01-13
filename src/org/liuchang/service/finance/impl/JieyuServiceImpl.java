package org.liuchang.service.finance.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.liuchang.bean.finance.JieyuVO;
import org.liuchang.dao.finance.IJieyuDao;
import org.liuchang.service.finance.IJieyuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/12.
 */
@Service("jieyuService")
public class JieyuServiceImpl implements IJieyuService {

    @Resource
    IJieyuDao jieyuDao;

    @Override
    public String getDataJson() {
        String json = "";
        try {
            List<JieyuVO> list = jieyuDao.getData();
            JieyuVO total = jieyuDao.getDataTotal();
            list.add(total);
            Map dataMap = new HashMap();
            dataMap.put("data", list);
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

}
