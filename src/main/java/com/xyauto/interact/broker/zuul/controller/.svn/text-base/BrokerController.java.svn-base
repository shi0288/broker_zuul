package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/broker")
public class BrokerController extends BaseController {


    /**
     * 获取经纪人详情
     */
    @RequestMapping(value = "/{broker_id}", method = RequestMethod.GET)
    public Result get(
            @PathVariable(value = "broker_id", required = true) long brokerId) {
        return brokerServerCloud.brokerGet(brokerId);
    }


    @RequestMapping("/list/batch")
    public Result batchList() {
        return brokerServerCloud.brokerBatchList(this.getParameterMap());
    }


    @RequestMapping("/list")
    public Result list() {
        return brokerServerCloud.brokerList(this.getParameterMap());
    }


    @RequestMapping("/plist")
    public Result plist() {
        result = brokerServerCloud.brokerPList(this.getParameterMap());
        return result;
    }


    @RequestMapping("/list/search")
    public Result searchList() {
        result = brokerServerCloud.brokerSearchList(this.getParameterMap());
        return result;
    }

    @RequestMapping("/plist/search")
    public Result searchPList() {
        result = brokerServerCloud.brokerSearchPList(this.getParameterMap());
        return result;
    }


    @RequestMapping(value = "/setbroker", method = RequestMethod.POST)
    public Result setCustomerToBroker(){
        result = brokerServerCloud.brokerSetBroker(this.getParameterMap());
        return result;
    }


    /**
     * 获取经纪人获奖列表
     */
    @RequestMapping(value = "/prize/list", method = RequestMethod.GET)
    public Result getPrizeList() {
        result = brokerServerCloud.brokerPrizeList(this.getParameterMap());
        return result;
    }

    /**
     * 获取城市对应 经纪人数量
     */
    @RequestMapping(value = "/getbrokertotallist", method = RequestMethod.GET)
    public Result getBrokerTotalList() {
        result = brokerServerCloud.brokerGetBrokerTotalList(this.getParameterMap());
        return result;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Result add() {
        result = brokerServerCloud.brokerAdd(this.getParameterMap());
        return result;
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Result update()
    {
        result = brokerServerCloud.brokerUpdate(this.getParameterMap());
        return result;
    }


    @RequestMapping(value = "/getrandbroker",method = RequestMethod.GET)
    public Result getBrokerByDealerId() {
        result = brokerServerCloud.getBrokerByDealerId(this.getParameterMap());
        return result;
    }

    @RequestMapping(value = "/sync")
    public Result SyncBrokerInfo() {
        result = brokerServerCloud.SyncBrokerInfo(this.getParameterMap());
        return result;
    }

    @RequestMapping(value = "/getbrokerbydealerrule",method = RequestMethod.GET)
    public Result getBrokerByDealerRule() {
        result = brokerServerCloud.getBrokerByDealerRule(this.getParameterMap());
        return result;
    }


    @RequestMapping(value = "/article/relevant",method = RequestMethod.GET)
    public Result getBrokerBySaleSerial(){
        result = brokerServerCloud.getBrokerBySaleSerial(this.getParameterMap());
        return result;
    }


}