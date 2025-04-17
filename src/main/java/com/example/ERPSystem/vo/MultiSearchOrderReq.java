package com.example.ERPSystem.vo;

import java.time.LocalDate;

// 注文検索条件REQ
public class MultiSearchOrderReq {

	private String orderID; // 注文番号

	private String estScrapID; // 予測廃材番号

	private String customerID; // 取引先番号

	private String status; // 状態

	private LocalDate orderStartDate; // 注文開始日

	private LocalDate orderEndDate; // 注文終了日

	private LocalDate deliveryStartDate; // 納期開始日

	private LocalDate deliveryEndDate; // 納期終了日

	public MultiSearchOrderReq() {
		super();
	}

	public MultiSearchOrderReq(String orderID, String estScrapID, String customerID, String status,
			LocalDate orderStartDate, LocalDate orderEndDate, LocalDate deliveryStartDate, LocalDate deliveryEndDate) {
		super();
		this.orderID = orderID;
		this.estScrapID = estScrapID;
		this.customerID = customerID;
		this.status = status;
		this.orderStartDate = orderStartDate;
		this.orderEndDate = orderEndDate;
		this.deliveryStartDate = deliveryStartDate;
		this.deliveryEndDate = deliveryEndDate;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getEstScrapID() {
		return estScrapID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getStatus() {
		return status;
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
