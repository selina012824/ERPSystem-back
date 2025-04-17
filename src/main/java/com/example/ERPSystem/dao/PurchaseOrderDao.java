package com.example.ERPSystem.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ERPSystem.entity.PurchaseOrders;

import jakarta.transaction.Transactional;

@Repository
public interface PurchaseOrderDao extends JpaRepository<PurchaseOrders, String> {

	// 獲取所有採購單資料
	@Query(value = "select * from purchase_orders order by create_at desc", nativeQuery = true)
	public List<PurchaseOrders> getAllPO();

	// 獲取單張採購單資料
	@Query(value = "select * from purchase_orders where purchase_order_id=?1", nativeQuery = true)
	public PurchaseOrders getPO(String purchaseOrderID);

	// 計算同一採購單號數(不可重覆)
	@Query(value = "select count(purchase_order_id) from purchase_orders where purchase_order_id= ?1 ", nativeQuery = true)
	public int selectPOIDCount(String purchaseOrderID);

	// 編輯採購單
	@Transactional
	@Modifying
	@Query(value = "update purchase_orders set order_id=?1, supplier_id=?2, order_date=?3, delivery_date=?4, status=?5,"
			+ " is_approved=?6, approved_by=?7, approved_at=?8, subtotal=?9, tax=?10, total_amount=?11, update_at=?12, update_by=?13"
			+ " where purchase_order_id=?14", nativeQuery = true)
	public int editPO(String orderID, String supplierID, LocalDate orderDate, LocalDate deliveryDate, String status,
			String isApproved, String approvedBy, LocalDateTime approvedAt, BigDecimal subtotal, BigDecimal tax,
			BigDecimal totalAmount, LocalDateTime updateAt, String updateBy, String purchaseOrderID);


	// 多條件搜尋
	@Query(value = "select * from purchase_orders where purchase_order_id like %?1% and (order_id is null or order_id like %?2%) and supplier_id"
			+ " like %?3% and  status like %?4% and is_approved like %?5%  and order_date >= ?6 and order_date <= ?7"
			+ " and delivery_date >= ?8 and delivery_date <= ?9", nativeQuery = true)
	public List<PurchaseOrders> multiSearch(String purchaseOrderID, String orderID, String supplierID, String status,
			String isApproved, LocalDate orderStartDate, LocalDate orderEndDate, LocalDate deliveryStartDate,
			LocalDate deliveryEndDate);
}
