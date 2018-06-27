package com.xyauto.interact.broker.zuul.cloud;

import com.mcp.fastcloud.annotation.ServerName;
import com.xyauto.interact.broker.zuul.util.Result;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

/**
 * Created by shiqm on 2018-03-09.
 */

@ServerName("qcdq-broker-assist")
public interface BrokerAssistCloud {

    @RequestLine("GET /task/list")
    Result list(@QueryMap Map map);

    @RequestLine("GET /task/op/list")
    Result opList(@QueryMap Map map);

    @RequestLine("GET /task/op/ext/list")
    Result opExtList(@QueryMap Map map);

    @RequestLine("GET /task/op/dealer/list")
    Result opDealerList(@QueryMap Map map);

    @RequestLine("GET /task/export/dealer/Schedule/list")
    Result scheduleList(@QueryMap Map map);

    @RequestLine("GET /task/apply/{apply}")
    Result execute(@Param("apply") String apply, @QueryMap Map map);

    @RequestLine("GET /task/ext/list")
    Result extList(@QueryMap Map map);

    @RequestLine("GET /task/list/point")
    Result listForPoint(@QueryMap Map map);


    @RequestLine("GET /task/op/dealer/list/brokers")
    Result opDealerListBrokers(@QueryMap Map map);


    @RequestLine("GET /task/op/month/finish/list")
    Result opMonthFinishList(@QueryMap Map map);



}
