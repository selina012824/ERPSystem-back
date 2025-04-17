package com.example.ERPSystem.service.ifs;

import java.util.List;

import com.example.ERPSystem.entity.Partner;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.CustomerSearchReq;
import com.example.ERPSystem.vo.GetPartnerRes;
import com.example.ERPSystem.vo.MultiSearchPartnerReq;
import com.example.ERPSystem.vo.PartnerAllRes;

public interface PartnerService {

	// すべての取引先情報を取得
	public PartnerAllRes getAllPartner();

	// 指定された取引先情報を取得
	public GetPartnerRes getPartner(String partnerID);

	// 取引先を新規登録
	public List<BasicRes> addPartner(Partner partner);

	// 取引先情報を編集
	public List<BasicRes> editPartner(Partner partner);

	// 複数条件で取引先を検索
	public PartnerAllRes multiSearch(MultiSearchPartnerReq req);

	// 複数条件で顧客を検索（新規登録画面用）
	public PartnerAllRes searchCustomer(CustomerSearchReq req);
}
