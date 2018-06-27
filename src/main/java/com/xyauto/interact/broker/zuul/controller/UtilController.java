package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-23.
 */

@RestController
@RequestMapping(value = "/util")
public class UtilController extends BaseController{


    @RequestMapping(value = "/bannerlist")
    public Result getBannerList() {
        return brokerServerCloud.utilGetBannerList();
    }


    @RequestMapping(value = "/appversion")
    public Result getAppVersion() {
        return brokerServerCloud.utilGetAppVersion();
    }






}
