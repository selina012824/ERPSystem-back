package com.example.ERPSystem.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ERPSystem.entity.ReceivingDetails;

public class ReceivingVO {

	private String receivingID; // 入荷伝票番号

	private String purchaseOrderID; // 購買注文番号

	private LocalDate receivingDate; // 入荷日

	private String status; // 状態

	private String inspector; // 検査担当者

	private String inspectionResult; // 検査結果

	private String supplierID; // 仕入先

	private String invoiceStatus; // 請求書状態

	private LocalDateTime createdAt; // 作成日時

	private String createdBy; // 作成者名

	private LocalDateTime updatedAt; // 更新日時

	private String updatedBy; // 更新者名

	private List<ReceivingDetails> receivingInfoList; // 入荷明細リスト

	public ReceivingVO() {
		super();
	}

	public ReceivingVO(String receivingID, String purchaseOrderID, LocalDate receivingDate, String status,
			String inspector, String inspectionResult, String supplierID, String invoiceStatus, LocalDateTime createdAt,
			String createdBy, LocalDateTime updatedAt, String updatedBy, List<ReceivingDetails> receivingInfoList) {
		super();
		this.receivingID = receivingID;
		this.purchaseOrderID = purchaseOrderID;
		this.receivingDate = receivingDate;
		this.status = status;
		this.inspector = inspector;
		this.inspectionResult = inspectionResult;
		this.supplierID = supplierID;
		this.invoiceStatus = invoiceStatus;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.receivingInfoList = receivingInfoList;
	}

	public String getReceivingID() {
		return receivingID;
	}

	public void setReceivingID(String receivingID) {
		this.receivingID = receivingID;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public List<ReceivingDetails> getReceivingInfoList() {
		return receivingInfoList;
	}

	public void setReceivingInfoList(List<ReceivingDetails> receivingInfoList) {
		this.receivingInfoList = receivingInfoList;
	}

}
