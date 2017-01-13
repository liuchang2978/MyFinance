package test.finance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liuchang.bean.finance.SearchData;
import org.liuchang.service.finance.IFinanceDetailService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuchang on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml" })
public class TestPay {
    @Resource
    private IFinanceDetailService payService;

    @Test
    public void test(){
        SearchData s = new SearchData();
        s.setStartTime("2016-03-01");
        s.setEndTime("2016-03-30");
        String json = payService.getDataJson(s);
        System.out.println(json);

    }

}
