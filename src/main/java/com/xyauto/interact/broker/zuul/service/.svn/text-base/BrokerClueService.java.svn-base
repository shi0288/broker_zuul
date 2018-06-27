package com.xyauto.interact.broker.zuul.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mcp.validate.validator.Date;
import com.xyauto.interact.broker.zuul.cloud.BrokerServerCloud;
import com.xyauto.interact.broker.zuul.util.DateStyle;
import com.xyauto.interact.broker.zuul.util.DateUtil;
import com.xyauto.interact.broker.zuul.util.excel.ExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

@Service
public class BrokerClueService {

    @Autowired
    protected BrokerServerCloud brokerServerCloud;

    /**
     * 流失线索导出数据
     *
     * @param list
     * @param brokerTagetBrokerId
     * @return
     */
    public ExcelVo clueExcelAll(List<Map> list, long brokerTagetBrokerId) {
        try {
            List<Object[]> dataList = Lists.newArrayList();
            List<Long> brokerClueIds = Lists.newArrayList();
            String[] headers = new String[]{"客户姓名", "省份", "城市", "手机号码", "购车指标数", "是否分配", "销售负责人", "线索获得时间", "品牌", "车型", "线索来源"};
            for (Map map : list) {
                List<String> row = Lists.newLinkedList();
                //客户姓名
                row.add(map.getOrDefault("username", StringUtils.EMPTY).toString());
                //省份
                Map<String, Object> province = (Map<String, Object>) map.getOrDefault("province", Maps.newConcurrentMap());
                row.add(province == null ? StringUtils.EMPTY : province.getOrDefault("name", StringUtils.EMPTY).toString());
                //城市
                Map<String, Object> city = (Map<String, Object>) map.getOrDefault("city", Maps.newConcurrentMap());
                row.add(city == null ? StringUtils.EMPTY : city.getOrDefault("name", StringUtils.EMPTY).toString());
                //手机号码
                row.add(map.getOrDefault("mobile", StringUtils.EMPTY).toString());
                //购车指标数
                row.add(map.getOrDefault("carPurchasingIndex", "0").toString());
                //是否分配
                row.add(Long.valueOf(map.getOrDefault("brokerId", "0").toString()) > 0 ? "是" : "否");
                //销售负责人
                Map broker = (Map) map.getOrDefault("broker", Maps.newConcurrentMap());
                row.add(broker==null ?  StringUtils.EMPTY: broker.getOrDefault("name", StringUtils.EMPTY).toString());
                //线索获得时间
                row.add(DateUtil.timeStamp2Date(map.getOrDefault("createTime", "0").toString(), DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));                                               
                //品牌
                Map<String, Object> brand = (Map<String, Object>) map.getOrDefault("brand", Maps.newConcurrentMap());
                row.add(brand==null?StringUtils.EMPTY : brand.getOrDefault("name", StringUtils.EMPTY).toString());
                
                StringBuffer buffer=new StringBuffer();
                //车型
                Map<String, Object> series = (Map<String, Object>) map.getOrDefault("series", Maps.newConcurrentMap());
//                row.add(series==null?StringUtils.EMPTY :series.getOrDefault("name", StringUtils.EMPTY).toString());
                String seriesName=series==null?StringUtils.EMPTY :series.getOrDefault("name", StringUtils.EMPTY).toString();
                buffer.append(seriesName).append(" ");
                //年款
                Map<String, Object> car = (Map<String, Object>) map.getOrDefault("car", Maps.newConcurrentMap());
//                row.add(car==null?StringUtils.EMPTY :car.getOrDefault("year", StringUtils.EMPTY).toString());
                String year=car==null?StringUtils.EMPTY :car.getOrDefault("year", StringUtils.EMPTY).toString();
                buffer.append(year).append("款  ");
                String carName=car==null?StringUtils.EMPTY :car.getOrDefault("name", StringUtils.EMPTY).toString();
                buffer.append(carName);
                row.add(buffer.toString());
                //车款
//                row.add(car==null?StringUtils.EMPTY :car.getOrDefault("name", StringUtils.EMPTY).toString());
                //线索来源
                String sourceName = StringUtils.EMPTY;
                switch (map.getOrDefault("source", 0).toString()) {
                    case "1":
                        sourceName = "店铺线索";
                        break;
                    case "2":
                        sourceName = "微店线索";
                        break;
                    case "3":
                        sourceName = "问答线索";
                        break;
                    case "4":
                        sourceName = "头条线索";
                        break;
                    case "5":
                        sourceName = "公共线索";
                        break;
                    default:
                        sourceName = StringUtils.EMPTY;
                        break;
                }
                row.add(sourceName);
                dataList.add(row.toArray(new String[row.size()]));
                //记录需要批量处理的线索id
                /*long brokerClueId = Long.valueOf(map.getOrDefault("brokerClueId", 0).toString());
                if (brokerClueIds.contains(brokerClueId)) {
                    brokerClueIds.add(brokerClueId);
                }*/
            }
            //todo 稍后改为批量处理
            /*brokerClueIds.forEach(item -> {
                //处理线索
                this.clueHandel(brokerTagetBrokerId, item, 4);
            });*/
            String title = "线索数据";
            ExcelVo excelVo = new ExcelVo();
            excelVo.setTitle(title);
            excelVo.setRowName(headers);
            excelVo.setDataList(dataList);
            return excelVo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 流失线索导出数据
     *
     * @param list
     * @return
     */
    public ExcelVo clueExcelPassed(List<Map> list, Long brokerTagetBrokerId) {
        List<Object[]> dataList = Lists.newArrayList();
        Object[] objs = null;
        String title = "线索数据";
        List<Long> clueIds = new ArrayList<>();
        String[] headers = new String[]{"客户信息","省份","城市", "商机信息", "销售负责人", "下单时间", "流失时间"};
        for (Map map : list) {
            objs = new Object[headers.length];
            Map province = (Map) map.get("province");
            Map broker = (Map) map.get("broker");
            Map city = (Map) map.get("city");
            Map series = (Map) map.get("series");
            Map car = (Map) map.get("car");
            objs[0] = String.valueOf(map.get("username"));
            objs[1] = (province == null ? "" : String.valueOf(province.get("name")));
            objs[2] = (city == null ? "" : String.valueOf(city.get("name")));
            objs[3] = (series == null ? "" : series.get("name").toString()) + (car == null ? "" : car.get("name").toString());
            objs[4] = broker == null ? "" : broker.get("name");
            objs[5] = DateUtil.timeStamp2Date(map.get("createTime").toString(), null);
            objs[6] = DateUtil.timeStamp2Date(map.get("deleteTime").toString(), null);
            dataList.add(objs);
            clueIds.add(Long.valueOf(map.get("brokerClueId").toString()));
            //处理线索
            this.clueHandel(brokerTagetBrokerId, Long.valueOf(map.get("brokerClueId").toString()), 4);
        }
        ExcelVo excelVo = new ExcelVo();
        excelVo.setTitle(title);
        excelVo.setRowName(headers);
        excelVo.setDataList(dataList);
        return excelVo;
    }

    /**
     * 线索处理
     *
     * @param targetBrokerId
     * @param clueId
     * @param type
     */
    @Async
    public void clueHandel(long targetBrokerId, long clueId, int type) {
        Map<String, String> temp = new HashMap<String, String>();
        temp.put("broker_id", String.valueOf(targetBrokerId));
        temp.put("broker_clue_id", String.valueOf(clueId));
        temp.put("type", String.valueOf(type));
        brokerServerCloud.clueHandle(temp);
        //System.out.println(Thread.currentThread().getId() + "   time:" + new java.util.Date().getTime()  );
    }

}
