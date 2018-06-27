package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.cloud.BrokerAssistCloud;
import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
public class BrokerTaskController extends BaseController {

    @Autowired
    private BrokerAssistCloud brokerAssistCloud;


    @RequestMapping(value = "/broker/task/dealer", method = RequestMethod.GET)
    public Result listByDealer() {
        return brokerServerCloud.taskDealer(this.getParameterMap());
    }


    @RequestMapping(value = "/broker/task/get", method = RequestMethod.GET)
    public Result get() {
        return brokerServerCloud.taskGet(this.getParameterMap());
    }


    @RequestMapping(value = "/broker/task/listpoint")
    public Result listPoint() {
        return brokerServerCloud.taskPointList(this.getParameterMap());
    }

    /**
     * app吃米线任务列表
     */
    @RequestMapping(value = "/broker/task/exttasklist")
    public Result extTaskList() {
        return brokerServerCloud.taskExtList(this.getParameterMap());
    }

    @RequestMapping(value = "/broker/task/dealerschedulelist")
    public Result dealerScheduleList() {
        return brokerServerCloud.taskDealerScheduleList(this.getParameterMap());
    }


    @RequestMapping("/task/apply/{apply}")
    public Result execute(@PathVariable(name = "apply") String apply) {
        return brokerAssistCloud.execute(apply, this.getParameterMap());
    }

    @RequestMapping(value = "/task/ext/list")
    public Result extList() {
        return brokerAssistCloud.extList(this.getParameterMap());
    }

    @RequestMapping(value = "/task/list/point")
    public Result listForPoint() {
        return brokerAssistCloud.listForPoint(this.getParameterMap());
    }


}
