package com.xyauto.interact.broker.zuul.util.duiba;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.*;

public class SignTool {

	public static boolean signVerify(String appSecret,HttpServletRequest request){
		Map<String, String[]> map=request.getParameterMap();
		Map<String, String> data=new HashMap<String, String>();
		for(String key:map.keySet()){
			if (!"app_id".equals(key)) {
				data.put(key, map.get(key)[0]);
			}
		}
//		System.out.println("data:" + JSON.toJSONString(data));
		return signVerify(appSecret, data);
	}
	
	public static boolean signVerify(String appSecret,Map<String, String> params){
		Map<String, String> map=new HashMap<String, String>();
		map.put("appSecret", appSecret);
		
		for(String key:params.keySet()){
			if(!key.equals("sign")){
				map.put(key, params.get(key));
			}
		}
//		System.out.println("map:" + JSON.toJSONString(map));
		String sign=sign(map);
//		System.out.println("生成的sign:" + sign);
//		System.out.println("传递的sign:" + (String)params.get("sign"));
		if(sign.equals(params.get("sign"))){
			return true;
		}
		return false;
	}
	
	private static String toHexValue(byte[] messageDigest) {
		if (messageDigest == null) {
			return "";
		}
		StringBuilder hexValue = new StringBuilder();
		for (byte aMessageDigest : messageDigest) {
			int val = 0xFF & aMessageDigest;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	/**
	 * 
	 * @param params
	 * @return
	 */
	public static String sign(Map<String,String> params){
		List<String> keys=new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String string="";
		for(String s:keys){
			string+=params.get(s);
		}
		String sign="";
		try {
//			System.out.println("111111111111");
			sign = toHexValue(encryptMD5(string.getBytes(Charset.forName("utf-8"))));
//			System.out.println("2222222222222");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("md5 error");
		}
		return sign;
	}
	
	private static byte[] encryptMD5(byte[] data)throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(data);
		return md5.digest();
	}
//
//	public static void main1(String[] args) {
//		String appKey="24vsb8w25SJLmB6YKuRDXqHpJuRU";
//		String appSecret="zKp2z8xX2R6zV85Mr352wVSNEge";
//
//		Map<String, String> params=new HashMap<String, String>();
//		params.put("actualPrice", "500");
//		params.put("ip", "testIp");
//		params.put("orderNum", "order-for-test-1513236348081");
//		params.put("description", "支付宝账号：admin@duiba.com(兑吧) 转账充值：5元");
//		params.put("waitAudit", "true");
//		params.put("type", "alipay");
//		params.put("params", "admin@duiba.com:兑吧");
//		params.put("uid", "1");
//		params.put("credits", "500");
//		params.put("facePrice", "500");
//		params.put("paramsTest71", "71");
//		params.put("appKey", appKey);
//		params.put("appSecret", appSecret);
//		params.put("app_id", "5d81db99484c0019cab240b3d04e9a4a");
//		params.put("timestamp", "1513236348081");
//		params.remove("app_id");
//		System.out.println(JSON.toJSONString(params));
////		String sign=sign(params);
////
////		params.put("sign", sign);
////
////		System.out.println(signVerify(appSecret, params));
////
//	}
}
