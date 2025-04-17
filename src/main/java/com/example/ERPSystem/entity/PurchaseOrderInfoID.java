package com.example.ERPSystem.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PurchaseOrderInfoID implements Serializable {

	private String poDetailID;

	private String purchaseOrderID;

	public String getPoDetailID() {
		return poDetailID;
	}

	public void setPoDetailID(String poDetailID) {
		this.poDetailID = poDetailID;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

}
