package com.doyd.weixin.pay.dao;

import com.doyd.weixin.pay.entity.PrepayInfo;

public interface PrepayDao {

	PrepayInfo getPrepayInfo(int businessId, String outTradeNo);
	
}
