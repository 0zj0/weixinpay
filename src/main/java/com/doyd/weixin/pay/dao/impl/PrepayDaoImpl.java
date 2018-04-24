package com.doyd.weixin.pay.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doyd.core.dao.DaoSupport;
import com.doyd.weixin.pay.dao.PrepayDao;
import com.doyd.weixin.pay.dao.rowmapper.PrepayInfoRowMapper;
import com.doyd.weixin.pay.entity.PrepayInfo;

@Repository
public class PrepayDaoImpl implements PrepayDao{
	
	@Autowired
    private DaoSupport daoSupport;
	@Autowired
	private PrepayInfoRowMapper prepayInfoRowMapper;
	
	@Override
	public PrepayInfo getPrepayInfo(int businessId, String outTradeNo) {
		String sql="select * from prepay_info where out_trade_no=? and business_id=? and del_flag=0";
		return daoSupport.queryForObject(sql, new Object[]{outTradeNo,businessId}, prepayInfoRowMapper);
	}
}