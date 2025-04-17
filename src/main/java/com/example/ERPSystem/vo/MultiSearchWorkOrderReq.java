package com.example.ERPSystem.vo;

import java.time.LocalDate;

//　作業指示書検索条件REQ
public class MultiSearchWorkOrderReq {

	private String workOrderID; // 作業指示書番号

	private String orderID; // 注文番号

	private String status; // 状態

	private LocalDate plannedStartDateStart; // 予定開始日（開始）

	private LocalDate plannedStartDateEnd; // 予定開始日（終了）

	private LocalDate plannedEndDateStart; // 予定完了日（開始）

	private LocalDate plannedEndDateEnd; // 予定完了日（終了）

	public MultiSearchWorkOrderReq() {
		super();
	}

	public MultiSearchWorkOrderReq(String workOrderID, String orderID, String status, LocalDate plannedStartDateStart,
			LocalDate plannedStartDateEnd, LocalDate plannedEndDateStart, LocalDate plannedEndDateEnd) {
		super();
		this.workOrderID = workOrderID;
		this.orderID = orderID;
		this.status = status;
		this.plannedStartDateStart = plannedStartDateStart;
		this.plannedStartDateEnd = plannedStartDateEnd;
		this.plannedEndDateStart = plannedEndDateStart;
		this.plannedEndDateEnd = plannedEndDateEnd;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPlannedStartDateStart() {
		return plannedStartDateStart;
	}

	public void setPlannedStartDateStart(LocalDate plannedStartDateStart) {
		this.plannedStartDateStart = plannedStartDateStart;
	}

	public LocalDate getPlannedStartDateEnd() {
		return plannedStartDateEnd;
	}

	public void setPlannedStartDateEnd(LocalDate plannedStartDateEnd) {
		this.plannedStartDateEnd = plannedStartDateEnd;
	}

	public LocalDate getPlannedEndDateStart() {
		return plannedEndDateStart;
	}

	public void setPlannedEndDateStart(LocalDate plannedEndDateStart) {
		this.plannedEndDateStart = plannedEndDateStart;
	}

	public LocalDate getPlannedEndDateEnd() {
		return plannedEndDateEnd;
	}

	public void setPlannedEndDateEnd(LocalDate plannedEndDateEnd) {
		this.plannedEndDateEnd = plannedEndDateEnd;
	}

}
