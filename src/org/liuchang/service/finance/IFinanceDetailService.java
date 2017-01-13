package org.liuchang.service.finance;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.liuchang.bean.finance.PayVO;
import org.liuchang.bean.finance.SearchData;

/**
 * Created by liuchang on 2016/4/6.
 */
public interface IFinanceDetailService {
    void sayHello();

    int count();

    String getDataJson(SearchData searchData);

    HSSFWorkbook getDataForExcel(SearchData searchData);

    void addData(PayVO payVO);

    void modifyData(PayVO payVO);

    void delData(String id);

}
