package org.liuchang.dao.finance;

import org.apache.ibatis.annotations.Param;
import org.liuchang.bean.finance.Type;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查询条件相关数据
 * Created by liuchang on 2016/4/7.
 */
@Component("searchDataDao")
public interface ISearchDataDao {

    /**
     * 查询条件中类型的数据
     * @return
     */
    List<Type> getTypeData(@Param("type")String type);
}
