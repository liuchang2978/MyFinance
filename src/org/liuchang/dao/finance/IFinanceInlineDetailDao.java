package org.liuchang.dao.finance;

import org.apache.ibatis.annotations.Param;
import org.liuchang.bean.finance.PayVO;
import org.liuchang.bean.finance.SearchData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/15.
 */
@Component("financeInlineDetailDao")
public interface IFinanceInlineDetailDao {

    List<Map> getData(@Param("type")String type);

    List<PayVO> getInlineData(SearchData searchData);

}
