package com.doyd.weixin.pay.service;

import com.doyd.weixin.pay.entity.BusinessInfo;

public interface BusinessService {

	public BusinessInfo getBusinessInfoByAppid(String appid);
	
}
