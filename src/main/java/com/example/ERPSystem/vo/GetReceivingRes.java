package com.example.ERPSystem.vo;

//指定入荷伝票データRES
public class GetReceivingRes extends BasicRes {

	private ReceivingVO receiving;

	public GetReceivingRes() {
		super();
	}

	public GetReceivingRes(int code, String message) {
		super(code, message);
	}

	public GetReceivingRes(int code, String message, ReceivingVO receiving) {
		super(code, message);
		this.receiving = receiving;
	}

	public GetReceivingRes(ReceivingVO receiving) {
		super();
		this.receiving = receiving;
	}

	public ReceivingVO getReceiving() {
		return receiving;
	}

}
