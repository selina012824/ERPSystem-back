package com.example.ERPSystem.vo;

public class MultiSearchPartnerReq {

	private String partnerID; // 取引先ID

	private String partnerType; // 取引先種類

	private String partnerName; // 名称

	private String contactor; // 担当者

	private String phone; // 電話番号

	private String cellphone; // 携帯番号

	public MultiSearchPartnerReq() {
		super();
	}

	public MultiSearchPartnerReq(String partnerID, String partnerType, String partnerName, String contactor,
			String phone, String cellphone) {
		super();
		this.partnerID = partnerID;
		this.partnerType = partnerType;
		this.partnerName = partnerName;
		this.contactor = contactor;
		this.phone = phone;
		this.cellphone = cellphone;
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

	public String getContactor() {
		return contactor;
	}

	public String getPhone() {
		return phone;
	}

	public String getCellphone() {
		return cellphone;
	}

}
