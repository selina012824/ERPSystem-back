package com.example.ERPSystem.vo;

//　指定見積書データRES
public class GetQuotationRes extends BasicRes {

	private QuotationVO quotation;

	public GetQuotationRes() {
		super();
	}

	public GetQuotationRes(int code, String message) {
		super(code, message);
	}

	public GetQuotationRes(int code, String message, QuotationVO quotation) {
		super(code, message);
		this.quotation = quotation;
	}

	public GetQuotationRes(QuotationVO quotation) {
		super();
		this.quotation = quotation;
	}

	public QuotationVO getQuotation() {
		return quotation;
	}

}
