package org.liuchang.dao.finance;

import org.liuchang.bean.finance.JieyuVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuchang on 2016/4/12.
 */
@Component("jieyuDao")
public interface IJieyuDao {

    List<JieyuVO> getData();

    JieyuVO getDataTotal();

}
