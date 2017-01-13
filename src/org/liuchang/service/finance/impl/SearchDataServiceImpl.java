package org.liuchang.service.finance.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.liuchang.bean.finance.Type;
import org.liuchang.dao.finance.ISearchDataDao;
import org.liuchang.service.finance.ISearchDataService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuchang on 2016/4/7.
 */
@Component("searchDataService")
public class SearchDataServiceImpl implements ISearchDataService {

    @Resource
    private ISearchDataDao searchDataDao;

    @Override
    public String getTypeData(String type) {
        try {
            List<Type> data = searchDataDao.getTypeData(type);
            ObjectMapper om = new ObjectMapper();
            return om.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
