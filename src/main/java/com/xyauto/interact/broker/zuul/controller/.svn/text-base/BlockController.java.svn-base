package com.xyauto.interact.broker.zuul.controller;

import com.xyauto.interact.broker.zuul.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping("/block")
public class BlockController extends BaseController{


    /**
     * 获取块数据
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result get() {
        result = brokerServerCloud.blockGet(this.getParameterMap());
        return result;
    }


}
