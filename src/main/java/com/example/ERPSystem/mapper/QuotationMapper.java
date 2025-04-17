package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.Quotation;
import com.example.ERPSystem.vo.EditQuotationVO;
import com.example.ERPSystem.vo.MultiSearchQuotationReq;

@Mapper
public interface QuotationMapper {

	// 全見積書データ取得
	List<Quotation> getAllQuotation();

	// 指定見積書データ取得
	Quotation getQuotation(@Param("quotationID") String quotationID);

	// 見積番号重複確認
	int selectQuotationIDCount(@Param("quotationID") String quotationID);

	// 見積書新規登録
	int insertQuotation(Quotation quotation);

	// 見積書編集
	int editQuotation(EditQuotationVO quotation);

	// 見積書条件検索
	List<Quotation> multiSearch(MultiSearchQuotationReq req);

	// 注文作成
	int setOrder(@Param("quotationID") String quotationID);
}