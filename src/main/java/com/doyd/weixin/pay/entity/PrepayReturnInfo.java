package com.doyd.weixin.pay.entity;

import java.io.Serializable;

public class PrepayReturnInfo  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;						//主键id
	private int payId;					//预支付id
	private int state;					//0 支付失败 1支付成功 2支付失效
	private String returnCode;			//SUCCESS/FAIL此字段是通信标识，非交易标识
	private String returnMsg;			//返回信息，如非空，为错误原因签名失败参数格式校验错误
	private String resultCode;			//SUCCESS/FAIL
	private String errCode;				//支付错误失败码
	private String errCodeDes;			//错误返回的信息描述
	private String tradeType;			//调用接口提交的交易类型
	private String prepay_id;			//微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	private String returnUrl;			//H5支付-拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟  小程序返回二维码链接
	private String prePackage;			//微信签名
	private String nonceStr;			//随机字符串
	private String timeStamp;			//支付时间戳
	private String createTime;			//添加时间
	private String updateTime;			//修改时间
	private boolean delFlag;			//删除标记 0 未删除 1已删除
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrCodeDes() {
		return errCodeDes;
	}
	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getPrePackage() {
		return prePackage;
	}
	public void setPrePackage(String prePackage) {
		this.prePackage = prePackage;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
