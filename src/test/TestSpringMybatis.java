package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liuchang.service.finance.IFinanceDetailService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuchang on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml" })
public class TestSpringMybatis {
    @Resource
    //private IFinanceDetailDao payDao;

    private IFinanceDetailService payService;
    //@Test
    //public void test(){
    //    System.out.println(payDao.count());
    //}

    @Test
    public void test(){
        //System.out.println(payService.getDataJson());
    }

}
