package com.example.ERPSystem.vo;

import java.util.List;

import com.example.ERPSystem.entity.Partner;

public class PartnerAllRes extends BasicRes {

	private List<Partner> partner;

	public PartnerAllRes() {
		super();
	}

	public PartnerAllRes(int code, String message) {
		super(code, message);
	}

	public PartnerAllRes(int code, String message, List<Partner> partner) {
		super(code, message);
		this.partner = partner;
	}

	public PartnerAllRes(List<Partner> partner) {
		super();
		this.partner = partner;
	}

	public List<Partner> getPartner() {
		return partner;
	}

}
