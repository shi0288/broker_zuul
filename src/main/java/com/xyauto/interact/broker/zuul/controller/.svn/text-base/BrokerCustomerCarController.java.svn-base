package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping("/customer/car")
public class BrokerCustomerCarController extends BaseController {


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update() {
        return brokerServerCloud.customerCarUpdate(this.getParameterMap());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add() {
        return brokerServerCloud.customerCarAdd(this.getParameterMap());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete() {
        return brokerServerCloud.customerCarDelete(this.getParameterMap());
    }


}
