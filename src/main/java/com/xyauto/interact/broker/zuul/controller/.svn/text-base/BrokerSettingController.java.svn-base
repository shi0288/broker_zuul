package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping("/broker/setting")
public class BrokerSettingController extends BaseController {


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update() {
        return brokerServerCloud.settingUpdate(this.getParameterMap());
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result get() {
        return brokerServerCloud.settingGet(this.getParameterMap());
    }


}
