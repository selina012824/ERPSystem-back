package com.example.ERPSystem.vo;

import com.example.ERPSystem.entity.WorkOrder;

public class GetWorkOrderRes extends BasicRes {

	private WorkOrder workOrder;

	public GetWorkOrderRes() {
		super();
	}

	public GetWorkOrderRes(int code, String message) {
		super(code, message);
	}

	public GetWorkOrderRes(int code, String message, WorkOrder workOrder) {
		super(code, message);
		this.workOrder = workOrder;
	}

	public GetWorkOrderRes(WorkOrder workOrder) {
		super();
		this.workOrder = workOrder;
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

}
