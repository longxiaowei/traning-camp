package com.longxw.controller;

import com.longxw.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longxw
 * @since 2020/3/17
 */
@RestController
public class BillController {


    @Autowired
    BillService billService;

}
