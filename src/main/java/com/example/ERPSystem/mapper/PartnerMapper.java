package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.Partner;
import com.example.ERPSystem.vo.CustomerSearchReq;
import com.example.ERPSystem.vo.EditPartnerVO;
import com.example.ERPSystem.vo.MultiSearchPartnerReq;

@Mapper
public interface PartnerMapper {
	
	// すべての取引先情報を取得
	public List<Partner> getAllPartner();

	// 指定された取引先情報を取得
	public Partner getPartner(@Param("partnerID") String partnerID);

	// 取引先番号の重複を確認
	public int selectPartnerIDCount(@Param("partnerID") String partnerID);

	// 取引先を新規追加
	public int insertPartner(Partner partner);

	// 取引先情報を編集
	public int editPartner(EditPartnerVO req);

	// 複数条件で取引先を検索
	public List<Partner> multiSerach(MultiSearchPartnerReq req);

	// 複数条件で顧客を検索（新規登録画面用）
	public List<Partner> searchCustomer(CustomerSearchReq req);

}
