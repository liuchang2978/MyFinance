package test.finance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liuchang.service.finance.ISearchDataService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuchang on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml" })
public class TestSearchData {
    @Resource
    private ISearchDataService searchDataService;
    //@Test
    //public void test(){
    //    System.out.println(payDao.count());
    //}

    @Test
    public void test(){

        String json = searchDataService.getTypeData("支出");
        System.out.println(json);

    }

}
