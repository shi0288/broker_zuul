package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */
@RestController
@RequestMapping(value = "/broker/tags")
public class BrokerTagsController extends  BaseController {


    /**
     * 获取所有标签
     */
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public Result getTagsList(){
        return brokerServerCloud.tagsList(this.getParameterMap());

    }

    /**
     * 获取经纪人标签数据
     */
    @RequestMapping(value = "/brokertags", method = RequestMethod.GET)
    public Result getTagsByBroker(){
        return brokerServerCloud.tagsGet(this.getParameterMap());
    }

    /**
     * 修改经纪人标签
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveTags(){
        return brokerServerCloud.tagsSave(this.getParameterMap());
    }



}
