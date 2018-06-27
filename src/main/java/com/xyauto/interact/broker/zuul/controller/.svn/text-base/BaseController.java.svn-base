package com.xyauto.interact.broker.zuul.controller;

import com.mcp.fastcloud.annotation.Log;
import com.xyauto.interact.broker.zuul.cloud.BrokerServerCloud;
import com.xyauto.interact.broker.zuul.util.Result;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.context.annotation.Scope;

/**
 * Created by shiqm on 2018-03-16.
 */
@Scope("prototype")
public class BaseController {

    @Autowired
    protected BrokerServerCloud brokerServerCloud;

    @Autowired
    protected Result result;

    @Log
    protected Logger LOGGER;

    @Autowired
    protected HttpServletRequest httpServletRequest;

    @Autowired
    protected HttpServletResponse httpServletResponse;


    protected  Map getParameterMap() {
        // 参数Map
        Map properties = httpServletRequest.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            if (StringUtils.isNotBlank(value)) {
            	returnMap.put(name, value);
			}
            
        }
        returnMap.remove("callback");
        return returnMap;
    }



}
