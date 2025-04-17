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
import com.example.ERPSystem.service.ifs.PurchaseOrderService;
import com.example.ERPSystem.vo.AddPoReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetPORes;
import com.example.ERPSystem.vo.MultiSearchPOReq;
import com.example.ERPSystem.vo.PurchaseOrderAllRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class PurchaseOrderServiceController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	// 全ての購買注文データを取得
	@GetMapping(value = "purchaseOrder/get_all_PO")
	public ResponseEntity<PurchaseOrderAllRes> getAllPO() {
		PurchaseOrderAllRes res = purchaseOrderService.getAllPO();
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 指定された購買注文データを取得
	@PostMapping(value = "purchaseOrder/get_PO")
	public ResponseEntity<GetPORes> getPO(@RequestBody String purchaseOrderID) {
		GetPORes res = purchaseOrderService.getPO(purchaseOrderID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 購買注文を新規作成
	@PostMapping(value = "purchaseOrder/add_PO")
	public ResponseEntity<List<BasicRes>> addPO(@RequestBody AddPoReq req) {
		List<BasicRes> res = purchaseOrderService.addPO(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 購買注文を編集
	@PostMapping(value = "purchaseOrder/edit_PO")
	public ResponseEntity<List<BasicRes>> editPO(@RequestBody AddPoReq req) {
		List<BasicRes> res = purchaseOrderService.editPO(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 購買注文条件検索
	@PostMapping(value = "purchaseOrder/multi_search")
	public ResponseEntity<PurchaseOrderAllRes> multiSearch(@RequestBody MultiSearchPOReq req) {
		PurchaseOrderAllRes res = purchaseOrderService.mulitiSearch(req);
		return ResponseEntity.ok(res);
	}

	// 購買注文番号一覧取得
	@GetMapping(value = "purchaseOrder/get_ids")
	public ResponseEntity<List<String>> getAllPOID() {
		List<String> res = purchaseOrderService.getAllPOID();
		return ResponseEntity.ok(res);
	}

}
