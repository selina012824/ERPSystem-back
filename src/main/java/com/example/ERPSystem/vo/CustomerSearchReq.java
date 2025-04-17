package com.example.ERPSystem.vo;

public class CustomerSearchReq {

	private String partnerID; // 取引先ID

	private String partnerType; // 取引先種類

	private String partnerName; // 名称

	private String partnerNickName; // 略称

	private String inResponse; // 責任者

	private String contactor; // 担当者

	private String phone; // 電話番号

	private String cellphone; // 携帯番号

	private String faxNumber; // FAX番号

	private String taxNumber; // 法人番号

	private String address; // 住所

	private String shipAddress; // 納品先住所

	private String invoiceAddress; // 請求先住所

	private String payment; // 支払方法
	
	public CustomerSearchReq() {
		super();
	}

	public CustomerSearchReq(String partnerID, String partnerType, String partnerName, String partnerNickName,
			String inResponse, String contactor, String phone, String cellphone, String faxNumber, String taxNumber,
			String address, String shipAddress, String invoiceAddress, String payment) {
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
	}

	public String getPartnerID() {
		return partnerID;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public String getPartnerNickName() {
		return partnerNickName;
	}

	public String getInResponse() {
		return inResponse;
	}

	public String getContactor() {
		return contactor;
	}

	public String getPhone() {
		return phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public String getAddress() {
		return address;
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

}
