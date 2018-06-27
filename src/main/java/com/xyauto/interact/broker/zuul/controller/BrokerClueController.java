package com.xyauto.interact.broker.zuul.controller;

import com.google.common.collect.Lists;
import com.mcp.validate.annotation.Check;
import com.xyauto.interact.broker.zuul.enums.ResultCode;
import com.xyauto.interact.broker.zuul.service.BrokerClueService;
import com.xyauto.interact.broker.zuul.util.DateUtil;
import com.xyauto.interact.broker.zuul.util.Result;
import com.xyauto.interact.broker.zuul.util.excel.ExcelUtils;
import com.xyauto.interact.broker.zuul.util.excel.ExcelVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shiqm on 2018-03-16.
 */
@RestController
@RequestMapping("/broker/clue")
public class BrokerClueController extends BaseController {

    @Autowired
    BrokerClueService brokerClueService;

    /**
     * 获取线索详细
     *
     * @param brokerClueId
     * @param targetBrokerId
     * @return
     */
    @RequestMapping(value = "/{broker_clue_id}/{target_broker_id}", method = RequestMethod.GET)
    public Result get(
            @PathVariable(value = "broker_clue_id", required = true) long brokerClueId,
            @PathVariable(value = "target_broker_id", required = true) long targetBrokerId
    ) {
        result = brokerServerCloud.clueGet(brokerClueId, targetBrokerId);
        return result;
    }

    /**
     * 获取线索详细
     *
     * @param brokerClueId
     * @return
     */
    @RequestMapping(value = "/{broker_clue_id}", method = RequestMethod.GET)
    public Result get(
            @PathVariable(value = "broker_clue_id", required = true) long brokerClueId
    ) {
        result = brokerServerCloud.clueGet(brokerClueId);
        return result;
    }

    /**
     * 获取线索详细
     *
     * @return
     */
    @RequestMapping(value = "/list/search", method = RequestMethod.GET)
    public Result searchList() {
        result = brokerServerCloud.clueSearchList(this.getParameterMap());
        return result;
    }

    /**
     * 获取线索详细
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/plist/search", method = RequestMethod.GET)
    public Result searchPList(HttpServletResponse response) {
        try {
            Map map = this.getParameterMap();
            if (map.containsKey("export") && map.get("export").equals("1")) {
//                map.put("limit", 2000);
//                map.remove("export");
                result = brokerServerCloud.clueSearchPList(map);
                String excelName = "no_treated.xls";
                if (map.containsKey("begin")) {
                	String begin=DateUtil.longToDateString(Long.parseLong((String)map.get("begin")));
                    String end=DateUtil.longToDateString(Long.parseLong((String)map.get("end")));
                    excelName = begin+"_"+end+".xls";
				}                
                if (result != null && result.getCode() == 10000) {                	
                    ExcelVo excelVo = new ExcelVo();
                    Map<String, Object> resultMap = (Map<String, Object>) result.getData();
                    List<Map> mapData = (List<Map>) resultMap.get("list");
                    long targetBrokerId = 0;
                    if (map.containsKey("target_broker_id")) {
                        targetBrokerId = Long.valueOf(String.valueOf(map.get("target_broker_id")));
                    }
                    if (map.containsKey("is_deleted") && map.get("is_deleted").equals("1")) {
                        excelVo = brokerClueService.clueExcelPassed(mapData, targetBrokerId);
                    } else {
                        excelVo = brokerClueService.clueExcelAll(mapData, targetBrokerId);
                    }
                    List<ExcelVo> excelList = Lists.newArrayList();
                    excelList.add(excelVo);
                    ExcelUtils.exportExcel(excelName, excelList, response);
                    return result.format(ResultCode.Success, "导出线索信息");
                } else {
                    return result.format(ResultCode.UnKnownError);
                }
            } else {
                result = brokerServerCloud.clueSearchPList(this.getParameterMap());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/pickup", method = RequestMethod.GET)
    public Result pickup() {
        result = brokerServerCloud.cluePickup(this.getParameterMap());
        return result;
    }

    @RequestMapping(value = "/list/history/limit", method = RequestMethod.GET)
    public Result historyListLimit() {
        result = brokerServerCloud.clueHistoryListLimit(this.getParameterMap());
        return result;
    }

    /**
     * 根据手机号批量查看历史线索
     */
    @RequestMapping(value = "/plist/history/batch", method = RequestMethod.GET)
    public Result getBatchClueHistoryBatch(
            @Check(value = "mobile", required = true)  List<String> mobileList,
            @Check(value = "dealer_id", required = true) long dealerId,
            @Check(value = "broker_id", required = false, defaultValue = "0") long brokerId,
            @Check(value = "target_broker_id", required = false,defaultValue = "0") long target_broker_id,
            @Check(value = "page", required = false, defaultValue = "1") int page,
            @Check(value = "limit", required = false, defaultValue = "100") int limit
    ){
        return brokerServerCloud.getBatchClueHistoryBatch(new HashMap() {{
            put("mobile",mobileList);
            put("dealer_id",dealerId);
            put("broker_id",brokerId);
            put("target_broker_id",target_broker_id);
            put("page",page);
            put("limit",limit);
        }});
/*        result = brokerServerCloud.getBatchClueHistoryList(this.getParameterMap());
        return result;*/
    }



    @RequestMapping(value = "/list/history", method = RequestMethod.GET)
    public Result historyList() {
        result = brokerServerCloud.clueHistoryList(this.getParameterMap());
        return result;
    }

    @RequestMapping(value = "/plist/history", method = RequestMethod.GET)
    public Result historyPList() {
        result = brokerServerCloud.clueHistoryPList(this.getParameterMap());
        return result;
    }

    @RequestMapping(value = "/list/call", method = RequestMethod.GET)
    public Result callList() {
        result = brokerServerCloud.clueCallList(this.getParameterMap());
        return result;
    }

    /**
     * 手工分配线索
     *
     * @return
     */
    @RequestMapping(value = "/distribute", method = RequestMethod.POST)
    public Result distribute(
            @Check(value = "broker_id", required = true) long brokerId,
            @Check(value = "target_broker_id", required = true) long targetBrokerId,
            @Check(value = "broker_clue_id", required = true) List<Long> brokerClueIds
    ) {
        //result = brokerServerCloud.distribute(this.getParameterMap());
        return brokerServerCloud.distribute(new HashMap() {{
            put("broker_id",brokerId);
            put("target_broker_id",targetBrokerId);
            put("broker_clue_id",brokerClueIds);
        }});
    }

    /**
     * 线索处理
     *
     * @return
     */
    @RequestMapping(value = "/handle", method = RequestMethod.GET)
    public Result handle() {
        result = brokerServerCloud.clueHandle(this.getParameterMap());
        return result;
    }


    @RequestMapping(value = "/getcluetypecount", method = RequestMethod.GET)
    public Result getClueTypeCount() {
        result = brokerServerCloud.getClueTypeCount(this.getParameterMap());
        return result;
    }
    
    @RequestMapping(value = "/pickup/log", method = RequestMethod.GET)
    public Result pickUpLog() {
        result = brokerServerCloud.pickUpLog(this.getParameterMap());
        return result;
    }



    

}
