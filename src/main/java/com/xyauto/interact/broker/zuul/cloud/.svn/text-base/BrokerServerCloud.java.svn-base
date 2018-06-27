package com.xyauto.interact.broker.zuul.cloud;

import com.mcp.fastcloud.annotation.ServerName;
import com.xyauto.interact.broker.zuul.util.Result;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Created by shiqm on 2018-03-14.
 */

@ServerName("QCDQ-INTERACT-BROKER-SERVER")
public interface BrokerServerCloud {


//+---------------------------------------------------
//| integral
//+---------------------------------------------------

    /**
     * 查询用户余额
     */
    @RequestLine("GET /broker/integral/brokerintegral")
    Result integralQueryBalance(@QueryMap Map map);


    /**
     * 增加用户积分
     */
    @RequestLine("GET /broker/integral/addintegral")
    Result integralAddPoint(@QueryMap Map map);

    /**
     * 用户明细
     */
    @RequestLine("GET /broker/integral/list")
    Result integralList(@QueryMap Map map);


//+---------------------------------------------------
//| store
//+---------------------------------------------------


    /**
     * ------
     */
    @RequestLine("POST /broker/store/createstore")
    Result storeCreate(@QueryMap Map map);

    /**
     * ------
     */
    @RequestLine("GET /broker/store/getlist")
    Result storeList(@QueryMap Map map);

    /**
     * ------
     */
    @RequestLine("GET /broker/store/getinfo")
    Result storeGet(@QueryMap Map map);


    /**
     * ------
     */
    @RequestLine("POST /broker/store/create")
    Result storeCreateDescription(@QueryMap Map map);


    /**
     * ------
     */
    @RequestLine("POST /broker/store/settitleintroduction")
    Result storeSettingIntroduction(@QueryMap Map map);


    /**
     * ------
     */
    @RequestLine("POST /broker/store/update")
    Result storeUpdate(@QueryMap Map map);

    /**
     * ------
     */
    @RequestLine("GET /broker/store/alltemplate")
    Result storeAllTemplate(@QueryMap Map map);

    /**
     * ------
     */
    @RequestLine("POST /broker/store/storesettemplate")
    Result storeSetDefaultTemplate(@QueryMap Map map);


    /**
     * ------
     */
    @RequestLine("POST /broker/store/sethotseries")
    Result storeSetHotSeries(@QueryMap Map map);


    /**
     * ------
     */
    @RequestLine("GET /broker/store/gethotseries")
    Result storeGetHotSeries(@QueryMap Map map);


    /**
     * 获取当前经纪人模板id
     * @param map
     * @return
     */
    @RequestLine("GET /broker/store/getstoretemplate")
    Result getStoreTemplate(@QueryMap Map map);

//+---------------------------------------------------
//| block
//+---------------------------------------------------

    @RequestLine("GET /block/get")
    Result blockGet(@QueryMap Map map);

//+---------------------------------------------------
//| clue
//+---------------------------------------------------


    @RequestLine("GET /broker/clue/{broker_clue_id}/{target_broker_id}")
    Result clueGet(@Param("broker_clue_id") Long broker_clue_id,@Param("target_broker_id") Long target_broker_id);

    @RequestLine("GET /broker/clue/{broker_clue_id}")
    Result clueGet(@Param("broker_clue_id") Long broker_clue_id);

    @RequestLine("GET /broker/clue/list/search")
    Result clueSearchList(@QueryMap Map map);

    @RequestLine("GET /broker/clue/plist/search")
    Result clueSearchPList(@QueryMap Map map);

    @RequestLine("GET /broker/clue/pickup")
    Result cluePickup(@QueryMap Map map);

    @RequestLine("GET /broker/clue/list/history/limit")
    Result clueHistoryListLimit(@QueryMap Map map);

    @RequestLine("GET /broker/clue/plist/history/batch")
    Result getBatchClueHistoryBatch(@QueryMap Map map);


    @RequestLine("GET /broker/clue/list/history")
    Result clueHistoryList(@QueryMap Map map);

    @RequestLine("GET /broker/clue/plist/history")
    Result clueHistoryPList(@QueryMap Map map);

    @RequestLine("GET /broker/clue/list/call")
    Result clueCallList(@QueryMap Map map);

    @RequestLine("POST /broker/clue/distribute")
    Result distribute(@QueryMap Map map);
    
