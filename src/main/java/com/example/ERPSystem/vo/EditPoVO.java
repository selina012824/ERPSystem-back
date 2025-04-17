package com.example.ERPSystem.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditPoVO {

	private String orderID; // 注文番号

	private String supplierID; // 仕入先

	private LocalDate orderDate; // 発注日

	private LocalDate deliveryDate; // 納品予定日

	private String status; // 状況

	private String isApproved; // 承認状況

	private String approvedBy; // 承認者

	private LocalDateTime approvedAt; // 承認日時

	private BigDecimal subtotal; // 合計

	private BigDecimal tax; // 税額

	private BigDecimal totalAmount; // 總金額

	private LocalDateTime updateAt; // 更新日時

	private String updateBy; // 更新者

	private String purchaseOrderID; // 購買注文番号

	public EditPoVO() {
		super();
	}

	public EditPoVO(String orderID, String supplierID, LocalDate orderDate, LocalDate deliveryDate, String status,
			String isApproved, String approvedBy, LocalDateTime approvedAt, BigDecimal subtotal, BigDecimal tax,
			BigDecimal totalAmount, LocalDateTime updateAt, String updateBy, String purchaseOrderID) {
		super();
		this.orderID = orderID;
		this.supplierID = supplierID;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.isApproved = isApproved;
		this.approvedBy = approvedBy;
		this.approvedAt = approvedAt;
		this.subtotal = subtotal;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.updateAt = updateAt;
		this.updateBy = updateBy;
		this.purchaseOrderID = purchaseOrderID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
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

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
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

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

}
