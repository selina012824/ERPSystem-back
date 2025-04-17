package com.example.ERPSystem.vo;

import com.example.ERPSystem.entity.Partner;

public class GetPartnerRes extends BasicRes {

	private Partner partner;

	public GetPartnerRes() {
		super();
	}

	public GetPartnerRes(int code, String message) {
		super(code, message);
	}

	public GetPartnerRes(int code, String message, Partner partner) {
		super(code, message);
		this.partner = partner;
	}

	public GetPartnerRes(Partner partner) {
		super();
		this.partner = partner;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

}