    @RequestLine("GET /broker/clue/handle")
    Result clueHandle(@QueryMap Map map);


    @RequestLine("GET /broker/clue/getcluetypecount")
    public Result getClueTypeCount(@QueryMap Map map);
    
    @RequestLine("GET /broker/clue/pickup/log")
    public Result pickUpLog(@QueryMap Map map);



//+---------------------------------------------------
//| broker
//+---------------------------------------------------


    @RequestLine("GET /broker/{broker_id}")
    Result brokerGet(@Param("broker_id") Long broker_id);

    @RequestLine("GET /broker/list/batch")
    Result brokerBatchList(@QueryMap Map map);

    @RequestLine("GET /broker/list")
    Result brokerList(@QueryMap Map map);

    @RequestLine("GET /broker/plist")
    Result brokerPList(@QueryMap Map map);

    @RequestLine("GET /broker/list/search")
    Result brokerSearchList(@QueryMap Map map);

    @RequestLine("GET /broker/plist/search")
    Result brokerSearchPList(@QueryMap Map map);

    @RequestLine("GET /broker/prize/list")
    Result brokerPrizeList(@QueryMap Map map);

    @RequestLine("POST /broker/setbroker")
    Result brokerSetBroker(@QueryMap Map map);

    @RequestLine("GET /broker/getbrokertotallist")
    Result brokerGetBrokerTotalList(@QueryMap Map map);

    @RequestLine("GET /broker/add")
    Result brokerAdd(@QueryMap Map map);

    @RequestLine("GET /broker/update")
    Result brokerUpdate(@QueryMap Map map);

    @RequestLine("GET /broker/getrandbroker")
    Result getBrokerByDealerId(@QueryMap Map map);

    @RequestLine("GET /broker/sync")
    Result SyncBrokerInfo(@QueryMap Map map);


    @RequestLine("GET /broker/getbrokerbydealerrule")
    Result getBrokerByDealerRule(@QueryMap Map map);


    @RequestLine("GET /broker/article/relevant")
    Result getBrokerBySaleSerial(@QueryMap Map map);

    //+---------------------------------------------------
//| customer/car
//+---------------------------------------------------
    @RequestLine("POST /customer/car/update")
    Result customerCarUpdate(@QueryMap Map map);

    @RequestLine("POST /customer/car/add")
    Result customerCarAdd(@QueryMap Map map);

    @RequestLine("POST /customer/car/delete")
    Result customerCarDelete(@QueryMap Map map);


    //+---------------------------------------------------
//| customer/carwill
//+---------------------------------------------------
    @RequestLine("POST /customer/carwill/update")
    Result customerCarWillUpdate(@QueryMap Map map);

    @RequestLine("GET /customer/carwill/deal")
    Result customerCarWillDealList(@QueryMap Map map);

    @RequestLine("GET /customer/carwill/exportdeal")
    Result customerCarWillExportdeal(@QueryMap Map map);


//+---------------------------------------------------
//| broker/customer
//+---------------------------------------------------

    @RequestLine("GET /broker/customer/{broker_customer_id}")
    Result brokerCustomerGet(@Param("broker_customer_id") Long broker_customer_id);

    @RequestLine("GET /broker/customer/info")
    Result brokerCustomerInfo(@QueryMap Map map);

    @RequestLine("GET /broker/customer/info/ext")
    Result brokerCustomerInfoExt(@QueryMap Map map);

    @RequestLine("GET /broker/customer/list")
    Result brokerCustomerList(@QueryMap Map map);

    @RequestLine("GET /broker/customer/plist")
    Result brokerCustomerPList(@QueryMap Map map);

    @RequestLine("GET /broker/customer/count/today")
    Result brokerCustomerTodayCount(@QueryMap Map map);

    @RequestLine("GET /broker/customer/search/clue")
    Result brokerCustomerSearchClue(@QueryMap Map map);

    @RequestLine("GET /broker/customer/search")
    Result brokerCustomerSearch(@QueryMap Map map);

    @RequestLine("GET /broker/customer/psearch")
    Result brokerCustomerPSearch(@QueryMap Map map);

    @RequestLine("POST /broker/customer/create")
    Result brokerCustomeAddCustomer(@QueryMap Map map);

    @RequestLine("POST /broker/customer/update")
    Result brokerCustomeUpdateInfo(@QueryMap Map map);
    
