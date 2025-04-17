package com.example.ERPSystem.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditWorkOrderVO {

	private String status; // 状態

	private LocalDate plannedStartDate; // 予定開始日

	private LocalDate plannedEndDate; // 予定完了日

	private LocalDate actualStartDate; // 実際開始日

	private LocalDate actualEndDate; // 実際完了日

	private LocalDateTime updatedAt; // 更新日時

	private String updatedBy; // 更新者

	private String workOrderID; // 作業指示書番号

	public EditWorkOrderVO() {
		super();
	}

	public EditWorkOrderVO(String status, LocalDate plannedStartDate, LocalDate plannedEndDate,
			LocalDate actualStartDate, LocalDate actualEndDate, LocalDateTime updatedAt, String updatedBy,
			String workOrderID) {
		super();
		this.status = status;
		this.plannedStartDate = plannedStartDate;
		this.plannedEndDate = plannedEndDate;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.workOrderID = workOrderID;
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

	public String getWorkOrderID() {
		return workOrderID;
	}

	public void setWorkOrderID(String workOrderID) {
		this.workOrderID = workOrderID;
	}

}
