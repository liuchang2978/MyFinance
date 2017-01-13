package org.liuchang.dao.finance;

import org.apache.ibatis.annotations.Param;
import org.liuchang.bean.finance.PayVO;
import org.liuchang.bean.finance.SearchData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuchang on 2016/4/6.
 */
@Component("financeDetailDao")
public interface IFinanceDetailDao {

    int count();

    List<PayVO> getData(SearchData s);

    String getDataTotal(SearchData s);

    int addData(PayVO payVO);

    int modifyData(PayVO payVO);

    int delData(String id);

}
