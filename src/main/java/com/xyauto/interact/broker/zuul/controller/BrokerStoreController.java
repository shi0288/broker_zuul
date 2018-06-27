package com.xyauto.interact.broker.zuul.controller;

import com.mcp.validate.annotation.Check;
import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping(value = "/broker/store/")
public class BrokerStoreController extends BaseController {


    /**
     * 创建经纪人微店
     */
    @RequestMapping(value = "/createstore", method = RequestMethod.POST)
    public Result createStore() {
        return brokerServerCloud.storeCreate(this.getParameterMap());
    }

    /**
     * 获取微店列表（区分经理和经纪人权限）
     */
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public Result getBrokerStoreList() {
        return brokerServerCloud.storeList(this.getParameterMap());
    }

    /**
     * 获取微店详细信息
     */
    @RequestMapping(value = "/getinfo", method = RequestMethod.GET)
    public Result get() {
        return brokerServerCloud.storeGet(this.getParameterMap());
    }

    /**
     * 创建标题导语
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result addDesription(@Check(value = "title", required = false) String title,
                                @Check(value = "introduction", required = false) String introduction,
                                @Check(value = "broker_id", required = true) long brokerId,
                                @Check(value = "type", required = true) short type,
                                @Check(value = "is_default") short isDefault) {
        return brokerServerCloud.storeCreateDescription(new HashMap() {{
            put("title",title);
            put("introduction",introduction);
            put("broker_id",brokerId);
            put("type",type);
            put("is_default",isDefault);
        }});
    }

    /**
     * 设置经纪人微店标题导语
     */
    @RequestMapping(value = "/settitleintroduction", method = RequestMethod.POST)
    public Result setTitleIntroduction() {
        return brokerServerCloud.storeSettingIntroduction(this.getParameterMap());
    }

    /**
     * 修改微店信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateParamByStoreId() {
        return brokerServerCloud.storeUpdate(this.getParameterMap());
    }

    /**
     * 微店-- 获取所有模板列表
     *
     * @return
     */
    @RequestMapping(value = "/alltemplate", method = RequestMethod.GET)
    public Result getAllTemplate() {
        return brokerServerCloud.storeAllTemplate(this.getParameterMap());
    }

    /**
     * 设置默认模板
     */
    @RequestMapping(value = "/storesettemplate", method = RequestMethod.POST)
    public Result setDefaultTemplate() {
        return brokerServerCloud.storeSetDefaultTemplate(this.getParameterMap());
    }

    /**
     * 微店设置热销的三款车型
     */
    @RequestMapping(value = "/sethotseries", method = RequestMethod.POST)
    public Result setHotSeries() {
        return brokerServerCloud.storeSetHotSeries(this.getParameterMap());
    }

    @RequestMapping(value = "/gethotseries", method = RequestMethod.GET)
    public Result getHotSeries() {
        return brokerServerCloud.storeGetHotSeries(this.getParameterMap());
    }

    @RequestMapping(value = "/getstoretemplate", method = RequestMethod.GET)
    public Result getStoreTemplate() {
        return brokerServerCloud.getStoreTemplate(this.getParameterMap());
    }
}
