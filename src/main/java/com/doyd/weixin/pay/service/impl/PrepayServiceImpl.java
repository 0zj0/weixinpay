package com.doyd.weixin.pay.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doyd.core.base.ApiMessage;
import com.doyd.core.weixin.utils.CommonUtils;
import com.doyd.core.weixin.utils.HttpHelper;
import com.doyd.weixin.pay.dao.PrepayDao;
import com.doyd.weixin.pay.entity.PrepayInfo;
import com.doyd.weixin.pay.service.PrepayService;

@Service
public class PrepayServiceImpl implements PrepayService {
	
	//统一下单地址
	private static String UNIFIED_ORDER_URL="https://api.mch.weixin.qq.com/pay/unifiedorder";

	@Autowired
	private PrepayDao prepayDao;
	
	@Override
	public PrepayInfo getPrepayInfo(int businessId, String outTradeNo) {
		return prepayDao.getPrepayInfo(businessId,outTradeNo);
	}

	
	@Override
	public ApiMessage unifiedOrder(Map<String, Object> params, PrepayInfo prepayInfo) {
		//1.判断预支付订单是否存在
		PrepayInfo prepay=prepayDao.getPrepayInfo(prepayInfo.getBusinessId(),prepayInfo.getOutTradeNo());
		if(prepay==null){
			String xmlStr=CommonUtils.mapToXmlStr(params);
			String result=HttpHelper.post(UNIFIED_ORDER_URL, xmlStr);
			Map<String, Object> map=CommonUtils.xmlStrToMap(result);
		}
		return null;
	}

}
