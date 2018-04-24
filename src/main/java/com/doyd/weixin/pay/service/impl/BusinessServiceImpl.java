package com.doyd.weixin.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doyd.weixin.pay.dao.BusinessDao;
import com.doyd.weixin.pay.entity.BusinessInfo;
import com.doyd.weixin.pay.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessDao businessService;
	
	@Override
	public BusinessInfo getBusinessInfoByAppid(String appid) {
		return businessService.getBusinessInfoByAppid(appid);
	}

}
