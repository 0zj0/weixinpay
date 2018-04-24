package com.doyd.core.weixin.utils;

import java.util.Map;

import com.mysql.jdbc.StringUtils;

public class CheckParamsUtil {

	
	/**url地址*/
	public static final String RULES_URL = "(http(s?)|ftp)://([\\w\\-]+\\.)+[\\w]+(:\\d+)?" // 解析域名
										+ "(/([\\w\\-\\._,#%=\\*\\{\\}\\[\\]])*)*" // 解析uri
										+ "[\\?&#]?([\\w\\.\\+\\-!=#,_%&\\*\\{\\}\\[\\]]*)*";// 解析参数
	
	/**
	 * 验证统一下单数据的正确性
	 * 
	 * @Title: checkParams  
	 * @param params
	 * @param type 1:H5 2:小程序
	 * @return boolean
	 * @author zj
	 * @date 2018年4月24日上午11:45:03
	 */
	public static boolean checkPrepayParams(Map<String, Object> params,int type){
		if(StringUtils.isNullOrEmpty(params.get("sub_mch_id").toString())){		//子商户号
			return false;
		}
		if(StringUtils.isNullOrEmpty(params.get("body").toString())){			//商品描述
			return false;
		}
		if(StringUtils.isNullOrEmpty(params.get("attach").toString())){			//附加数据
			return false;
		}
		if(StringUtils.isNullOrEmpty(params.get("out_trade_no").toString())){	//商户订单号
			return false;
		}
		String total_fee=params.get("total_fee").toString();
		if(StringUtils.isNullOrEmpty(total_fee) || Integer.parseInt(total_fee)<=0){		//总金额
			return false;
		}
		String notify_url=params.get("notify_url").toString();
		if(StringUtils.isNullOrEmpty(notify_url) || notify_url.matches(RULES_URL)){		//通知地址
			return false;
		}
		if(1==type){			//H5支付
			if(StringUtils.isNullOrEmpty(params.get("scene_info").toString())){		//场景信息
				return false;
			}
		}else if(2==type){		//小程序支付
			if(StringUtils.isNullOrEmpty(params.get("sub_appid").toString())){			//小程序的APPID
				return false;
			}
			if(StringUtils.isNullOrEmpty(params.get("openid").toString()) && StringUtils.isNullOrEmpty(params.get("sub_openid").toString())){			//小程序的APPID
				return false;
			}
		}
		return true;
	}
	
	
}
