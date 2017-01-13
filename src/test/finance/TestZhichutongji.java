package test.finance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liuchang.service.finance.IFinanceStatisticService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuchang on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml" })
public class TestZhichutongji {
    @Resource
    private IFinanceStatisticService zhichutongjiService;

    @Test
    public void test(){
        String json = zhichutongjiService.getDataJson("1");
        System.out.println(json);

    }

}
