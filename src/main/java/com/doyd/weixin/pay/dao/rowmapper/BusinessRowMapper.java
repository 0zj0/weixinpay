package com.doyd.weixin.pay.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.doyd.weixin.pay.entity.BusinessInfo;

@Component
public class BusinessRowMapper implements RowMapper<BusinessInfo> {

	@Override
	public BusinessInfo mapRow(ResultSet rs, int i) throws SQLException {
		BusinessInfo model = new BusinessInfo();
		model.setId(rs.getInt("id"));
		model.setBusinessName(rs.getString("business_name"));
		model.setBusinessCode(rs.getString("business_code"));
		model.setAppid(rs.getString("appid"));
		model.setMchId(rs.getString("mch_id"));
		model.setKey(rs.getString("key"));
		model.setAppSecret(rs.getString("app_sercret"));
		model.setState(rs.getBoolean("state"));
		model.setResourceType(rs.getInt("resource_type"));
		model.setCreateTime(rs.getString("create_time"));
		model.setUpdateTime(rs.getString("update_time"));
		model.setDelFlag(rs.getBoolean("del_flag"));
		model.setRemark(rs.getString("remark"));
		return model;
	}

}
