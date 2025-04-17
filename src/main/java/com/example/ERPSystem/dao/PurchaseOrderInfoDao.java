package com.example.ERPSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ERPSystem.entity.PurchaseOrderInfo;
import com.example.ERPSystem.entity.PurchaseOrderInfoID;

import jakarta.transaction.Transactional;

@Repository
public interface PurchaseOrderInfoDao extends JpaRepository<PurchaseOrderInfo, PurchaseOrderInfoID> {

	// 獲取單張採購單明細資料
	@Query(value = "select * from purchase_order_info where purchase_order_id=?1", nativeQuery = true)
	public List<PurchaseOrderInfo> getPOInfo(String purchaseOrderID);

	// 刪除採購單明細
	@Transactional
	@Modifying
	@Query(value = "delete from purchase_order_info where purchase_order_id=?1", nativeQuery = true)
	public int deletePOInfo(String purchaseOrderID);
};
