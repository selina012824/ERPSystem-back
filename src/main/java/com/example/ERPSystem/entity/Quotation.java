package com.example.ERPSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//見積書

@Entity
@Table(name = "quotation")
public class Quotation {

	@Id
	@Column(name = "quotation_id")
	private String quotationID; // 見積番号

	@Column(name = "quotation_date")
	private LocalDate quotationDate; // 見積日

	@Column(name = "quotation_type")
	private String quotationType; // 見積元

	@Column(name = "customer_id")
	private String customerID; // 取引先番号
	
	@Column(name = "customer_name")
	private String customerName; // 取引先名

	@Column(name = "customer_nickname")
	private String customerNickName; // 略称

	@Column(name = "person_in_response")
	private String personInResponse; // 責任者

	@Column(name = "contactor")
	private String contactor; // 担当者

	@Column(name = "customer_phone")
	private String customerPhone; // 電話番号

	@Column(name = "customer_cellphone")
	private String customerCellphone; // 携帯番号

	@Column(name = "customer_faxnumber")
	private String customerFaxNumber; // FAX番号

	@Column(name = "customer_taxnumber")
	private String customerTaxNumber; // 法人番号

	@Column(name = "customer_address")
	private String customerAddress; // 所在地

	@Column(name = "ship_address")
	private String shipAddress; // 納品先住所

	@Column(name = "invoice_address")
	private String invoiceAddress; // 請求先住所

	@Column(name = "payment")
	private String payment; // 支払方法

	@Column(name = "subtotal")
	private BigDecimal subtotal; // 合計

	@Column(name = "tax")
	private BigDecimal tax; // 稅額

	@Column(name = "total")
	private BigDecimal total; // 総額

	@Column(name = "total_amount")
	private BigDecimal totalAmount; // 総金額

	@Column(name = "validity_period")
	private LocalDate validityPeriod; // 有効期限

	@Column(name = "remark")
	private String remark; // 備考

	@Column(name = "if_set_order")
	private String ifSetOrder; // 注文が作成済みかどうか

	@Column(name = "set_order_time")
	private LocalDateTime setOrderTime; // 注文作成日時

	@Column(name = "create_at")
	private LocalDateTime createAt; // 作成日

	@Column(name = "create_clerk_nm")
	private String createClerkNm; // 作成者

	@Column(name = "update_at")
	private LocalDateTime updateAt; // 更新日

	@Column(name = "update_by")
	private String updateBy; // 更新者

	public Quotation() {
		super();
	}

	public Quotation(String quotationID, LocalDate quotationDate, String quotationType, String customerID,
			String customerName, String customerNickName, String personInResponse, String contactor,
			String customerPhone, String customerCellphone, String customerFaxNumber, String customerTaxNumber,
			String customerAddress, String shipAddress, String invoiceAddress, String payment, BigDecimal subtotal,
			BigDecimal tax, BigDecimal total, BigDecimal totalAmount, LocalDate validityPeriod, String remark,
			String ifSetOrder, LocalDateTime setOrderTime, LocalDateTime createAt, String createClerkNm,
			LocalDateTime updateAt, String updateBy) {
		super();
		this.quotationID = quotationID;
		this.quotationDate = quotationDate;
		this.quotationType = quotationType;
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerNickName = customerNickName;
		this.personInResponse = personInResponse;
		this.contactor = contactor;
		this.customerPhone = customerPhone;
		this.customerCellphone = customerCellphone;
		this.customerFaxNumber = customerFaxNumber;
		this.customerTaxNumber = customerTaxNumber;
		this.customerAddress = customerAddress;
		this.shipAddress = shipAddress;
		this.invoiceAddress = invoiceAddress;
		this.payment = payment;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
		this.totalAmount = totalAmount;
		this.validityPeriod = validityPeriod;
		this.remark = remark;
		this.ifSetOrder = ifSetOrder;
		this.setOrderTime = setOrderTime;
		this.createAt = createAt;
		this.createClerkNm = createClerkNm;
		this.updateAt = updateAt;
		this.updateBy = updateBy;
	}

	public String getQuotationID() {
		return quotationID;
	}

	public LocalDate getQuotationDate() {
		return quotationDate;
	}

	public String getQuotationType() {
		return quotationType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerNickName() {
		return customerNickName;
	}

	public String getPersonInResponse() {
		return personInResponse;
	}

	public String getContactor() {
		return contactor;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public String getCustomerCellphone() {
		return customerCellphone;
	}

	public String getCustomerFaxNumber() {
		return customerFaxNumber;
	}

	public String getCustomerTaxNumber() {
		return customerTaxNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public String getPayment() {
		return payment;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public LocalDate getValidityPeriod() {
		return validityPeriod;
	}

	public String getRemark() {
		return remark;
	}

	public String getIfSetOrder() {
		return ifSetOrder;
	}

	public LocalDateTime getSetOrderTime() {
		return setOrderTime;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public String getCreateClerkNm() {
		return createClerkNm;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

	public void setQuotationDate(LocalDate quotationDate) {
		this.quotationDate = quotationDate;
	}

	public void setQuotationType(String quotationType) {
		this.quotationType = quotationType;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerNickName(String customerNickName) {
		this.customerNickName = customerNickName;
	}

	public void setPersonInResponse(String personInResponse) {
		this.personInResponse = personInResponse;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public void setCustomerCellphone(String customerCellphone) {
		this.customerCellphone = customerCellphone;
	}

	public void setCustomerFaxNumber(String customerFaxNumber) {
		this.customerFaxNumber = customerFaxNumber;
	}

	public void setCustomerTaxNumber(String customerTaxNumber) {
		this.customerTaxNumber = customerTaxNumber;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setValidityPeriod(LocalDate validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIfSetOrder(String ifSetOrder) {
		this.ifSetOrder = ifSetOrder;
	}

	public void setSetOrderTime(LocalDateTime setOrderTime) {
		this.setOrderTime = setOrderTime;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public void setCreateClerkNm(String createClerkNm) {
		this.createClerkNm = createClerkNm;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	

}
