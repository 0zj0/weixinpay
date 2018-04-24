package com.doyd.weixin.pay.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.doyd.weixin.pay.entity.PrepayInfo;

@Component
public class PrepayInfoRowMapper implements RowMapper<PrepayInfo> {

	@Override
	public PrepayInfo mapRow(ResultSet rs, int i) throws SQLException {
		PrepayInfo model = new PrepayInfo();
		model.setId(rs.getInt("id"));
		model.setBusinessId(rs.getInt("business_id"));
		model.setSubAppid(rs.getString("sub_appid"));
		model.setSubMchId(rs.getString("sub_mch_id"));
		model.setTypeId(rs.getInt("type_id"));
		model.setOpenid(rs.getString("openid"));
		model.setOutTradeNo(rs.getString("out_trade_no"));
		model.setTotalFee(rs.getInt("total_fee"));
		model.setState(rs.getInt("state"));
		model.setPayBody(rs.getString("pay_body"));
		model.setNotifyUrl(rs.getString("notify_url"));
		model.setSpbillCreateIp(rs.getString("spbill_create_ip"));
		model.setAttach(rs.getString("attach"));
		model.setPayContent(rs.getString("pay_content"));
		model.setCreateTime(rs.getString("create_time"));
		model.setUpdateTime(rs.getString("update_time"));
		model.setDelFlag(rs.getBoolean("del_flag"));
		model.setRemark(rs.getString("remark"));
		return model;
	}

}
