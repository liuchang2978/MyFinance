package org.liuchang.service.finance;

/**
 * Created by liuchang on 2016/4/13.
 */
public interface IFinanceStatisticService {

    String getDataJson(String type);

    String getDetailJson(String id, String month);

}
