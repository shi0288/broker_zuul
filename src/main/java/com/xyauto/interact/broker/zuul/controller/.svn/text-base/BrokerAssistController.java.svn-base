package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.cloud.BrokerAssistCloud;
import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-20.
 */

@RestController
@RequestMapping(value = "task")
public class BrokerAssistController extends BaseController {

    @Autowired
    private BrokerAssistCloud brokerAssistlCloud;


    /**
     * 获取任务列表
     */
    @RequestMapping(value = "list")
    public Result list() {
        result = brokerAssistlCloud.list(this.getParameterMap());
        return result;
    }


    /**
     */
    @RequestMapping(value = "op/list")
    public Result opList() {
        result = brokerAssistlCloud.opList(this.getParameterMap());
        return result;
    }


    /**
     * op获取任务信息
     */
    @RequestMapping(value = "op/ext/list")
    public Result opExtList() {
        result = brokerAssistlCloud.opExtList(this.getParameterMap());
        return result;
    }


    /**
     * op获取任务信息
     */
    @RequestMapping(value = "op/dealer/list")
    public Result opDealerList() {
        result = brokerAssistlCloud.opDealerList(this.getParameterMap());
        return result;
    }


    /**
     * 获取经经销商排期
     */
    @RequestMapping(value = "export/dealer/Schedule/list")
    public Result listForDealerSchedule() {
        result = brokerAssistlCloud.scheduleList(this.getParameterMap());
        return result;
    }

    /**
     * 经销商车顾问详情
     */
    @RequestMapping(value = "op/dealer/list/brokers")
    public Result opDealerListBrokers() {
        result = brokerAssistlCloud.opDealerListBrokers(this.getParameterMap());
        return result;
    }


    /**
     * 经销商车顾问或车顾问月完成度详情
     */
    @RequestMapping(value = "op/month/finish/list")
    public Result opMonthFinishList() {
        result = brokerAssistlCloud.opMonthFinishList(this.getParameterMap());
        return result;
    }


}
