package com.longxw.service;

import com.longxw.mall.mapper.BillMapper;
import com.longxw.mall.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longxw
 * @since 2020/3/17
 */
@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;

    public int insert(){
        Bill bill = new Bill();
        bill.setId("1234");
        bill.setPayee("羊羊羊");
        bill.setPayer("支付宝");
        return billMapper.insert(bill);
    }
}
