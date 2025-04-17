package com.example.ERPSystem.service.ifs;

import java.util.List;

import com.example.ERPSystem.entity.WorkOrder;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetWorkOrderRes;
import com.example.ERPSystem.vo.MultiSearchWorkOrderReq;
import com.example.ERPSystem.vo.WorkOrderAllRes;

public interface WorkOrderService {

	// 全ての作業指示書データを取得
	public WorkOrderAllRes getAllWorkOrder();

	// 指定された作業指示書データを取得
	public GetWorkOrderRes getWorkOrder(String workOrderID);

	// 作業指示書を新規作成
	public List<BasicRes> addWorkOrder(WorkOrder req);

	// 作業指示書を編集
	public List<BasicRes> editWorkOrder(WorkOrder req);

	// 複数条件で検索
	public WorkOrderAllRes multiSearch(MultiSearchWorkOrderReq req);

	// 作業を中止
	public BasicRes endWorkOrder(String workOrderID);

	// 作業を完了
	public BasicRes finishWorkOrder(String workOrderID);

}
