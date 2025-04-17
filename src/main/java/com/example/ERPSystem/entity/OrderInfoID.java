package com.example.ERPSystem.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderInfoID implements Serializable {

	private String orderDetailID;

	private String orderID;
	

	public String getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}



	
}
