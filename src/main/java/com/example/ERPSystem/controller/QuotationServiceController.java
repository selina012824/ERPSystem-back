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
import com.example.ERPSystem.service.ifs.QuotationService;
import com.example.ERPSystem.vo.AddQuotationReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetQuotationRes;
import com.example.ERPSystem.vo.MultiSearchQuotationReq;
import com.example.ERPSystem.vo.QuotationAllRes;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class QuotationServiceController {

	@Autowired
	private QuotationService quotationService;

	/** 全見積書データ取得 */
	@GetMapping(value = "quotation/get_all_quotation")
	public ResponseEntity<QuotationAllRes> getAllQuotation() {

		QuotationAllRes res = quotationService.getAllQuotation();

		if (res.getQuotationList() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		return ResponseEntity.ok(res);
	}

	/** 指定見積書デー取得 */
	@PostMapping(value = "quotation/get__quotation")
	public ResponseEntity<GetQuotationRes> getQuotation(@RequestBody String req) {
		GetQuotationRes res = quotationService.getQuotation(req);

		if (res.getQuotation() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.ok(res);
	}

	/** 見積書新規作成 */
	@PostMapping(value = "quotation/add_quotation")
	public ResponseEntity<List<BasicRes>> addQuotation(@RequestBody AddQuotationReq req) {

		List<BasicRes> result = quotationService.addQuotation(req);

		if (result.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.ok(result);
	}

	/** 見積書編集 */
	@PostMapping(value = "quotation/edit_quotation")
	public ResponseEntity<List<BasicRes>> edutQuotation(@RequestBody AddQuotationReq req) {

		List<BasicRes> result = quotationService.editQuotation(req);
		if (result.get(0).getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}

		return ResponseEntity.ok(result);
	}

	/** 見積書条件検索 */
	@PostMapping(value = "quotation/multi_search")
	public ResponseEntity<QuotationAllRes> multiSearch(@RequestBody MultiSearchQuotationReq req) {

		QuotationAllRes res = quotationService.multipleSearch(req);
		return ResponseEntity.ok(res);
	}

	/** 注文作成 */
	@PostMapping(value = "quotation/set_order")
	public ResponseEntity<BasicRes> setOrder(@RequestBody String req) {

		BasicRes res = quotationService.setOrder(req);

		if (res.getCode() != ResMessage.SUCCESS.getCode()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}

		return ResponseEntity.ok(res);
	}
}
