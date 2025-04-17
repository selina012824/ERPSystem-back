package com.example.ERPSystem.service.ifs;

import java.util.List;

import com.example.ERPSystem.vo.AddReceivingReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetReceivingRes;
import com.example.ERPSystem.vo.MultiSerachReceivingReq;
import com.example.ERPSystem.vo.ReceivingAllRes;

public interface ReceivingService {
	
	// 全ての入荷伝票データを取得
	public ReceivingAllRes getAllReceiving();

	// 指定した入荷伝票データを取得
	public GetReceivingRes getReceiving(String receivingID);

	// 入荷伝票を新規作成
	public List<BasicRes> addReceiving(AddReceivingReq req);

	// 入荷伝票を編集
	public List<BasicRes> editReceiving(AddReceivingReq req);

	// 複数条件で入荷伝票を検索
	public ReceivingAllRes multiSearch(MultiSerachReceivingReq req);

}
