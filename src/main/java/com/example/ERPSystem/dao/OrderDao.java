package com.example.ERPSystem.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ERPSystem.entity.Order;

import jakarta.transaction.Transactional;

@Repository
public interface OrderDao extends JpaRepository<Order, String> {

	// 獲取所有訂單(主表only)資料
	@Query(value = "select * from orders ", nativeQuery = true)
	public List<Order> getAllOrder();

	// 獲取單張訂單資料
	@Query(value = "select * from orders where order_id=?1 ", nativeQuery = true)
	public Order getOrder(String orderID);

	// 計算同一訂單編號又同一預估廢料編號資料的筆數
	@Query(value = "select count(order_id) from orders where order_id=?1", nativeQuery = true)
	public int selectOrderIDCount(String orderID);

	// 編輯訂單
	@Transactional
	@Modifying
	@Query(value = "update orders set customer_id=?1, order_date=?2, delivery_date=?3, subtotal=?4, tax=?5, total_amount=?6,"
			+ "payment_terms=?7, update_at=?8, update_by=?9 where order_id=?10", nativeQuery = true)
	public int editOrder(String customerID, LocalDate orderDate, LocalDate deliveryDate, BigDecimal subtotal,
			BigDecimal tax, BigDecimal totalAmount, String payment, LocalDateTime updateAt, String updateBy,
			String orderID);


	// 多條件搜尋
	@Query(value = "select * from orders where order_id like %?1% and est_scrap_id like %?2% and customer_id like %?3%"
			+ " and status like %?4% and order_date >= ?5 and order_date <= ?6 and delivery_date >= ?7 and delivery_date <= ?8", nativeQuery = true)
	public List<Order> multiSearch(String orderID, String estScrapID, String customerID, String status,
			LocalDate orderStartDate, LocalDate orderEndDate, LocalDate deliveryStartDate, LocalDate deliveryEndDate);

	// 終止訂單
	@Transactional
	@Modifying
	@Query(value = "update orders set status='終止' where order_id=?1 ", nativeQuery = true)
	public int endOrder(String orderID);
	
	// 完成訂單
	@Transactional
	@Modifying
	@Query(value = "update orders set status='完成' where order_id=?1 ", nativeQuery = true)
	public int finishOrder(String orderID);
	
	// 獲取所有訂單編號
	@Query(value = "select order_id from orders", nativeQuery = true)
	public List<String> getOrderID();
}
