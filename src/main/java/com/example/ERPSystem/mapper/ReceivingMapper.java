package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.Receiving;
import com.example.ERPSystem.vo.EditReceivingVO;
import com.example.ERPSystem.vo.MultiSerachReceivingReq;

@Mapper
public interface ReceivingMapper {

	// 全ての入荷伝票データを取得
	public List<Receiving> getAllReceiving();
	
	// 指定した入荷伝票データを取得
	public Receiving getReceiving(@Param("receivingID") String receivingID);
	
	// 入荷伝票重複確認
	public int selectReceivingIDCount(@Param("receivingID") String receivingID);
	
	// 入荷伝票を新規作成
	public int insertReceiving(Receiving receiving);
	
	// 入荷伝票を編集
	public int editReceiving(EditReceivingVO receiving);
	
	// 複数条件で入荷伝票を検索
	public List<Receiving> multiSearch(MultiSerachReceivingReq req);
}