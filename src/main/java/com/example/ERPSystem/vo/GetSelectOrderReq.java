package com.example.ERPSystem.vo;

import java.util.List;

public class GetSelectOrderReq {
	
	private String orderID;
	
	private List<String> orderInfoIDList;
	
	

	public GetSelectOrderReq() {
		super();
	}
	

	public GetSelectOrderReq(String orderID, List<String> orderInfoIDList) {
		super();
		this.orderID = orderID;
		this.orderInfoIDList = orderInfoIDList;
	}



	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public List<String> getOrderInfoIDList() {
		return orderInfoIDList;
	}

	public void setOrderInfoIDList(List<String> orderInfoIDList) {
		this.orderInfoIDList = orderInfoIDList;
	}
	

}
