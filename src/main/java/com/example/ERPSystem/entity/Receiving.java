package com.example.ERPSystem.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//　入荷伝票
@Entity
@Table(name = "receiving")
public class Receiving {

	@Id
	@Column(name = "receiving_id")
	private String receivingID; // 入荷伝票番号

	@Column(name = "purchase_order_id")
	private String purchaseOrderID; // 購買注文番号

	@Column(name = "receiving_date")
	private LocalDate receivingDate; // 入荷日

	@Column(name = "status")
	private String status; // 状態

	@Column(name = "inspector")
	private String inspector; // 検査担当者

	@Column(name = "inspection_result")
	private String inspectionResult; // 検査結果

	@Column(name = "supplier_id")
	private String supplierID; // 仕入先

	@Column(name = "invoice_status")
	private String invoiceStatus; // 請求書状態

	@Column(name = "created_at")
	private LocalDateTime createdAt; // 作成日時

	@Column(name = "created_by")
	private String createdBy; // 作成者

	@Column(name = "updated_at")
	private LocalDateTime updatedAt; // 更新日時

	@Column(name = "updated_by")
	private String updatedBy; // 更新者

	public Receiving() {
		super();
	}

	public Receiving(String receivingID, String purchaseOrderID, LocalDate receivingDate, String status,
			String inspector, String inspectionResult, String supplierID, String invoiceStatus, LocalDateTime createdAt,
			String createdBy, LocalDateTime updatedAt, String updatedBy) {
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
	
	

}
