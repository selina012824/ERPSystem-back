package com.example.ERPSystem.service.ifs;

import java.util.List;

import com.example.ERPSystem.vo.AddQuotationReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetQuotationRes;
import com.example.ERPSystem.vo.MultiSearchQuotationReq;
import com.example.ERPSystem.vo.QuotationAllRes;

/**
 * 見積書サービス
 */
public interface QuotationService {

	// 全見積書取得
	public QuotationAllRes getAllQuotation();

	// 見積書新規作成
	public List<BasicRes> addQuotation(AddQuotationReq req);

	// 見積書編集
	public List<BasicRes> editQuotation(AddQuotationReq req);

	// 指定された見積書取得
	public GetQuotationRes getQuotation(String quotationID);

	// 見積書条件検索
	public QuotationAllRes multipleSearch(MultiSearchQuotationReq req);

	// 注文作成
	public BasicRes setOrder(String quotationID);
}