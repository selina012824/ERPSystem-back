package com.example.ERPSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ERPSystem.entity.Order;
import com.example.ERPSystem.vo.EditOrderVO;
import com.example.ERPSystem.vo.MultiSearchOrderReq;

@Mapper
public interface OrderMapper {

	// 注文一覧取得
	public List<Order> getAllOrder();

	// 指定注文取得
	public Order getOrder(@Param("orderID") String orderID);

	// 注文番号の重複チェック
	public int selectOrderIDCount(@Param("orderID") String orderID);

	// 注文新規作成
	public int insertOrder(Order order);

	// 注文編集
	public int editOrder(EditOrderVO order);

	// 注文条件検索
	public List<Order> multiSearch(MultiSearchOrderReq req);

	// 注文中止
	public int endOrder(@Param("orderID") String orderID);

	// 注文完了
	public int finishOrder(@Param("orderID") String orderID);

	// 購買注文作成
	public int setPO(@Param("orderID") String orderID);

	// 注文番号一覧取得
	public List<String> getOrderID();

}
