package com.example.ERPSystem.service.ifs;

import java.util.List;

import com.example.ERPSystem.vo.AddOrderReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.GetOrderRes;
import com.example.ERPSystem.vo.GetSelectOrderReq;
import com.example.ERPSystem.vo.MultiSearchOrderReq;
import com.example.ERPSystem.vo.OrderAllRes;

/**
 * 注文サービス
 */
public interface OrderService {

	// 全注文データ取得
	public OrderAllRes getAllOrder();

	// 注文新規作成
	public List<BasicRes> addOrder(AddOrderReq req);

	// 注文編集
	public List<BasicRes> editOrder(AddOrderReq req);

	// 指定注文データ取得
	public GetOrderRes getOrder(String orderID);

	// 注文条件検索
	public OrderAllRes multiSearch(MultiSearchOrderReq req);

	// 注文中止
	public BasicRes endOrder(String orderID);

	// 注文復旧
	public BasicRes restoreOrder(String orderID);

	// 注文完了
	public BasicRes finishOrder(String orderID);

	// 購買注文作成
	public BasicRes setPO(String orderID);

	// 選択の注文明細データ取得
	public GetOrderRes getSelectOrder(GetSelectOrderReq req);

	// 注文番号一覧取得
	public List<String> getAllOrderID();
}
