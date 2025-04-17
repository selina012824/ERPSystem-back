package com.example.ERPSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ERPSystem.entity.OrderInfo;
import com.example.ERPSystem.entity.OrderInfoID;

import jakarta.transaction.Transactional;

@Repository
public interface OrderInfoDao extends JpaRepository<OrderInfo, OrderInfoID> {

	// 獲取單張訂單明細資料
	@Query(value = "select * from order_info where order_id=?1 ", nativeQuery = true)
	public List<OrderInfo> getOrderInfo(String orderID);
	
	
	// 刪除訂單明細
	@Transactional
	@Modifying
	@Query(value = "delete from order_info where order_id=?1", nativeQuery = true)
	public int deleteOrderInfo(String orderID);
	
	// 獲取勾選明細資料
	@Query(value = "select * from order_info where order_id=?1 and order_detail_id in (?2)" , nativeQuery = true )
    public List<OrderInfo> getSelectOrderInfo(String orderID, List<String> orderInfoList);
}
