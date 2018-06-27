package com.xyauto.interact.broker.zuul.util.duiba;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreditNotifyParams {

	@Id
	private String id;
	private boolean success;
	private String bizId="";
	private String errorMessage="";
	private String orderNum="";
	private Date timestamp=new Date();
	private String appKey;
	private String uid="";


	@Override
	public String toString() {
		return "CreditNotifyParams{" +
				"id='" + id + '\'' +
				", success=" + success +
				", bizId='" + bizId + '\'' +
				", errorMessage='" + errorMessage + '\'' +
				", orderNum='" + orderNum + '\'' +
				", timestamp=" + timestamp +
				", appKey='" + appKey + '\'' +
				", uid='" + uid + '\'' +
				'}';
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	
	public Map<String, String> toRequestMap(String appSecret){
		Map<String, String> map=new HashMap<String, String>();
		map.put("success", success+"");
		map.put("errorMessage", getString(errorMessage));
		map.put("bizId", getString(bizId));
		map.put("appKey", getString(appKey));
		map.put("appSecret", getString(appSecret));
		map.put("timestamp",getString( timestamp.getTime()));
		map.put("uid", getString(uid));
		map.put("orderNum", getString(orderNum));
		
		String sign=SignTool.sign(map);
		
		map.remove("appSecret");
		map.put("sign", sign);
		return map;
	}
	
	private String getString(Object o){
		if(o==null){
			return "";
		}
		return o.toString();
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	public String getUid() {
		return uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
