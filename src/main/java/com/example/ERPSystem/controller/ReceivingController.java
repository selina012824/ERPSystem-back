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
import com.example.ERPSystem.service.ifs.ReceivingService;
import com.example.ERPSystem.vo.AddReceivingReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetReceivingRes;
import com.example.ERPSystem.vo.MultiSerachReceivingReq;
import com.example.ERPSystem.vo.ReceivingAllRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class ReceivingController {

	@Autowired
	private ReceivingService receivingService;

	// 全ての入荷伝票データを取得
	@GetMapping(value = "receiving/get_all_receiving")
	public ResponseEntity<ReceivingAllRes> getAllReceiving() {
		ReceivingAllRes res = receivingService.getAllReceiving();
		if (res.getReceivingList() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 指定した入荷伝票データを取得
	@PostMapping(value = "receiving/get_receiving")
	public ResponseEntity<GetReceivingRes> getReceiving(@RequestBody String receivingID) {
		GetReceivingRes res = receivingService.getReceiving(receivingID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 入荷伝票を新規作成
	@PostMapping(value = "receiving/add_receiving")
	public ResponseEntity<List<BasicRes>> addReceiving(@RequestBody AddReceivingReq req) {
		List<BasicRes> res = receivingService.addReceiving(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 入荷伝票を編集
	@PostMapping(value = "receiving/edit_receiving")
	public ResponseEntity<List<BasicRes>> editReceiving(@RequestBody AddReceivingReq req) {
		List<BasicRes> res = receivingService.editReceiving(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 複数条件で入荷伝票を検索
	@PostMapping(value = "receiving/multi_search")
	public ResponseEntity<ReceivingAllRes> multiSearch(@RequestBody MultiSerachReceivingReq req) {
		ReceivingAllRes res = receivingService.multiSearch(req);
		return ResponseEntity.ok(res);
	}

	// 完成進貨

}
