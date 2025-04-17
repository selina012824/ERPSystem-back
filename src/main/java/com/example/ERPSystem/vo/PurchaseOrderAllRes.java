package com.example.ERPSystem.vo;

import java.util.List;

import com.example.ERPSystem.entity.PurchaseOrders;

public class PurchaseOrderAllRes extends BasicRes {

	private List<PurchaseOrders> purchaseOrderList;

	public PurchaseOrderAllRes() {
		super();
	}

	public PurchaseOrderAllRes(int code, String message) {
		super(code, message);
	}
	
	public PurchaseOrderAllRes(int code, String message, List<PurchaseOrders> purchaseOrderList) {
		super(code, message);
		this.purchaseOrderList = purchaseOrderList;
	}

	public PurchaseOrderAllRes(List<PurchaseOrders> purchaseOrderList) {
		super();
		this.purchaseOrderList = purchaseOrderList;
	}

	public List<PurchaseOrders> getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(List<PurchaseOrders> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}
	
	

}
