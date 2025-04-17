package com.example.ERPSystem.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ERPSystem.entity.OrderInfo;

public class OrderVO {
	
	private String orderID; // 注文番号

	private String estScrapID; // 予測廃材番号

	private String customerID; // 取引先番号

	private LocalDate orderDate; // 注文日

	private LocalDate deliveryDate; // 納期

	private String status; // 状態

	private BigDecimal subtotal; // 合計

	private BigDecimal tax; // 税額

	private BigDecimal totalAmount; // 総金額

	private String payment; // 支払条件

	private LocalDateTime createAt; // 作成日時

	private String createBy; // 作成者

	private LocalDateTime updateAt; // 更新日時

	private String updateBy; // 更新者
	
	private List<OrderInfo> orderInfoList; // 注文明細リスト

	public OrderVO() {
		super();
	}

	public OrderVO(String orderID, String estScrapID, String customerID, LocalDate orderDate, LocalDate deliveryDate,
			String status, BigDecimal subtotal, BigDecimal tax, BigDecimal totalAmount, String payment,
			LocalDateTime createAt, String createBy, LocalDateTime updateAt, String updateBy,
			List<OrderInfo> orderInfoList) {
		super();
		this.orderID = orderID;
		this.estScrapID = estScrapID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.subtotal = subtotal;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.payment = payment;
		this.createAt = createAt;
		this.createBy = createBy;
		this.updateAt = updateAt;
		this.updateBy = updateBy;
		this.orderInfoList = orderInfoList;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getEstScrapID() {
		return estScrapID;
	}

	public void setEstScrapID(String estScrapID) {
		this.estScrapID = estScrapID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public List<OrderInfo> getOrderInfoList() {
		return orderInfoList;
	}

	public void setOrderInfoList(List<OrderInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
	
	
	

}
