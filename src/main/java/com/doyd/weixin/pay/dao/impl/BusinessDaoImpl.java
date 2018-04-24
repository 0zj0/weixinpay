package com.doyd.weixin.pay.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doyd.core.dao.DaoSupport;
import com.doyd.weixin.pay.dao.BusinessDao;
import com.doyd.weixin.pay.dao.rowmapper.BusinessRowMapper;
import com.doyd.weixin.pay.entity.BusinessInfo;

@Repository
public class BusinessDaoImpl implements BusinessDao {

	@Autowired
    private DaoSupport daoSupport;
	@Autowired
	private BusinessRowMapper businessRowMapper;
	
	@Override
	public BusinessInfo getBusinessInfoByAppid(String appid) {
		String sql="select * from business_info where appid=? and del_flag=0";
		return daoSupport.queryForObject(sql, new Object[]{appid},businessRowMapper);
	}

}
