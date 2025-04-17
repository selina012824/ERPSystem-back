package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.WorkOrder;
import com.example.ERPSystem.vo.EditWorkOrderVO;
import com.example.ERPSystem.vo.MultiSearchWorkOrderReq;

@Mapper
public interface WorkOrderMapper {
	
	// 全作業指示書を取得
	public List<WorkOrder> getAllWorkOrder();

	// 指定された作業指示書を取得
	public WorkOrder getWorkOrder(@Param("workOrderID") String workOrderID);

	// 作業指示書番号の重複チェック
	public int selectWorkOrderIDCount(@Param("workOrderID") String workOrderID);

	// 指定注文に作業指示書が既にあるかチェック
	public int selectOrderIDCount(@Param("orderID") String orderID);

	// 作業指示書の新規作成
	public int insertWorkOrder(WorkOrder workOrder);

	// 作業指示書の編集
	public int editWorkOrder(EditWorkOrderVO req);

	// 複数条件で作業指示書を検索
	public List<WorkOrder> multiSearch(MultiSearchWorkOrderReq req);

	// 作業指示書を完了に更新
	public int finishWorkOrder(@Param("workOrderID") String workOrderID);

	// 作業指示書を中止に更新
	public int endWorkOrder(@Param("workOrderID") String workOrderID);

}
