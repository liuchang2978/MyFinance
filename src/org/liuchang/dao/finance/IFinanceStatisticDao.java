package org.liuchang.dao.finance;

import org.apache.ibatis.annotations.Param;
import org.liuchang.bean.finance.PayVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/13.
 */
@Component("financeStatisticDao")
public interface IFinanceStatisticDao {

    List<Map> getTitle(@Param("type")String type);

    List<Map> getData(@Param("type")String type);

    List<Map> selectDataTotal(@Param("type")String type);

    List<PayVO> getDetail(@Param("id") String id, @Param("month") String month);

}
