package com.example.ERPSystem.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class QuotationInfoID implements Serializable {

	private String quotationDetailID;

	private String quotationID;

	public String getQuotationDetailID() {
		return quotationDetailID;
	}

	public void setQuotationDetailID(String quotationDetailID) {
		this.quotationDetailID = quotationDetailID;
	}

	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

}
