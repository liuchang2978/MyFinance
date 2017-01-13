package org.liuchang.service.finance;

import org.liuchang.bean.finance.SearchData;

/**
 * Created by liuchang on 2016/4/15.
 */
public interface IFinanceInlineDetailService {

    String getDataJson(String type);

    String getInlineDataJson(SearchData searchData);

}
