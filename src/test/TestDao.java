package test;

import org.liuchang.bean.finance.PayVO;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Created by liuchang on 2016/4/1.
 */
public class TestDao extends HibernateTemplate {

    public void search(){
        //List<?> list = find("from Type");

        List<PayVO> list = (List<PayVO>) findByValueBean("select t.name as type,p.id as id,p.name as name,p.date as date,p.money as money from Type t , Pay p where t.id = p.type", PayVO.class);
        System.out.println(list.size());
    }
}
