package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping("/broker/receipt")
public class BrokerReceiptController extends BaseController {


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Result upLoadInvoice() {
        return brokerServerCloud.receiptUpload(this.getParameterMap());
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result get() {
        return brokerServerCloud.receiptGet(this.getParameterMap());
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result create() {
            return brokerServerCloud.receiptCreate(this.getParameterMap());
    }

    @RequestMapping(value="getbrokerlistinfo",method = RequestMethod.GET)
    Result getBrokerListInfo() {
        return brokerServerCloud.getBrokerListInfo(this.getParameterMap());
    }
}
