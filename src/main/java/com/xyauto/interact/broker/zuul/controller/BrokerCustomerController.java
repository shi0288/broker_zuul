package com.xyauto.interact.broker.zuul.controller;

import com.google.common.collect.Maps;
import com.mcp.validate.annotation.Check;
import com.xyauto.interact.broker.zuul.enums.CustomerLevelEnum;
import com.xyauto.interact.broker.zuul.enums.ResultCode;
import com.xyauto.interact.broker.zuul.util.DateStyle;
import com.xyauto.interact.broker.zuul.util.DateUtil;
import com.xyauto.interact.broker.zuul.util.Result;
import com.xyauto.interact.broker.zuul.util.excel.ExcelUtils;
import com.xyauto.interact.broker.zuul.util.excel.ExcelVo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by shiqm on 2018-03-16.
 */
@RestController
@RequestMapping("/broker/customer")
public class BrokerCustomerController extends BaseController {

    @RequestMapping(value = "/{broker_customer_id}", method = RequestMethod.GET)
    public Result get(
            @PathVariable(value = "broker_customer_id", required = true) long brokerCustomerId) {
        return brokerServerCloud.brokerCustomerGet(brokerCustomerId);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Result getInfo() {
        return brokerServerCloud.brokerCustomerInfo(this.getParameterMap());
    }

    @RequestMapping(value = "/info/ext", method = RequestMethod.GET)
    public Result getInfoExt() {
        return brokerServerCloud.brokerCustomerInfoExt(this.getParameterMap());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list() {
        return brokerServerCloud.brokerCustomerList(this.getParameterMap());
    }

    @RequestMapping(value = "/plist", method = RequestMethod.GET)
    public Result plist() {
        return brokerServerCloud.brokerCustomerPList(this.getParameterMap());
    }

    @RequestMapping(value = "/count/today", method = RequestMethod.GET)
    public Result getTodayNewCount() {
        return brokerServerCloud.brokerCustomerTodayCount(this.getParameterMap());
    }

    @RequestMapping(value = "/search/clue")
    public Result searchClue() {
        return brokerServerCloud.brokerCustomerSearchClue(this.getParameterMap());
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result search() {
        return brokerServerCloud.brokerCustomerSearch(this.getParameterMap());
    }

    @RequestMapping(value = "/psearch", method = RequestMethod.GET)
    public Result psearch( HttpServletResponse response) {
    	try {
    		Map map = this.getParameterMap();
        	if (map.containsKey("export") && map.get("export").equals("1")) {
        		result=brokerServerCloud.brokerCustomerPSearch(this.getParameterMap());
        		if (result == null || result.getCode() != 10000) {  
        			 return result.format(ResultCode.UnKnownError);
        		}
        		Map<String, Object> resultMap = (Map<String, Object>) result.getData();
                List<Map> mapData = (List<Map>) resultMap.get("list");
        		//导出
                List<Object[]> dataList = new ArrayList<Object[]>();
                Object[] objs = null;
                String title = "customer";
                String excelName = "customer.xls";
                String[] headers = new String[]{"客户等级", "客户姓名", "客户手机号", "销售负责人", "跟进状态", "创建时间", "意向车型","备注"};
                for (Map data : mapData) {
                    objs = new Object[headers.length];
                    objs[0] = CustomerLevelEnum.getCustomerLevelName(Short.parseShort(data.get("level").toString()));
                    objs[1] = data.getOrDefault("userName", "").toString();   
                    objs[2] = data.getOrDefault("mobile", "").toString(); 
                    Map<String, Object> brokerInfo = (Map<String, Object>) data.getOrDefault("brokerInfo", Maps.newConcurrentMap());
                    if (brokerInfo!=null) {
                    	objs[3] = brokerInfo.getOrDefault("name", "").toString(); 
					}else{
						objs[3]="";
					}
                    //1待跟进，2到店，5成交，-1无效，-2战败
                    switch (Short.parseShort(data.get("step").toString())) {
                        case 1:
                            objs[4] = "待跟进";
                            break;
                        case 2:
                            objs[4] = "到店";
                            break;
                        case 5:
                            objs[4] = "成交";
                            break;
                        case -1:
                            objs[4] = "无效";
                            break;
                        case -2:
                            objs[4] = "战败";
                            break;
                    }
                    objs[5] = DateUtil.timeStamp2Date(data.getOrDefault("createTime", "0").toString(), DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
                    Map<String, Object> carsWill = (Map<String, Object>) data.getOrDefault("carsWill", Maps.newConcurrentMap());
                    if (carsWill == null||carsWill.size()<=0) {
                        objs[6] = "";
                    } else {                    	
                    	Map<String, Object> seriesInfo = (Map<String, Object>) carsWill.getOrDefault("seriesInfo", Maps.newConcurrentMap());
                    	Map<String, Object> carInfo = (Map<String, Object>) carsWill.getOrDefault("carInfo", Maps.newConcurrentMap());
                        String car_name="";
                    	if (seriesInfo!=null) {
                    		car_name=seriesInfo.getOrDefault("name","").toString();
						}
                    	if (carInfo!=null) {
                    		car_name=car_name+carInfo.getOrDefault("name","").toString();
						}
                    	objs[6] = car_name;
                    }
                    objs[7]=data.getOrDefault("remark","").toString();
                    dataList.add(objs);
                }
                ExcelVo excelVo = new ExcelVo();
                excelVo.setTitle(title);
                excelVo.setRowName(headers);
                excelVo.setDataList(dataList);
                List<ExcelVo> excelList = new ArrayList<ExcelVo>();
                excelList.add(excelVo);
                ExcelUtils.exportExcel(excelName, excelList, response);
                return result.format(ResultCode.Success, "导出客户信息");
        	}else{
        		result=brokerServerCloud.brokerCustomerPSearch(this.getParameterMap());
        	}
        	return  result;
		} catch (Exception e) {
			e.printStackTrace();
			return result.format(ResultCode.UnKnownError);
		}
    	
        
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(
            @Check(value = "broker_clue_id", required = false, defaultValue = "0") long brokerClueId,
            @Check(value = "broker_id", required = true) long brokerId,
            @Check(value = "dealer_id", required = true) long dealerId,
            @Check(value = "username", required = true) String userName,
            @Check(value = "gender", required = false, defaultValue = "0") short gender,
            @Check(value = "mobile", length = 11, required = true) String phone,
            @Check(value = "province_id", required = false, defaultValue = "0") int provinceId,
            @Check(value = "city_id", required = false, defaultValue = "0") int cityId,
            @Check(value = "step", required = false, defaultValue = "1") short step,
            @Check(value = "next_contact_time", required = false, defaultValue = "") String nextContactTime,
            @Check(value = "level", required = true) short level,
            @Check(value = "car_id", required = false, defaultValue = "0") int carId,
            @Check(value = "category", required = false, defaultValue = "0") short category,
            @Check(value = "register_province_id", required = false, defaultValue = "0") int registerProvinceId,
            @Check(value = "register_city_id", required = false, defaultValue = "0") int registerCityId,
            @Check(value = "pay_type", required = false, defaultValue = "0") short payType,
            @Check(value = "exchange_type", required = false, defaultValue = "0") short exchangeType,
            @Check(value = "buy_desc", required = false, defaultValue = "0") short buyDesc,
            @Check(value = "budget", required = false, defaultValue = "") String budget,
            @Check(value = "is_allopatry_register", required = false, defaultValue = "-1") short isAllopatryRegister,
            @Check(value = "remark", required = false, defaultValue = "") String remark,
            @Check(value = "car_ids", required = false, defaultValue = "0") List<Integer> carIds
    ) {
        //return brokerServerCloud.brokerCustomeAddCustomer(this.getParameterMap());
        return brokerServerCloud.brokerCustomeAddCustomer(new HashMap() {{
            put("broker_clue_id",brokerClueId);
            put("broker_id",brokerId);
            put("dealer_id",dealerId);
            put("username",userName);
            put("gender",gender);
            put("mobile",phone);
            put("province_id",provinceId);
            put("city_id",cityId);
            put("step",step);
            put("next_contact_time",nextContactTime);
            put("level",level);
            put("car_id",carId);
            put("category",category);
            put("register_province_id",registerProvinceId);
            put("register_city_id",registerCityId);
            put("pay_type",payType);
            put("exchange_type",exchangeType);
            put("buy_desc",buyDesc);
            put("budget",budget);
            put("is_allopatry_register",isAllopatryRegister);
            put("remark",remark);
            put("car_ids",carIds);
        }});
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update() {
        return brokerServerCloud.brokerCustomeUpdateInfo(this.getParameterMap());
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public Result contact() {
        return brokerServerCloud.brokerContactCustomer(this.getParameterMap());
    }

}
