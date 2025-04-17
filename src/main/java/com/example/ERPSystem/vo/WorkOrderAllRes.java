package com.example.ERPSystem.vo;

import java.util.List;

import com.example.ERPSystem.entity.WorkOrder;

public class WorkOrderAllRes extends BasicRes {

	private List<WorkOrder> workOrder;

	public WorkOrderAllRes() {
		super();
	}

	public WorkOrderAllRes(int code, String message) {
		super(code, message);
	}

	public WorkOrderAllRes(int code, String message, List<WorkOrder> workOrder) {
		super(code, message);
		this.workOrder = workOrder;
	}

	public WorkOrderAllRes(List<WorkOrder> workOrder) {
		super();
		this.workOrder = workOrder;
	}

	public List<WorkOrder> getWorkOrder() {
		return workOrder;
	}

}
