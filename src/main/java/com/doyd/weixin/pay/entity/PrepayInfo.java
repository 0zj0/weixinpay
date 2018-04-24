package com.doyd.weixin.pay.entity;

import java.io.Serializable;

public class PrepayInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;						//主键id
	private int businessId;				//对应商户id
	private String subAppid;			//子商户公众账号ID
	private String subMchId;			//子商户号
	private int typeId;					//支付类型 1.H5支付 2.小程序支付
	private String openid;				//用户微信openid
	private String outTradeNo;			//用户订单id
	private int totalFee;				//支付金额 单位分 不允许出现小数
	//private String productId;			//商品id
	private int state;					//支付状态 0 未支付 1 已支付 2 支付失败 3 支付过期
	private String payBody;				//商品简单描述
	private String notifyUrl;			//支付回调地址
	private String spbillCreateIp;		//APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
	private String attach;				//附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
	private String payContent;			//支付描述或H5支付场景信息
	private String createTime;			//添加时间
	private String updateTime;			//修改时间
	private boolean delFlag;			//删除标记 0 未删除 1已删除
	private String remark;				//描述
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public String getSubAppid() {
		return subAppid;
	}
	public void setSubAppid(String subAppid) {
		this.subAppid = subAppid;
	}
	public String getSubMchId() {
		return subMchId;
	}
	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public int getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	/*public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}*/
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getPayBody() {
		return payBody;
	}
	public void setPayBody(String payBody) {
		this.payBody = payBody;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getPayContent() {
		return payContent;
	}
	public void setPayContent(String payContent) {
		this.payContent = payContent;
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
