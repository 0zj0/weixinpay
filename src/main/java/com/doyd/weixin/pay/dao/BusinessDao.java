package com.doyd.weixin.pay.dao;

import com.doyd.weixin.pay.entity.BusinessInfo;

public interface BusinessDao {
	
	public BusinessInfo getBusinessInfoByAppid(String appid);
	
}
