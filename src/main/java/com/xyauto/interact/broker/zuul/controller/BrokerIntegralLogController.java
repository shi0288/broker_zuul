package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping("/broker/integral")
public class BrokerIntegralLogController extends BaseController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Result list() {
        return brokerServerCloud.integralList(this.getParameterMap());
    }


}
