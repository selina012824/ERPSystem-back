package com.example.ERPSystem.service.ifs;

import java.util.List;

import com.example.ERPSystem.vo.AddPoReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetPORes;
import com.example.ERPSystem.vo.MultiSearchPOReq;
import com.example.ERPSystem.vo.PurchaseOrderAllRes;

public interface PurchaseOrderService {

	// 全ての購買注文データを取得
	public PurchaseOrderAllRes getAllPO();

	// 指定された購買注文データを取得
	public GetPORes getPO(String purchaseOrderID);

	// 購買注文新規作成
	public List<BasicRes> addPO(AddPoReq req);

	// 購買注文編集
	public List<BasicRes> editPO(AddPoReq req);

	// 購買注文条件検索
	public PurchaseOrderAllRes mulitiSearch(MultiSearchPOReq req);

	// 購買注文番号一覧取得
	public List<String> getAllPOID();
}
