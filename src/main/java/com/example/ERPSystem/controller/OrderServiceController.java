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
import com.example.ERPSystem.service.ifs.OrderService;
import com.example.ERPSystem.vo.AddOrderReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetOrderRes;
import com.example.ERPSystem.vo.GetSelectOrderReq;
import com.example.ERPSystem.vo.MultiSearchOrderReq;
import com.example.ERPSystem.vo.OrderAllRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class OrderServiceController {

	@Autowired
	private OrderService orderService;

	// 全ての注文データを取得
	@GetMapping(value = "order/get_all_order")
	public ResponseEntity<OrderAllRes> getAllOrder() {

		OrderAllRes res = orderService.getAllOrder();
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 指定注文のデータを取得
	@PostMapping(value = "order/get__order")
	public ResponseEntity<GetOrderRes> getOrder(@RequestBody String req) {
		GetOrderRes res = orderService.getOrder(req);

		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 注文を新規作成
	@PostMapping(value = "order/add_order")
	public ResponseEntity<List<BasicRes>> addOrder(@RequestBody AddOrderReq req) {
		List<BasicRes> res = orderService.addOrder(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 注文を編集
	@PostMapping(value = "order/edit_order")
	public ResponseEntity<List<BasicRes>> editOrder(@RequestBody AddOrderReq req) {
		List<BasicRes> res = orderService.editOrder(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 条件による注文検索
	@PostMapping(value = "order/multi_search")
	public ResponseEntity<OrderAllRes> multiSearch(@RequestBody MultiSearchOrderReq req) {
		OrderAllRes res = orderService.multiSearch(req);
		return ResponseEntity.ok(res);
	}

	// 注文を中止
	@PostMapping(value = "order/end_order")
	public ResponseEntity<BasicRes> endOrder(@RequestBody String orderID) {
		BasicRes res = orderService.endOrder(orderID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 注文を復旧
	@PostMapping(value = "order/restore_order")
	public ResponseEntity<BasicRes> restoreOrder(@RequestBody String orderID) {
		BasicRes res = orderService.restoreOrder(orderID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 注文と選択された明細を取得
	@PostMapping(value = "order/get_select_order")
	public ResponseEntity<GetOrderRes> getSelectOrder(@RequestBody GetSelectOrderReq req) {
		GetOrderRes res = orderService.getSelectOrder(req);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);

	}

	// 全ての注文番号を取得
	@GetMapping(value = "order/get_order_ids")
	public ResponseEntity<List<String>> getOrderIDs() {
		List<String> res = orderService.getAllOrderID();
		return ResponseEntity.ok(res);
	}

	// 購買注文を作成（状態更新）
	@PostMapping(value = "order/set_PO")
	public ResponseEntity<BasicRes> setPO(@RequestBody String orderID) {
		BasicRes res = orderService.setPO(orderID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}
}