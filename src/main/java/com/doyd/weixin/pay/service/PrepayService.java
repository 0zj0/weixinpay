package com.doyd.weixin.pay.service;

import java.util.Map;

import com.doyd.core.base.ApiMessage;
import com.doyd.weixin.pay.entity.PrepayInfo;

public interface PrepayService {

	/**
	 * 通过商户id和订单号获取预支付信息
	 * 
	 * @Title: getPrepayInfo  
	 * @param businessId	商户id
	 * @param outTradeNo	订单号
	 * @return PrepayInfo
	 * @author zj
	 * @date 2018年4月24日下午5:19:52
	 */
	public PrepayInfo getPrepayInfo(int businessId,String outTradeNo);

	/**
	 * 统一下单
	 * 
	 * @Title: unifiedOrder  
	 * @param params		参数集合
	 * @param prepayInfo	预支付对象
	 * @return ApiMessage
	 * @author zj
	 * @date 2018年4月24日下午5:19:55
	 */
	public ApiMessage unifiedOrder(Map<String, Object> params, PrepayInfo prepayInfo);
	
}