    @RequestLine("GET /broker/customer/contact")
    Result brokerContactCustomer(@QueryMap Map map);


//+---------------------------------------------------
//| log
//+---------------------------------------------------

    @RequestLine("GET /log/analytics")
    Result logAnalytics(@QueryMap Map map);
    
    @RequestLine("GET /log/xyh/customer/logs")
    Result xyhCustomerLogs(@QueryMap Map map);
    
    @RequestLine("GET /log/xyh/clue/logs")
    Result xyhClueLogs(@QueryMap Map map);

    @RequestLine("GET /log/materiel/share")
    Result materielShare(@QueryMap Map map);

//+---------------------------------------------------
//| receipt
//+---------------------------------------------------

    @RequestLine("POST /broker/receipt/upload")
    Result receiptUpload(@QueryMap Map map);

    @RequestLine("GET /broker/receipt/get")
    Result receiptGet(@QueryMap Map map);

    @RequestLine("POST /broker/receipt/create")
    Result receiptCreate(@QueryMap Map map);

    @RequestLine("GET /broker/receipt/getbrokerlistinfo")
    Result getBrokerListInfo(@QueryMap Map map);

//+---------------------------------------------------
//| setting
//+---------------------------------------------------

    @RequestLine("POST /broker/setting/update")
    Result settingUpdate(@QueryMap Map map);

    @RequestLine("GET /broker/setting/get")
    Result settingGet(@QueryMap Map map);


//+---------------------------------------------------
//| tags
//+---------------------------------------------------

    @RequestLine("GET /broker/tags/getlist")
    Result tagsList(@QueryMap Map map);

    @RequestLine("GET /broker/tags/brokertags")
    Result tagsGet(@QueryMap Map map);

    @RequestLine("GET /broker/tags/save")
    Result tagsSave(@QueryMap Map map);


//+---------------------------------------------------
//| task
//+---------------------------------------------------

    @RequestLine("GET /broker/task/dealer")
    Result taskDealer(@QueryMap Map map);

    @RequestLine("GET /broker/task/get")
    Result taskGet(@QueryMap Map map);

    @RequestLine("GET /broker/task/listpoint")
    Result taskPointList(@QueryMap Map map);

    @RequestLine("GET /broker/task/exttasklist")
    Result taskExtList(@QueryMap Map map);

    @RequestLine("GET /broker/task/dealerschedulelist")
    Result taskDealerScheduleList(@QueryMap Map map);

//+---------------------------------------------------
//| template
//+---------------------------------------------------

    @RequestLine("GET /broker/template/listbytyps")
    Result templateListByTypes(@QueryMap Map map);

    @RequestLine("GET /broker/template/list")
    Result templateList(@QueryMap Map map);

    @RequestLine("POST /broker/template/add")
    Result templateAdd(@QueryMap Map map);

    @RequestLine("POST /broker/template/update")
    Result templateUpdate(@QueryMap Map map);

    @RequestLine("POST /broker/template/delete")
    Result templateDelete(@QueryMap Map map);

//+---------------------------------------------------
//| dealer
//+---------------------------------------------------

    @RequestLine("GET /dealer/{dealer_id}")
    Result dealerGet(@Param("dealer_id") Long dealer_id);

    @RequestLine("GET /dealer/city/brands")
    Result dealerBrandList(@QueryMap Map map);

    @RequestLine("GET /dealer/city/series")
    Result dealerSeriesList(@QueryMap Map map);



//+---------------------------------------------------
//| dealer/setting
//+---------------------------------------------------

    @RequestLine("GET /dealer/setting/intention")
    Result dealerSettingIntention(@QueryMap Map map);

    @RequestLine("GET /dealer/setting/intention/update")
    Result dealerSettingIntentionUpdate(@QueryMap Map map);

    @RequestLine("GET /dealer/setting/intention/reset")
    Result dealerSettingIntentionReset(@QueryMap Map map);

    @RequestLine("GET /dealer/setting/distribution")
    Result dealerSettingDistribution(@QueryMap Map map);

    @RequestLine("GET /dealer/setting/distribution/update")
    Result dealerSettingDistributionUpdate(@QueryMap Map map);

//+---------------------------------------------------
//| util
//+---------------------------------------------------


    @RequestLine("GET /util/bannerlist")
    Result utilGetBannerList();

    @RequestLine("GET /util/appversion")
    Result utilGetAppVersion();

}
