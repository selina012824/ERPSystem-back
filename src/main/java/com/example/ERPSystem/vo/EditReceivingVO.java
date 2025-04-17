package com.example.ERPSystem.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditReceivingVO {

	private LocalDate receivingDate; // 入荷日

	private String status; // 状態

	private String inspector; // 検査担当者

	private String inspectionResult; // 検査結果

	private String supplierID; // 仕入先

	private String invoiceStatus; // 請求書状態

	private LocalDateTime updatedAt; // 更新日時

	private String updatedBy; // 更新者名

	private String receivingID; // 入荷伝票番号

	public EditReceivingVO() {
		super();
	}

	public EditReceivingVO(LocalDate receivingDate, String status, String inspector, String inspectionResult,
			String supplierID, String invoiceStatus, LocalDateTime updatedAt, String updatedBy, String receivingID) {
		super();
		this.receivingDate = receivingDate;
		this.status = status;
		this.inspector = inspector;
		this.inspectionResult = inspectionResult;
		this.supplierID = supplierID;
		this.invoiceStatus = invoiceStatus;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.receivingID = receivingID;
	}

	public LocalDate getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(LocalDate receivingDate) {
		this.receivingDate = receivingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public String getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
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

	public String getReceivingID() {
		return receivingID;
	}

	public void setReceivingID(String receivingID) {
		this.receivingID = receivingID;
	}
	
	

}