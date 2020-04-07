package com.longxw.test;

import com.longxw.contants.PayTypeEnum;
import com.longxw.mall.mapper.BillMapper;
import com.longxw.mall.model.Bill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootmybatisplusApplicationTests {

    @Autowired
    BillMapper billMapper;

    @Test
    public void test(){
        Bill bill = new Bill();
        bill.setId("1234");
        bill.setPayee("羊羊羊");
        bill.setPayer("支付宝");
        bill.setPayType(PayTypeEnum.WX_CHONGZHITIXIAN);
        int result =  billMapper.insert(bill);
        Bill select = billMapper.selectById("1234");
        Assert.assertTrue(select.getId().equals(bill.getId()));
    }
}
