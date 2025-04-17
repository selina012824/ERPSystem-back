package com.example.ERPSystem.vo;

import java.time.LocalDate;

// 見積書検索条件REQ
public class MultiSearchQuotationReq {
	
	private String quotationID; // 見積番号

	private String customerID; // 取引先番号

	private String quotationType; // 見積元

	private LocalDate quotationStartDate; // 見積日（開始）

	private LocalDate quotationEndDate; // 見積日（終了）

	private LocalDate validStartDate; // 有効期限（開始）

	private LocalDate validEndDate; // 有効期限（終了）

	public MultiSearchQuotationReq() {
		super();
	}

	public MultiSearchQuotationReq(String quotationID, String customerID, String quotationType, LocalDate quotationStartDate,
			LocalDate quotationEndDate, LocalDate validStartDate, LocalDate validEndDate) {
		super();
		this.quotationID = quotationID;
		this.customerID = customerID;
		this.quotationType = quotationType;
		this.quotationStartDate = quotationStartDate;
		this.quotationEndDate = quotationEndDate;
		this.validStartDate = validStartDate;
		this.validEndDate = validEndDate;
	}

	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getQuotationType() {
		return quotationType;
	}

	public void setQuotationType(String quotationType) {
		this.quotationType = quotationType;
	}

	public LocalDate getQuotationStartDate() {
		return quotationStartDate;
	}

	public void setQuotationStartDate(LocalDate quotationStartDate) {
		this.quotationStartDate = quotationStartDate;
	}

	public LocalDate getQuotationEndDate() {
		return quotationEndDate;
	}

	public void setQuotationEndDate(LocalDate quotationEndDate) {
		this.quotationEndDate = quotationEndDate;
	}

	public LocalDate getValidStartDate() {
		return validStartDate;
	}

	public void setValidStartDate(LocalDate validStartDate) {
		this.validStartDate = validStartDate;
	}

	public LocalDate getValidEndDate() {
		return validEndDate;
	}

	public void setValidEndDate(LocalDate validEndDate) {
		this.validEndDate = validEndDate;
	}
	
	
	
	
	
 

}
