package com.example.ERPSystem.vo;

//指定注文データRES
public class GetOrderRes extends BasicRes {

	private OrderVO order;

	public GetOrderRes() {
		super();
	}

	public GetOrderRes(int code, String message) {
		super(code, message);
	}

	public GetOrderRes(int code, String message, OrderVO order) {
		super(code, message);
		this.order = order;
	}

	public GetOrderRes(OrderVO order) {
		super();
		this.order = order;
	}

	public OrderVO getOrder() {
		return order;
	}
	

}
