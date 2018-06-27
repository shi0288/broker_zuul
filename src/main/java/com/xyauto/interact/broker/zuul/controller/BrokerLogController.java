package com.xyauto.interact.broker.zuul.controller;

import com.alibaba.fastjson.JSON;
import com.xyauto.interact.broker.zuul.enums.ResultCode;
import com.xyauto.interact.broker.zuul.util.Result;
import java.util.TreeMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */
@RestController
@RequestMapping("/log")
public class BrokerLogController extends BaseController {

    @RequestMapping(value = "/analytics", method = RequestMethod.GET)
    public Result analytics() {
        Result ret = brokerServerCloud.logAnalytics(this.getParameterMap());
        int type = Integer.valueOf(this.getParameterMap().getOrDefault("type", 0).toString());
        if (type == 99) {
            if (ret.getCode() == ResultCode.Success.getCode()) {
                TreeMap data = JSON.parseObject(JSON.toJSONString(ret.getData()), TreeMap.class);
                ret.setData(data.descendingMap());
            }
        }
        return ret;
    }

    @RequestMapping(value = "/materiel/share")
    public Result materielShare() {
        return brokerServerCloud.materielShare(this.getParameterMap());
    }



    @RequestMapping(value = "/xyh/customer/logs")
    public Result xyhCustomerLogs() {
        return brokerServerCloud.xyhCustomerLogs(this.getParameterMap());
    }

    @RequestMapping(value = "/xyh/clue/logs")
    public Result xyhClueLogs() {
        return brokerServerCloud.xyhClueLogs(this.getParameterMap());
    }

}
