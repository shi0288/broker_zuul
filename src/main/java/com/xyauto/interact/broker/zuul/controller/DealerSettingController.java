package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping(value = "/dealer/setting")
public class DealerSettingController extends  BaseController {


    /**
     * 获取经销商客户意向等级
     */
    @RequestMapping(value = "/intention", method = RequestMethod.GET)
    public Result getCustomerIntentionLevel() {
        return brokerServerCloud.dealerSettingIntention(this.getParameterMap());
    }

    /**
     * 修改经销商客户意向等级
     */
    @RequestMapping(value = "/intention/update")
    public Result updateCustomerIntentionUpdate() {
        return brokerServerCloud.dealerSettingIntentionUpdate(this.getParameterMap());
    }

    /**
     * 重置经销商客户意向等级
     */
    @RequestMapping(value = "/intention/reset")
    public Result updateCustomerIntentionReset() {
        return brokerServerCloud.dealerSettingIntentionReset(this.getParameterMap());
    }

    /**
     * 获取经销商订单分配规则
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public Result distribution() {
        return brokerServerCloud.dealerSettingDistribution(this.getParameterMap());
    }

    /**
     * 修改经销商订单分配规则
     */
    @RequestMapping(value = "/distribution/update")
    public Result updateDistribution() {
        return brokerServerCloud.dealerSettingDistributionUpdate(this.getParameterMap());
}



}
