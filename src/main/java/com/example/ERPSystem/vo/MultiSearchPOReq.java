package com.example.ERPSystem.vo;

import java.time.LocalDate;

//　購買注文検索条件REQ
public class MultiSearchPOReq {

	private String purchaseOrderID; // 購買注文番号

	private String orderID; // 注文番号

	private String supplierID; // 仕入先

	private String status; // 状況

	private String isApproved; // 承認状況

	private LocalDate orderStartDate; // 発注日（開始）

	private LocalDate orderEndDate; // 発注日（終了）

	private LocalDate deliveryStartDate; // 納品予定日（開始）

	private LocalDate deliveryEndDate; // 納品予定日（終了）

	public MultiSearchPOReq() {
		super();
	}

	public MultiSearchPOReq(String purchaseOrderID, String orderID, String supplierID, String status, String isApproved,
			LocalDate orderStartDate, LocalDate orderEndDate, LocalDate deliveryStartDate, LocalDate deliveryEndDate) {
		super();
		this.purchaseOrderID = purchaseOrderID;
		this.orderID = orderID;
		this.supplierID = supplierID;
		this.status = status;
		this.isApproved = isApproved;
		this.orderStartDate = orderStartDate;
		this.orderEndDate = orderEndDate;
		this.deliveryStartDate = deliveryStartDate;
		this.deliveryEndDate = deliveryEndDate;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public String getStatus() {
		return status;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public LocalDate getOrderStartDate() {
		return orderStartDate;
	}

	public LocalDate getOrderEndDate() {
		return orderEndDate;
	}

	public LocalDate getDeliveryStartDate() {
		return deliveryStartDate;
	}

	public LocalDate getDeliveryEndDate() {
		return deliveryEndDate;
	}

}
