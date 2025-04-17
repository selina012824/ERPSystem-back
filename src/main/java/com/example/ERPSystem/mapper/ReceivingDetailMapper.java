package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.ReceivingDetails;

@Mapper
public interface ReceivingDetailMapper {

	// 指定された入荷伝票の明細を取得
	public List<ReceivingDetails> getReceivingDetails(@Param("receivingID") String receivingID);

	// 入荷伝票の明細を一括登録
	public int insertReceivingDetail(@Param("list") List<ReceivingDetails> list);

	// 指定された入荷伝票の明細を削除
	int deleteReceivingDetail(@Param("receivingID") String receivingID);
}
