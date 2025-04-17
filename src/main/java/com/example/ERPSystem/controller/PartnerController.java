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
import com.example.ERPSystem.entity.Partner;
import com.example.ERPSystem.service.ifs.PartnerService;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.CustomerSearchReq;
import com.example.ERPSystem.vo.GetPartnerRes;
import com.example.ERPSystem.vo.MultiSearchPartnerReq;
import com.example.ERPSystem.vo.PartnerAllRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;

	// すべての取引先情報を取得
	@GetMapping(value = "partner/get_all_partner")
	public ResponseEntity<PartnerAllRes> getAllPartner() {
		PartnerAllRes res = partnerService.getAllPartner();
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 指定された取引先情報を取得
	@PostMapping(value = "partner/get_partner")
	public ResponseEntity<GetPartnerRes> getPartner(@RequestBody String partnerID) {
		GetPartnerRes res = partnerService.getPartner(partnerID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 取引先を新規登録
	@PostMapping(value = "partner/add_partner")
	public ResponseEntity<List<BasicRes>> addPartner(@RequestBody Partner req) {
		List<BasicRes> res = partnerService.addPartner(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 取引先情報を編集
	@PostMapping(value = "partner/edit_partner")
	public ResponseEntity<List<BasicRes>> editPartner(@RequestBody Partner req) {
		List<BasicRes> res =  partnerService.editPartner(req);
		if (res.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		return ResponseEntity.ok(res);
	}

	// 複数条件で取引先を検索
	@PostMapping(value = "partner/multiSearch")
	public ResponseEntity<PartnerAllRes> multiSearch(@RequestBody MultiSearchPartnerReq req) {
		PartnerAllRes res = partnerService.multiSearch(req);
		return ResponseEntity.ok(res);
	}
	
	// 複数条件で顧客を検索（新規登録画面用)
	@PostMapping(value = "partner/customerSearch")
	public ResponseEntity<PartnerAllRes> customerSearch(@RequestBody CustomerSearchReq req) {
		PartnerAllRes res = partnerService.searchCustomer(req);
		return ResponseEntity.ok(res);
	}
}
