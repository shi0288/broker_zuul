package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping(value = "/broker/template")
public class BrokerTemplateController extends BaseController {



    /**
     * 根据类型获取模板数据
     */
    @RequestMapping(value = "/listbytyps", method = RequestMethod.GET)
    public Result GetListByTypes(){
        return brokerServerCloud.templateListByTypes(this.getParameterMap());
    }

    /**
     * 获取经纪人短信、微聊模板  25
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result getList() {
        return brokerServerCloud.templateList(this.getParameterMap());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add() {
        return brokerServerCloud.templateAdd(this.getParameterMap());
    }

    /**
     * 更新短信/微聊模版
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update() {
        return brokerServerCloud.templateUpdate(this.getParameterMap());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(){
        return brokerServerCloud.templateDelete(this.getParameterMap());
    }



}
