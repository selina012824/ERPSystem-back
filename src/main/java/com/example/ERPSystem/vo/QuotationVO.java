package com.example.ERPSystem.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ERPSystem.entity.QuotationInfo;

public class QuotationVO {

	private String quotationID; // 見積番号

	private LocalDate quotationDate; // 見積日

	private String quotationType; // 見積元

	private String customerID; // 取引先番号

	private String customerName; // 取引先名

	private String customerNickName; // 略称

	private String personInResponse; // 責任者

	private String contactor; // 担当者

	private String customerPhone; // 電話番号

	private String customerCellphone; // 携帯番号

	private String customerFaxNumber; // FAX番号

	private String customerTaxNumber; // 法人番号

	private String customerAddress; // 所在地

	private String shipAddress; // 納品先住所

	private String invoiceAddress; // 請求先住所

	private String payment; // 支払方法

	private BigDecimal subtotal; // 小計

	private BigDecimal tax; // 税額

	private BigDecimal total; // 合計

	private BigDecimal totalAmount; // 総金額

	private LocalDate validityPeriod; // 有効期限

	private String remark; // 備考

	private String ifSetOrder; // 注文が作成済みかどうか

	private LocalDateTime setOrderTime; // 注文作成日時

	private LocalDateTime createAt; // 作成日時

	private String createClerkNm; // 作成者

	private LocalDateTime updateAt; // 更新日時

	private String updateBy; // 更新者

	private List<QuotationInfo> quotationInfoList; // 明細情報リスト

	public QuotationVO() {
		super();
	}

	public QuotationVO(String quotationID, LocalDate quotationDate, String quotationType, String customerID,
			String customerName, String customerNickName, String personInResponse, String contactor,
			String customerPhone, String customerCellphone, String customerFaxNumber, String customerTaxNumber,
			String customerAddress, String shipAddress, String invoiceAddress, String payment, BigDecimal subtotal,
			BigDecimal tax, BigDecimal total, BigDecimal totalAmount, LocalDate validityPeriod, String remark,
			String ifSetOrder, LocalDateTime setOrderTime, LocalDateTime createAt, String createClerkNm,
			LocalDateTime updateAt, String updateBy, List<QuotationInfo> quotationInfoList) {
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
		this.quotationInfoList = quotationInfoList;
	}

	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

	public LocalDate getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(LocalDate quotationDate) {
		this.quotationDate = quotationDate;
	}

	public String getQuotationType() {
		return quotationType;
	}

	public void setQuotationType(String quotationType) {
		this.quotationType = quotationType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNickName() {
		return customerNickName;
	}

	public void setCustomerNickName(String customerNickName) {
		this.customerNickName = customerNickName;
	}

	public String getPersonInResponse() {
		return personInResponse;
	}

	public void setPersonInResponse(String personInResponse) {
		this.personInResponse = personInResponse;
	}

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerCellphone() {
		return customerCellphone;
	}

	public void setCustomerCellphone(String customerCellphone) {
		this.customerCellphone = customerCellphone;
	}

	public String getCustomerFaxNumber() {
		return customerFaxNumber;
	}

	public void setCustomerFaxNumber(String customerFaxNumber) {
		this.customerFaxNumber = customerFaxNumber;
	}

	public String getCustomerTaxNumber() {
		return customerTaxNumber;
	}

	public void setCustomerTaxNumber(String customerTaxNumber) {
		this.customerTaxNumber = customerTaxNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(LocalDate validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIfSetOrder() {
		return ifSetOrder;
	}

	public void setIfSetOrder(String ifSetOrder) {
		this.ifSetOrder = ifSetOrder;
	}

	public LocalDateTime getSetOrderTime() {
		return setOrderTime;
	}

	public void setSetOrderTime(LocalDateTime setOrderTime) {
		this.setOrderTime = setOrderTime;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public String getCreateClerkNm() {
		return createClerkNm;
	}

	public void setCreateClerkNm(String createClerkNm) {
		this.createClerkNm = createClerkNm;
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

	public List<QuotationInfo> getQuotationInfoList() {
		return quotationInfoList;
	}

	public void setQuotationInfoList(List<QuotationInfo> quotationInfoList) {
		this.quotationInfoList = quotationInfoList;
	}

}
