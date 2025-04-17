package com.example.ERPSystem.vo;

//指定購買注文データRES
public class GetPORes extends BasicRes {

	private PurchaseOrderVO purchaseOrder;

	public GetPORes() {
		super();
	}

	public GetPORes(int code, String message) {
		super(code, message);
	}

	public GetPORes(int code, String message, PurchaseOrderVO purchaseOrder) {
		super(code, message);
		this.purchaseOrder = purchaseOrder;
	}

	public GetPORes(PurchaseOrderVO purchaseOrder) {
		super();
		this.purchaseOrder = purchaseOrder;
	}

	public PurchaseOrderVO getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrderVO purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

}
