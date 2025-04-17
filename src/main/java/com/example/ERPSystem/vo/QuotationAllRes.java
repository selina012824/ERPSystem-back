package com.example.ERPSystem.vo;

import java.util.List;

import com.example.ERPSystem.entity.Quotation;


public class QuotationAllRes extends BasicRes {

	private List<Quotation> quotationList;

	public QuotationAllRes() {
		super();
	}

	public QuotationAllRes(int code, String message) {
		super(code, message);
	}

	public QuotationAllRes(int code, String message, List<Quotation> quotationList) {
		super(code, message);
		this.quotationList = quotationList;
	}

	public List<Quotation> getQuotationList() {
		return quotationList;
	}

}
