package com.doyd.core.constants;

public enum ReqState {
	
	Unknown(-1, "未知请求"),
	Success(0, "成功"),
	Failure(1, "失败"),
	ApiParamError(2, "参数不完整或参数错误"),
	NotExitBusiness(3,"不存在此商户"),
	BusinessHaveNoAuthority(4,"商户没有支付的权限"),
	
	;

    private int code;
	private String remark;
	
	private ReqState(int code, String remark){
		this.code = code;
		this.remark = remark;
	}

	public int getCode() {
		return code;
	}
	public String getRemark() {
		return remark;
	}
	public static ReqState get(int code){
		for(ReqState reqState: ReqState.values()){
			if(reqState.getCode()==code){
				return reqState;
			}
		}
		return Unknown;
	}
	@Override
	public String toString() {
		return this.code+"";
	}
}
