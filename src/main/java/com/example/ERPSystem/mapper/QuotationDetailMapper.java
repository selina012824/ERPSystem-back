package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.QuotationInfo;

@Mapper
public interface QuotationDetailMapper {

	// 指定された見積書の明細を取得
	List<QuotationInfo> getQuotationInfo(@Param("quotationID") String quotationID);

	// 指定された見積書の明細を削除
	int deleteQuotationInfo(@Param("quotationID") String quotationID);

	// 見積明細を一括登録
	int insertQuotationInfoList(@Param("list") List<QuotationInfo> list);
}
