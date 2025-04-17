package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.OrderInfo;

@Mapper
public interface OrderDetailMapper {

	// 指定された注文の明細取得
	public List<OrderInfo> getOrderInfo(@Param("orderID") String orderID);

	// 指定された注文の明細を削除
	public int deleteOrderInfo(@Param("orderID") String orderID);

	// 注文明細を一括登録
	int insertOrderInfoList(@Param("list") List<OrderInfo> list);

	// 選択の注文明細取得
	public List<OrderInfo> getSelectOrderInfo(@Param("orderID") String orderID,
			@Param("orderInfoList") List<String> orderInfoList);
}
