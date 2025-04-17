package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.PurchaseOrderInfo;

@Mapper
public interface PODetailMapper {

	// 指定された購買注文の明細取得
	public List<PurchaseOrderInfo> getPOInfo(@Param("purchaseOrderID") String purchaseOrderID);

	// 指定された購買注文の明細を削除
	public int deletePOInfo(@Param("purchaseOrderID") String purchaseOrderID);

	// 購買注文の明細を一括登録
	int insertPOInfoList(@Param("list") List<PurchaseOrderInfo> list);
}
