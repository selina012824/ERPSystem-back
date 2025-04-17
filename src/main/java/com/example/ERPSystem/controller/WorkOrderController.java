package com.example.ERPSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERPSystem.contents.ResMessage;
import com.example.ERPSystem.entity.WorkOrder;
import com.example.ERPSystem.service.ifs.WorkOrderService;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetWorkOrderRes;
import com.example.ERPSystem.vo.MultiSearchWorkOrderReq;
import com.example.ERPSystem.vo.WorkOrderAllRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class WorkOrderController {

	@Autowired
	private WorkOrderService workOrderService;

	// 全ての作業指示書データを取得
	@GetMapping(value = "workOrder/get_all_workOrder")
	public ResponseEntity<WorkOrderAllRes> getAllWorkOrder() {
		WorkOrderAllRes res = workOrderService.getAllWorkOrder();
		if (res.getWorkOrder() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(res);
	}

	// 指定された作業指示書データを取得
	@PostMapping(value = "workOrder/get_workOrder")
	public ResponseEntity<GetWorkOrderRes> getWorkOrder(@RequestBody String req) {
		GetWorkOrderRes res = workOrderService.getWorkOrder(req);

		if (res.getWorkOrder() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(res);
	}

	// 作業指示書を新規作成
	@PostMapping(value = "workOrder/add_workOrder")
	public ResponseEntity<List<BasicRes>> addWorkOrder(@RequestBody WorkOrder req) {
		List<BasicRes> result = workOrderService.addWorkOrder(req);

		if (result.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.ok(result);
	}

	// 作業指示書を編集
	@PostMapping(value = "workOrder/edit_workOrder")
	public ResponseEntity<List<BasicRes>> editWorkOrder(@RequestBody WorkOrder req) {
		List<BasicRes> result = workOrderService.editWorkOrder(req);

		if (result.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.ok(result);
	}

	// 複数条件で検索
	@PostMapping(value = "workOrder/multi_search")
	public ResponseEntity<WorkOrderAllRes> multiSearch(@RequestBody MultiSearchWorkOrderReq req) {
		WorkOrderAllRes res = workOrderService.multiSearch(req);
		if (res.getWorkOrder() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(res);
	}

	// 作業を完了
	@PostMapping(value = "workOrder/finish_workOrder")
	public ResponseEntity<BasicRes> finishWorkOrder(@RequestBody String req) {
		BasicRes res = workOrderService.finishWorkOrder(req);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 作業を中止
	@PostMapping(value = "workOrder/end_workOrder")
	public ResponseEntity<BasicRes> endWorkOrder(@RequestBody String req) {
		BasicRes res = workOrderService.endWorkOrder(req);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}
}
