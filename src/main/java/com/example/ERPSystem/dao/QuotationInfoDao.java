package com.example.ERPSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ERPSystem.entity.QuotationInfo;
import com.example.ERPSystem.entity.QuotationInfoID;

import jakarta.transaction.Transactional;

@Repository
public interface QuotationInfoDao extends JpaRepository<QuotationInfo, QuotationInfoID> {


	// 獲取單張報價單所有明細
	@Query(value = "select * from quotation_info where quotation_id=?1", nativeQuery = true)
	public List<QuotationInfo> getQuotationInfo(String quotationID);

	// 刪除報價單明細
	@Transactional
	@Modifying
	@Query(value = "delete from quotation_info where quotation_id=?1", nativeQuery = true)
	public int deleteQuotationInfo(String quotationID);
}
