package com.example.ERPSystem.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// 作業指示書
@Entity
@Table(name = "work_orders")
public class WorkOrder {

	@Id
	@Column(name = "work_order_id")
	private String workOrderID; // 作業指示書番号

	@Column(name = "order_id")
	private String orderID; // 注文番号

	@Column(name = "order_detail_id")
	private String orderDetailID; // 注文明細番号

	@Column(name = "status")
	private String status; // 状態

	@Column(name = "planned_start_date")
	private LocalDate plannedStartDate; // 予定開始日

	@Column(name = "planned_end_date")
	private LocalDate plannedEndDate; // 予定完了日

	@Column(name = "actual_start_date")
	private LocalDate actualStartDate; // 実際開始日

	@Column(name = "actual_end_date")
	private LocalDate actualEndDate; // 実際完了日

	@Column(name = "created_at")
	private LocalDateTime createdAt; // 作成日時

	@Column(name = "created_by")
	private String createdBy; // 作成者

	@Column(name = "updated_at")
	private LocalDateTime updatedAt; // 更新日時

	@Column(name = "updated_by")
	private String updatedBy; // 更新者

	public WorkOrder() {
		super();
	}

	public WorkOrder(String workOrderID, String orderID, String orderDetailID, String status,
			LocalDate plannedStartDate, LocalDate plannedEndDate, LocalDate actualStartDate, LocalDate actualEndDate,
			LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
		super();
		this.workOrderID = workOrderID;
		this.orderID = orderID;
		this.orderDetailID = orderDetailID;
		this.status = status;
		this.plannedStartDate = plannedStartDate;
		this.plannedEndDate = plannedEndDate;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public String getWorkOrderID() {
		return workOrderID;
	}

	public void setWorkOrderID(String workOrderID) {
		this.workOrderID = workOrderID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(LocalDate plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public LocalDate getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(LocalDate plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public LocalDate getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(LocalDate actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public LocalDate getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(LocalDate actualEndDate) {
		this.actualEndDate = actualEndDate;
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
