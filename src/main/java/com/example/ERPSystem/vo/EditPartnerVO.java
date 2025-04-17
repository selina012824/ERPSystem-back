package com.example.ERPSystem.vo;

import java.time.LocalDateTime;

public class EditPartnerVO {
	
	private String partnerType; // 取引先種類

	private String partnerName; // 名称

	private String partnerNickName; // 略称

	private String inResponse; // 担当者

	private String contactor; // 連絡先

	private String phone; // 電話番号

	private String cellphone; // 携帯番号

	private String faxNumber; // FAX番号

	private String taxNumber; // 法人番号

	private String address; // 住所

	private String shipAddress; // 納品先住所

	private String invoiceAddress; // 請求先住所

	private String payment; // 支払条件

	private String remark; // 備考

	private LocalDateTime updatedAt; // 更新日時

	private String updatedBy; // 更新者

	private String partnerID; // 取引先ID

	public EditPartnerVO() {
		super();
	}

	public EditPartnerVO(String partnerType, String partnerName, String partnerNickName, String inResponse,
			String contactor, String phone, String cellphone, String faxNumber, String taxNumber, String address,
			String shipAddress, String invoiceAddress, String payment, String remark, LocalDateTime updatedAt,
			String updatedBy, String partnerID) {
		super();
		this.partnerType = partnerType;
		this.partnerName = partnerName;
		this.partnerNickName = partnerNickName;
		this.inResponse = inResponse;
		this.contactor = contactor;
		this.phone = phone;
		this.cellphone = cellphone;
		this.faxNumber = faxNumber;
		this.taxNumber = taxNumber;
		this.address = address;
		this.shipAddress = shipAddress;
		this.invoiceAddress = invoiceAddress;
		this.payment = payment;
		this.remark = remark;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.partnerID = partnerID;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerNickName() {
		return partnerNickName;
	}

	public void setPartnerNickName(String partnerNickName) {
		this.partnerNickName = partnerNickName;
	}

	public String getInResponse() {
		return inResponse;
	}

	public void setInResponse(String inResponse) {
		this.inResponse = inResponse;
	}

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}
	
	

}
