package com.example.ERPSystem.vo;

import java.time.LocalDate;

// 入荷伝票検索条件REQ
public class MultiSerachReceivingReq {

	private String receivingID; // 入荷伝票番号

	private String purchaseOrderID; // 発注書番号

	private String supplierID; // 仕入先

	private LocalDate receivingStartDate; // 入荷日(開始)

	private LocalDate receivingEndDate; // 入荷日(終了)

	private String status; // 状態

	private String inspectionResult; // 検査結果

	public MultiSerachReceivingReq() {
		super();
	}

	public MultiSerachReceivingReq(String receivingID, String purchaseOrderID, String supplierID,
			LocalDate receivingStartDate, LocalDate receivingEndDate, String status, String inspectionResult) {
		super();
		this.receivingID = receivingID;
		this.purchaseOrderID = purchaseOrderID;
		this.supplierID = supplierID;
		this.receivingStartDate = receivingStartDate;
		this.receivingEndDate = receivingEndDate;
		this.status = status;
		this.inspectionResult = inspectionResult;
	}

	public String getReceivingID() {
		return receivingID;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public LocalDate getReceivingStartDate() {
		return receivingStartDate;
	}

	public LocalDate getReceivingEndDate() {
		return receivingEndDate;
	}

	public String getStatus() {
		return status;
	}

	public String getInspectionResult() {
		return inspectionResult;
	}

}
