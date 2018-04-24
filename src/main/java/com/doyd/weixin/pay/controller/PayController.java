package com.doyd.weixin.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doyd.core.base.ApiMessage;
import com.doyd.core.constants.ReqCode;
import com.doyd.core.constants.ReqState;
import com.doyd.weixin.pay.entity.BusinessInfo;
import com.doyd.weixin.pay.entity.PrepayInfo;
import com.doyd.weixin.pay.service.BusinessService;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	private BusinessService businessService;
	
	/**
	 * 发起预支付
	 * 
	 * @Title: prePay  
	 * @param request
	 * 	type 来源（h5：1,小程序：2）
	 * 	appid	公众账号ID
	 * 	mch_id	商户号	商户表获取
	 * 	sub_appid	小程序的APPID （小程序支付必要条件）
	 * 	sub_mch_id	子商户号
	 * 	nonce_str	随机字符串		内部获取设值
	 * 	sign	签名				内部获取设值
	 * 	body	商品描述
	 * 	attach	附加数据
	 * 	out_trade_no 商户订单号
	 * 	total_fee	总金额
	 * 	spbill_create_ip	终端IP	内部获取设值
	 * 	notify_url	通知地址
	 * 	trade_type	交易类型	 （h5:MWEB 小程序：JSAPI） 内部设值
	 * 	openid	用户标识
	 * 	sub_openid	用户子标识（trade_type=JSAPI时，openid和sub_openId选传一个，选择传sub_openid,则必须传sub_appid）
	 * 	scene_info	场景信息 （h5必传）
	 * @return ApiMessage
	 * @author zj
	 * @date 2018年4月24日上午9:09:09
	 */
	@RequestMapping("/h5/prepay")
	public ApiMessage prePayH5(HttpServletRequest request){
		//判断此商户是否入驻
		String appid=request.getParameter("appid");
		if(StringUtils.isNullOrEmpty(appid)){
			return new ApiMessage(ReqCode.PrePay, ReqState.ApiParamError);
		}
		BusinessInfo businessInfo = businessService.getBusinessInfoByAppid(appid);
		if(businessInfo==null){
			return new ApiMessage(ReqCode.PrePay, ReqState.NotExitBusiness);
		}
		if(businessInfo.isState()){
			return new ApiMessage(ReqCode.PrePay, ReqState.BusinessHaveNoAuthority);
		}
		//验证数据的正确性
		PrepayInfo prepayInfoH5=new  PrepayInfo();
		prepayInfoH5.setBusinessId(businessInfo.getId());
		prepayInfoH5.setTypeId(1);
		//prepayInfoH5.sets
		
		return new ApiMessage(ReqCode.PrePay, ReqState.Success);
	}
	
}
