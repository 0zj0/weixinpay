package com.doyd.core.constants;

public enum ReqCode {
	Unknown(0,"未知操作"),
	
	PrePay(10,"统一下单"),
	
	QueryOrder(20,"查询订单"),
	;

	
	private int code;
	private String remark;
	
	private ReqCode(int code, String remark){
		this.code = code;
		this.remark = remark;
	}
	
	private ReqCode(int code, String remark, boolean needLogin){
		this.code = code;
		this.remark = remark;
	}

	public int getCode() {
		return code;
	}
	public String getRemark() {
		return remark;
	}

	public static ReqCode get(int code){
		for(ReqCode reqCode: ReqCode.values()){
			if(reqCode.getCode()==code){
				return reqCode;
			}
		}
		return Unknown;
	}
	
	@Override
	public String toString() {
		return this.code+"";
	}
}
