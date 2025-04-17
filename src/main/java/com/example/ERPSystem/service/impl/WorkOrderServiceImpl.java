package com.example.ERPSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ERPSystem.contents.ResMessage;
import com.example.ERPSystem.entity.WorkOrder;
import com.example.ERPSystem.mapper.OrderMapper;
import com.example.ERPSystem.mapper.WorkOrderMapper;
import com.example.ERPSystem.service.ifs.WorkOrderService;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.EditWorkOrderVO;
import com.example.ERPSystem.vo.GetWorkOrderRes;
import com.example.ERPSystem.vo.MultiSearchWorkOrderReq;
import com.example.ERPSystem.vo.WorkOrderAllRes;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private WorkOrderMapper workOrderMapper;

	/**
	 * 全ての作業指示書データを取得
	 * 
	 * @return 全ての作業指示書データ
	 */
	@Override
	public WorkOrderAllRes getAllWorkOrder() {
		List<WorkOrder> res = workOrderMapper.getAllWorkOrder();
		return new WorkOrderAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 指定された作業指示書データを取得
	 * 
	 * @param workOrderID 作業指示書番号
	 * @return 1.指定された作業指示書データ,2.成功・失敗メッセージ
	 */
	@Override
	public GetWorkOrderRes getWorkOrder(String workOrderID) {

		WorkOrder res = workOrderMapper.getWorkOrder(workOrderID);
		return new GetWorkOrderRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 作業指示書を新規作成
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Override
	public List<BasicRes> addWorkOrder(WorkOrder req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 作業指示書番号がすでに存在するかをチェック
		int count = workOrderMapper.selectWorkOrderIDCount(req.getWorkOrderID());
		if (count > 0) {
			checkRes.add(new BasicRes(ResMessage.PARAM_WORK_ORDER_ID_DUPLICATED.getCode(),
					ResMessage.PARAM_WORK_ORDER_ID_DUPLICATED.getMessage()));
		}

		// 該当の注文番号に対して既に作業指示書が作成されていないか確認する
		count = workOrderMapper.selectOrderIDCount(req.getOrderID());
		if (count > 0) {
			checkRes.add(new BasicRes(ResMessage.WORK_ORDER_IS_CREATED.getCode(),
					ResMessage.WORK_ORDER_IS_CREATED.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() > 0) {
			return checkRes;
		}

		// 作業指示書データを登録
		workOrderMapper.insertWorkOrder(req);
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));
		return checkRes;
	}

	/**
	 * 作業指示書を編集
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Override
	public List<BasicRes> editWorkOrder(WorkOrder req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 作業指示書番号に該当するデータが存在するか確認
		int count = workOrderMapper.selectWorkOrderIDCount(req.getWorkOrderID());
		if (count < 1) {
			checkRes.add(new BasicRes(ResMessage.WORK_ORDER_NOT_FOUND.getCode(),
					ResMessage.WORK_ORDER_NOT_FOUND.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}
		// 作業指示書のデータを更新
		EditWorkOrderVO workOrder = new EditWorkOrderVO();
		workOrder.setStatus(req.getStatus());
		workOrder.setPlannedStartDate(req.getPlannedStartDate());
		workOrder.setPlannedEndDate(req.getPlannedEndDate());
		workOrder.setActualStartDate(req.getActualStartDate());
		workOrder.setActualEndDate(req.getActualEndDate());
		workOrder.setUpdatedAt(req.getUpdatedAt());
		workOrder.setUpdatedBy(req.getUpdatedBy());
		workOrder.setWorkOrderID(req.getWorkOrderID());

		workOrderMapper.editWorkOrder(workOrder);
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));
		return checkRes;
	}

	/**
	 * 複数条件検索
	 * 
	 * @param req 検索条件
	 * @return 検索結果
	 */
	@Override
	public WorkOrderAllRes multiSearch(MultiSearchWorkOrderReq req) {
		List<WorkOrder> res = workOrderMapper.multiSearch(req);
		return new WorkOrderAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 作業を中止
	 * 
	 * @param workOrderID 作業指示書番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes endWorkOrder(String workOrderID) {
		// 作業指示書の状態を「中止」に更新
		workOrderMapper.endWorkOrder(workOrderID);
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

	/**
	 * 作業を完了
	 * 
	 * @param workOrderID 作業指示書番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes finishWorkOrder(String workOrderID) {
		// 作業指示書の状態を「完了」に更新
		workOrderMapper.finishWorkOrder(workOrderID);
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

	/**
	 * 作業指示書入力パラメータの検証
	 * 
	 * @param req 入力されたデータ
	 * @return エラーメッセージのリスト
	 */
	public List<BasicRes> checkParam(WorkOrder req) {
		List<BasicRes> errorMessage = new ArrayList<>();

		// 主表の入力値チェック
		// 必須項目が空または null であってはならない
		if (!StringUtils.hasText(req.getWorkOrderID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_WORK_ORDER_ID_ERROR.getCode(),
					ResMessage.PARAM_WORK_ORDER_ID_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getOrderID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_ID_ERROR.getCode(),
					ResMessage.PARAM_ORDER_ID_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getStatus())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_WORK_ORDER_STATUS_ERROR.getCode(),
					ResMessage.PARAM_WORK_ORDER_STATUS_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getCreatedBy())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CREATE_CLERK_ERROR.getCode(),
					ResMessage.PARAM_CREATE_CLERK_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getUpdatedBy())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_UPDATE_CLERK_ERROR.getCode(),
					ResMessage.PARAM_UPDATE_CLERK_ERROR.getMessage()));
		}

		if (req.getCreatedAt() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CREATE_TIME_ERROR.getCode(),
					ResMessage.PARAM_CREATE_TIME_ERROR.getMessage()));
		}

		if (req.getUpdatedAt() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_UPDATE_TIME_ERROR.getCode(),
					ResMessage.PARAM_UPDATE_TIME_ERROR.getMessage()));
		}

		// 予定開始日は予定完了日より後であってはならない
		if (req.getPlannedStartDate() != null && req.getPlannedEndDate() != null) {
			if (req.getPlannedStartDate().isAfter(req.getPlannedEndDate())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_WORK_ORDER_PLANNED_DATE_ERROR.getCode(),
						ResMessage.PARAM_WORK_ORDER_PLANNED_DATE_ERROR.getMessage()));
			}
		}

		// 実際開始日は実際終了日より後であってはならない
		if (req.getActualStartDate() != null && req.getActualEndDate() != null) {
			if (req.getActualStartDate().isAfter(req.getActualEndDate())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_WORK_ORDER_ACTUAL_DATE_ERROR.getCode(),
						ResMessage.PARAM_WORK_ORDER_ACTUAL_DATE_ERROR.getMessage()));
			}
		}

		// 該当する注文番号が存在するか確認
		int count = orderMapper.selectOrderIDCount(req.getOrderID());
		if (count < 1) {
			errorMessage
					.add(new BasicRes(ResMessage.ORDER_NOT_FOUND.getCode(), ResMessage.ORDER_NOT_FOUND.getMessage()));
		}

		// 明細情報が空配列であってはならない
		if (req.getOrderDetailID().equalsIgnoreCase("[]")) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_INFO__ID_ERROR.getCode(),
					ResMessage.PARAM_ORDER_INFO__ID_ERROR.getMessage()));
		}

		return errorMessage;
	}
}
