package com.example.ERPSystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// 取引先
@Entity
@Table(name = "partner")
public class Partner {

	@Id
	@Column(name = "partner_id")
	private String partnerID; // 取引先ID

	@Column(name = "partner_type")
	private String partnerType; // 取引先種別

	@Column(name = "partner_name")
	private String partnerName; // 取引先名

	@Column(name = "partner_nickname")
	private String partnerNickName; // 取引先略称

	@Column(name = "in_response")
	private String inResponse; // 責任者

	@Column(name = "contactor")
	private String contactor; // 担当者

	@Column(name = "phone")
	private String phone; // 電話番号

	@Column(name = "cellphone")
	private String cellphone; // 携帯番号

	@Column(name = "fax_number")
	private String faxNumber; // FAX番号

	@Column(name = "tax_number")
	private String taxNumber; // 法人番号

	@Column(name = "address")
	private String address; // 住所

	@Column(name = "ship_address")
	private String shipAddress; // 納品先住所

	@Column(name = "invoice_address")
	private String invoiceAddress; // 請求先住所

	@Column(name = "payment")
	private String payment; // 支払条件

	@Column(name = "remark")
	private String remark; // 備考

	@Column(name = "created_at")
	private LocalDateTime createdAt; // 作成日時

	@Column(name = "created_by")
	private String createdBy; // 作成者

	@Column(name = "updated_at")
	private LocalDateTime updatedAt; // 更新日時

	@Column(name = "updated_by")
	private String updatedBy; // 更新者
	public Partner() {
		super();
	}

	public Partner(String partnerID, String partnerType, String partnerName, String partnerNickName, String inResponse,
			String contactor, String phone, String cellphone, String faxNumber, String taxNumber, String address,
			String shipAddress, String invoiceAddress, String payment, String remark, LocalDateTime createdAt,
			String createdBy, LocalDateTime updatedAt, String updatedBy) {
		super();
		this.partnerID = partnerID;
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
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	

}
