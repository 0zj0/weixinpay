package com.doyd.weixin.pay.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doyd.core.base.ApiMessage;
import com.doyd.core.constants.ReqCode;
import com.doyd.core.constants.ReqState;
import com.doyd.core.utils.StringUtil;
import com.doyd.core.weixin.utils.CheckParamsUtil;
import com.doyd.core.weixin.utils.HttpHelper;
import com.doyd.core.weixin.utils.SignUtil;
import com.doyd.weixin.pay.entity.BusinessInfo;
import com.doyd.weixin.pay.entity.PrepayInfo;
import com.doyd.weixin.pay.service.BusinessService;
import com.doyd.weixin.pay.service.PrepayService;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping("/pay")
public class PayController {
	
	@Value("${notify_url}")
	private String notifyUrl;
	
	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private PrepayService prepayService;
	
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
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) request.getAttribute("params");
		//1.判断此商户是否入驻
		String appid=params.get("appid").toString();
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
		//2.验证数据的正确性
		if(!CheckParamsUtil.checkPrepayParams(params,1)){
			return new ApiMessage(ReqCode.PrePay, ReqState.ApiParamError);
		}
		
		//3.设值传递参数
		params.put("mch_id", businessInfo.getMchId());
		//获取随机字符串
		String nonce_str=StringUtil.getRandomString(32);
		params.put("nonce_str", nonce_str);
		
		//设值签名信息
		String sign=SignUtil.createSign(params, businessInfo.getKey());
		params.put("sign", sign);
		
		//设值交易类型
		params.put("trade_type", "MWEB");
		
		
		PrepayInfo prepayInfo=new PrepayInfo();
		prepayInfo.setBusinessId(businessInfo.getId());
		prepayInfo.setTypeId(1);
		prepayInfo.setSubMchId(params.get("sub_mch_id").toString());
		prepayInfo.setOutTradeNo(params.get("out_trade_no").toString());
		prepayInfo.setTotalFee(StringUtil.parseInt(params.get("total_fee").toString()));
		prepayInfo.setPayBody(params.get("body").toString());
		
		prepayInfo.setNotifyUrl(params.get("notify_url").toString());
		params.put("notify_url", notifyUrl);
		
		String ip=HttpHelper.getIpAddr(request);
		prepayInfo.setSpbillCreateIp(ip);
		params.put("spbill_create_ip", ip);
		
		prepayInfo.setAttach(params.get("attach").toString());
		prepayInfo.setPayContent(params.get("scene_info").toString());
		
		return prepayService.unifiedOrder(params,prepayInfo);
	}
	
}
