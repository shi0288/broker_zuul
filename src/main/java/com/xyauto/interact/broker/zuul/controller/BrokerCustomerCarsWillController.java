package com.xyauto.interact.broker.zuul.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xyauto.interact.broker.zuul.enums.ResultCode;
import com.xyauto.interact.broker.zuul.util.DateStyle;
import com.xyauto.interact.broker.zuul.util.DateUtil;
import com.xyauto.interact.broker.zuul.util.Result;
import com.xyauto.interact.broker.zuul.util.excel.ExcelUtils;
import com.xyauto.interact.broker.zuul.util.excel.ExcelVo;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shiqm on 2018-03-16.
 */

@RestController
@RequestMapping("/customer/carwill")
public class BrokerCustomerCarsWillController extends BaseController {


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update() {
        return brokerServerCloud.customerCarWillUpdate(this.getParameterMap());
    }

    @RequestMapping(value = "/deal", method = RequestMethod.GET)
    public Result add() {
        return brokerServerCloud.customerCarWillDealList(this.getParameterMap());
    }


    @RequestMapping(value = "/exportdeal", method = RequestMethod.GET)
    public Result exportdeal(HttpServletResponse response) {
        result= brokerServerCloud.customerCarWillExportdeal(this.getParameterMap());
        if (result != null && result.getCode() == 10000) {  
        	try {
        		String title = "成交记录";
                String excelName = "成交记录.xls";
                String[] headers = new String[]{"销售人员", "车型", "车主姓名", "成交时间", "提交时间", "发票状态"};
                List<Object[]> dataList = new ArrayList<Object[]>();
                Map<String, Object> resultMap = (Map<String, Object>) result.getData();
                List<Map> mapData = (List<Map>) resultMap.get("list");                                       
                for (Map item : mapData) {            	
                	List<String> row = Lists.newLinkedList();
                	row.add(item.getOrDefault("brokerName", StringUtils.EMPTY).toString());            	
                	//车型
                	Map<String, Object> series = (Map<String, Object>) item.getOrDefault("series", Maps.newConcurrentMap());
                	Map<String, Object> car = (Map<String, Object>) item.getOrDefault("car", Maps.newConcurrentMap());
                	StringBuffer seriesName=new StringBuffer();
                	String series_name=series==null?"":series.getOrDefault("name", StringUtils.EMPTY).toString();
                	seriesName.append(series_name).append(" ");
                	String car_name=car==null?"":car.getOrDefault("name", StringUtils.EMPTY).toString();
                	seriesName.append(car_name);
                	row.add(seriesName.toString());
                	//车主姓名
                	row.add(item.getOrDefault("customerName", StringUtils.EMPTY).toString());
                	//成交时间
                	row.add(DateUtil.timeStamp2Date(item.getOrDefault("dealTime", "0").toString(), DateStyle.YYYY_MM_DD_HH_MM_SS.getValue())); 
                	//提交时间
                	if (item.containsKey("createTime")&&item.get("createTime")!=null) {
                		row.add(DateUtil.timeStamp2Date(item.getOrDefault("createTime", "0").toString(), DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
					}else{
						row.add("1970-01-01 08:00:00");
					}
                	
                	//审核状态
                	String statusName = StringUtils.EMPTY;
                    switch (item.getOrDefault("status", 0).toString()) {
                        case "1":
                        	statusName = "已经审核";
                            break;
                        case "0":
                        	statusName = "未审核";
                            break;
                        case "-1":
                        	statusName = "审核不通过";
                            break; 
                        case "-2":
                        	statusName = "未上传发票";
                            break;    
                        default:
                        	statusName = StringUtils.EMPTY;
                            break;
                    }
                    row.add(statusName);
                	dataList.add(row.toArray(new String[row.size()]));
                }                          
                
                ExcelVo excelVo = new ExcelVo();
                excelVo.setTitle(title);
                excelVo.setRowName(headers);
                excelVo.setDataList(dataList);
                List<ExcelVo> excelList = new ArrayList<ExcelVo>();
                excelList.add(excelVo);
                ExcelUtils.exportExcel(excelName, excelList, response);
            	return result.format(ResultCode.Success, "导出线索信息");
			} catch (Exception e) {
				e.printStackTrace();
				return result.format(ResultCode.UnKnownError);
			}
        	
        } else {
            return result.format(ResultCode.UnKnownError);
        }
        
    }



}
