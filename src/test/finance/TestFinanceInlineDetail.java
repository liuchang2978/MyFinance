package test.finance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liuchang.bean.finance.PayVO;
import org.liuchang.bean.finance.SearchData;
import org.liuchang.dao.finance.IFinanceInlineDetailDao;
import org.liuchang.service.finance.IFinanceStatisticService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchang on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml" })
public class TestFinanceInlineDetail {
    @Resource
    private IFinanceInlineDetailDao financeInlineDetailDao;

    @Test
    public void test(){

        SearchData s = new SearchData();
        s.setStartTime("2015-09");
        s.setPage_type("2");
        List<PayVO> list = financeInlineDetailDao.getInlineData(s);
        for (PayVO m :list){
            System.out.println(m);
        }

    }

}
