package com.example.ERPSystem.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.ERPSystem.entity.Quotation;

import jakarta.transaction.Transactional;

@Repository
public interface QuotationDao extends JpaRepository<Quotation, String> {

	// 獲取所有報價單(主表only)資料
	@Query(value = "select * from quotation order by create_at desc", nativeQuery = true)
	public List<Quotation> getAllQuotation();

	// 獲取單張報價單
	@Query(value = "select * from quotation where quotation_id= ?1", nativeQuery = true)
	public Quotation getQuotation(String quotationID);

	// 計算同一報價單號數(不可重覆)
	@Query(value = "select count(quotation_id) from quotation where quotation_id= ?1 ", nativeQuery = true)
	public int selectQuotationIDCount(String quotationID);

	// 編輯報價單
	@Transactional
	@Modifying
	@Query(value = "update quotation set quotation_date=?1, quotation_type=?2,customer_id=?3,"
			+ " customer_name=?4, customer_nickname=?5, person_in_response=?6, contactor=?7, customer_phone=?8,"
			+ " customer_cellphone=?9, customer_faxnumber=?10, customer_taxnumber=?11, customer_address=?12,"
			+ " ship_address=?13, invoice_address=?14, payment=?15, subtotal=?16, tax=?17, total=?18, total_amount=?19,"
			+ " validity_period=?20, remark=?21, update_at=?22, update_by=?23 where quotation_id=?24", nativeQuery = true)
	public int editQuotation(LocalDate quotationDate, String quotationType, String customerID, String name,
			String nickname, String inResponse, String contactor, String phone, String cellPhone, String fax,
			String taxNum, String address, String shipAddress, String invoiceAdress, String payment,
			BigDecimal subTotal, BigDecimal tax, BigDecimal total, BigDecimal totalAmount, LocalDate validDate,
			String remark, LocalDateTime updateAt, String upadteClerk, String quotationID);

	// 模糊搜尋
	@Query(value = "select * from quotation where (quotation_id like %?1% or customer_id like %?1% or quotation_date like %?1%"
			+ " or validity_period like %?1% or total_amount like %?1%) and (?2 is null or quotation_type like %?2% )", nativeQuery = true)
	public List<Quotation> fuzzySearch(String inputText, String quotationType);

	// 多條件搜尋
	@Query(value = "select * from quotation where quotation_id like %?1% and customer_id like %?2% and quotation_type like %?3%"
			+ " and quotation_date >=?4 and quotation_date <=?5 and validity_period >=?6 and validity_period <=?7 order by create_at desc", nativeQuery = true)
	public List<Quotation> multiSearch(String quotationID, String customerID, String quotationType,
			LocalDate quotationStartDate, LocalDate quotationEndDate, LocalDate validStartDate, LocalDate validEndDate);
	
	//更改報價單成立訂單狀態
	@Transactional
	@Modifying
	@Query(value="update quotation set if_set_order='1' where quotation_id=?1", nativeQuery = true)
	public int setOrder(String quotationID);
}
