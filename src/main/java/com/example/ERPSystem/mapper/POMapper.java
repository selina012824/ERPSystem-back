package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.PurchaseOrders;
import com.example.ERPSystem.vo.EditPoVO;
import com.example.ERPSystem.vo.MultiSearchPOReq;

@Mapper
public interface POMapper {

	// 全ての購買注文データを取得
	public List<PurchaseOrders> getAllPO();

	// 指定された購買注文データを取得
	public PurchaseOrders getPO(@Param("purchaseOrderID") String purchaseOrderID);

	// 購買注文番号の重複チェック
	public int selectPOIDCount(@Param("purchaseOrderID") String purchaseOrderID);

	// 購買注文を新規作成
	int insertPO(PurchaseOrders purchaseOrders);

	// 購買注文を編集
	public int editPO(EditPoVO purchaseOrders);

	// 購買注文条件検索
	public List<PurchaseOrders> multiSearch(MultiSearchPOReq req);

	// 購買注文番号一覧取得
	public List<String> getPOID();
}
