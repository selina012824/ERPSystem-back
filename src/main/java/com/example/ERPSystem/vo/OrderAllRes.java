package com.example.ERPSystem.vo;

import java.util.List;
import com.example.ERPSystem.entity.Order;

public class OrderAllRes extends BasicRes {

	private List<Order> orderList;

	public OrderAllRes() {
		super();
	}

	public OrderAllRes(int code, String message) {
		super(code, message);
	}

	public OrderAllRes(int code, String message, List<Order> orderList) {
		super(code, message);
		this.orderList = orderList;
	}

	public OrderAllRes(List<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
