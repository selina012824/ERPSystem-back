package com.example.ERPSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//注文

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "order_id")
	private String orderID; // 注文番号

	@Column(name = "est_scrap_id")
	private String estScrapID; // 予測廃材番号

	@Column(name = "customer_id")
	private String customerID; // 取引先番号

	@Column(name = "order_date")
	private LocalDate orderDate; // 注文日

	@Column(name = "delivery_date")
	private LocalDate deliveryDate; // 納期

	@Column(name = "status")
	private String status; // 状況

	@Column(name = "subtotal")
	private BigDecimal subtotal; // 合計

	@Column(name = "tax")
	private BigDecimal tax; // 稅額

	@Column(name = "total_amount")
	private BigDecimal totalAmount; // 総金額

	@Column(name = "payment")
	private String payment; // 支払条件

	@Column(name = "create_at")
	private LocalDateTime createAt; // 作成日時

	@Column(name = "create_by")
	private String createBy; // 作成者

	@Column(name = "update_at")
	private LocalDateTime updateAt; // 更新日時

	@Column(name = "update_by")
	private String updateBy; // 更新者

	public Order() {
		super();
	}

	public Order(String orderID, String estScrapID, String customerID, LocalDate orderDate, LocalDate deliveryDate,
			String status, BigDecimal subtotal, BigDecimal tax, BigDecimal totalAmount, String payment,
			LocalDateTime createAt, String createBy, LocalDateTime updateAt, String updateBy) {
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

}
