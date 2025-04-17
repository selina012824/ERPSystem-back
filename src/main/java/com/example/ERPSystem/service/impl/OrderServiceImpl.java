package com.example.ERPSystem.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ERPSystem.contents.ProcessingType;
import com.example.ERPSystem.contents.ResMessage;
import com.example.ERPSystem.entity.Order;
import com.example.ERPSystem.entity.OrderInfo;
import com.example.ERPSystem.mapper.OrderDetailMapper;
import com.example.ERPSystem.mapper.OrderMapper;
import com.example.ERPSystem.service.ifs.OrderService;
import com.example.ERPSystem.vo.AddOrderReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.EditOrderVO;
import com.example.ERPSystem.vo.GetOrderRes;
import com.example.ERPSystem.vo.GetSelectOrderReq;
import com.example.ERPSystem.vo.MultiSearchOrderReq;
import com.example.ERPSystem.vo.OrderAllRes;
import com.example.ERPSystem.vo.OrderVO;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	/**
	 * 全ての注文データを取得
	 * 
	 * @return 全ての注文情報
	 */
	@Override
	public OrderAllRes getAllOrder() {

		List<Order> res = orderMapper.getAllOrder();
		return new OrderAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 指定注文データを取得
	 * 
	 * @param orderID 注文番号
	 * @return 指定注文データ
	 */
	@Override
	public GetOrderRes getOrder(String orderID) {

		// 主表データを取得
		Order order = orderMapper.getOrder(orderID);

		// 明細データを取得
		List<OrderInfo> orderInfo = orderDetailMapper.getOrderInfo(orderID);

		// レスポンス形式のVOを準備(OrderVO)
		OrderVO res = new OrderVO();

		// 各項目を設定
		res.setOrderID(order.getOrderID());
		res.setEstScrapID(order.getEstScrapID());
		res.setCustomerID(order.getCustomerID());
		res.setOrderDate(order.getOrderDate());
		res.setDeliveryDate(order.getDeliveryDate());
		res.setStatus(order.getStatus());
		res.setSubtotal(order.getSubtotal());
		res.setTax(order.getTax());
		res.setTotalAmount(order.getTotalAmount());
		res.setPayment(order.getPayment());
		res.setCreateAt(order.getCreateAt());
		res.setCreateBy(order.getCreateBy());
		res.setUpdateAt(order.getUpdateAt());
		res.setUpdateBy(order.getUpdateBy());
		res.setOrderInfoList(orderInfo);

		return new GetOrderRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);

	}

	/**
	 * 注文を新規作成
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> addOrder(AddOrderReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 注文番号がすでに存在するかをチェック
		int count = orderMapper.selectOrderIDCount(req.getOrderID());
		if (count > 0) {
			checkRes.add(new BasicRes(ResMessage.PARAM_ORDER__ID_DUPLICATED.getCode(),
					ResMessage.PARAM_ORDER__ID_DUPLICATED.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 明細情報に注文番号・作成情報を設定
		for (OrderInfo item : req.getOrderInfoList()) {
			item.setOrderID(req.getOrderID());
			item.setCreateAt(req.getCreateAt());
			item.setCreateClerkNm(req.getCreateBy());
			item.setUpdateAt(req.getUpdateAt());
			item.setUpdateBy(req.getUpdateBy());
		}

		// 注文主表データを登録
		Order order = new Order();
		order.setOrderID(req.getOrderID());
		order.setEstScrapID(req.getEstScrapID());
		order.setCustomerID(req.getCustomerID());
		order.setOrderDate(req.getOrderDate());
		order.setDeliveryDate(req.getDeliveryDate());
		order.setStatus(req.getStatus());
		order.setSubtotal(req.getSubtotal());
		order.setTax(req.getTax());
		order.setTotalAmount(req.getTotalAmount());
		order.setPayment(req.getPayment());
		order.setCreateAt(req.getCreateAt());
		order.setCreateBy(req.getCreateBy());
		order.setUpdateAt(req.getUpdateAt());
		order.setUpdateBy(req.getUpdateBy());

		orderMapper.insertOrder(order);

		// 明細データを登録（複数）
		orderDetailMapper.insertOrderInfoList(req.getOrderInfoList());
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));
		return checkRes;
	}

	/**
	 * 注文を編集
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> editOrder(AddOrderReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 注文番号に該当するデータが存在するか確認
		int count = orderMapper.selectOrderIDCount(req.getOrderID());
		if (count < 1) {
			checkRes.add(new BasicRes(ResMessage.ORDER_NOT_FOUND.getCode(), ResMessage.ORDER_NOT_FOUND.getMessage()));
		}

		List<OrderInfo> orderInfoList = req.getOrderInfoList();
		// 明細内の注文番号と主表の注文番号が一致するかチェック
		for (OrderInfo item : orderInfoList) {
			if (!req.getOrderID().equalsIgnoreCase(item.getOrderID())) {
				checkRes.add(new BasicRes(ResMessage.ORDER_ID_MISMATCH.getCode(),
						ResMessage.ORDER_ID_MISMATCH.getMessage()));
			}
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 主表データを更新
		EditOrderVO order = new EditOrderVO();

		order.setCustomerID(req.getCustomerID());
		order.setOrderDate(req.getOrderDate());
		order.setDeliveryDate(req.getDeliveryDate());
		order.setSubtotal(req.getSubtotal());
		order.setTax(req.getTax());
		order.setTotalAmount(req.getTotalAmount());
		order.setPayment(req.getPayment());
		order.setUpdateAt(req.getUpdateAt());
		order.setUpdateBy(req.getUpdateBy());
		order.setOrderID(req.getOrderID());

		orderMapper.editOrder(order);

		// 明細データを削除する
		orderDetailMapper.deleteOrderInfo(req.getOrderID());

		// 明細データを再登録する
		orderDetailMapper.insertOrderInfoList(orderInfoList);
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));
		return checkRes;
	}

	/**
	 * 複数条件検索
	 * 
	 * @param req 検索条件
	 * @return 検索結果
	 */
	@Override
	public OrderAllRes multiSearch(MultiSearchOrderReq req) {

		List<Order> res = orderMapper.multiSearch(req);
		return new OrderAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 注文入力パラメータの検証
	 * 
	 * @param req 入力されたデータ
	 * @return エラーメッセージのリスト
	 */
	public List<BasicRes> checkParam(AddOrderReq req) {

		List<BasicRes> errorMessage = new ArrayList<>();

		// 主表の入力値チェック
		// 1. 必須項目が空または null であってはならない
		if (!StringUtils.hasText(req.getOrderID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_ID_ERROR.getCode(),
					ResMessage.PARAM_ORDER_ID_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getEstScrapID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ESTSCRAP_ID_ERROR.getCode(),
					ResMessage.PARAM_ESTSCRAP_ID_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getCustomerID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CUSTOMER_ID_ERROR.getCode(),
					ResMessage.PARAM_CUSTOMER_ID_ERROR.getMessage()));
		}

		if (req.getOrderDate() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_DATE_ERROR.getCode(),
					ResMessage.PARAM_ORDER_DATE_ERROR.getMessage()));
		}

		if (req.getDeliveryDate() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_DELIVERY_DATE_ERROR.getCode(),
					ResMessage.PARAM_DELIVERY_DATE_ERROR.getMessage()));
		}
		if (req.getSubtotal() == null || req.getSubtotal().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_SUBTOTAL_ERROR.getCode(),
					ResMessage.PARAM_ORDER_SUBTOTAL_ERROR.getMessage()));
		}
		if (req.getTax() == null || req.getTax().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage
					.add(new BasicRes(ResMessage.PARAM_TAX_ERROR.getCode(), ResMessage.PARAM_TAX_ERROR.getMessage()));
		}
		if (req.getTotalAmount() == null || req.getTotalAmount().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_TOTALAMOUNT_ERROR.getCode(),
					ResMessage.PARAM_ORDER_TOTALAMOUNT_ERROR.getMessage()));
		}

		if (req.getCreateAt() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CREATE_TIME_ERROR.getCode(),
					ResMessage.PARAM_CREATE_TIME_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getCreateBy())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CREATE_CLERK_ERROR.getCode(),
					ResMessage.PARAM_CREATE_CLERK_ERROR.getMessage()));
		}

		if (req.getUpdateAt() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_UPDATE_TIME_ERROR.getCode(),
					ResMessage.PARAM_UPDATE_TIME_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getUpdateBy())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_UPDATE_CLERK_ERROR.getCode(),
					ResMessage.PARAM_UPDATE_CLERK_ERROR.getMessage()));
		}

		// 2.納期は注文日より前であってはならない
		if (req.getOrderDate().isAfter(req.getDeliveryDate())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_DATE_ERROR.getCode(),
					ResMessage.PARAM_ORDER_DATE_ERROR.getMessage()));
		}

		// 明細の入力値チェック
		List<OrderInfo> orderInfoList = req.getOrderInfoList();
		Set<String> detailIdSet = new HashSet<>();

		// 1. 明細は最低1件以上必要
		if (orderInfoList.size() <= 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_INFO_ERROR.getCode(),
					ResMessage.PARAM_ORDER_INFO_ERROR.getMessage()));
		}

		for (OrderInfo item : orderInfoList) {
			// 2. 必須項目は空または null であってはならない
			if (!StringUtils.hasText(item.getOrderDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_INFO__ID_ERROR.getCode(),
						ResMessage.PARAM_ORDER_INFO__ID_ERROR.getMessage()));
			}
			if (!StringUtils.hasText(item.getMaterialID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_MATERIALID_ERROR.getCode(),
						ResMessage.PARAM_INFO_MATERIALID_ERROR.getMessage()));
			}
			if (!StringUtils.hasText(item.getProcessingType())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_PROCESSINGTYPE_ERROR.getCode(),
						ResMessage.PARAM_INFO_PROCESSINGTYPE_ERROR.getMessage()));
			}

			// 3. 数値は0未満であってはならない
			if (item.getQuantity() < 0) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_QUANTITY_ERROR.getCode(),
						ResMessage.PARAM_INFO_QUANTITY_ERROR.getMessage()));
			}

			if (item.getUnitPrice() == null || item.getUnitPrice().compareTo(BigDecimal.ZERO) < 0) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_UNITPRICE_ERROR.getCode(),
						ResMessage.PARAM_INFO_UNITPRICE_ERROR.getMessage()));
			}
			if (item.getSubtotal() == null || item.getSubtotal().compareTo(BigDecimal.ZERO) < 0) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_SUBTOTAL_ERROR.getCode(),
						ResMessage.PARAM_INFO_SUBTOTAL_ERROR.getMessage()));
			}

			if (item.getThickness() != null) {
				if (item.getThickness().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_THICKNESS_ERROR.getCode(),
							ResMessage.PARAM_INFO_THICKNESS_ERROR.getMessage()));
				}
			}

			if (item.getWidth() != null) {
				if (item.getWidth().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_WIDTH_ERROR.getCode(),
							ResMessage.PARAM_INFO_WIDTH_ERROR.getMessage()));
				}
			}

			if (item.getLength() != null) {
				if (item.getLength().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_LENGTH_ERROR.getCode(),
							ResMessage.PARAM_INFO_LENGTH_ERROR.getMessage()));
				}
			}

			if (item.getWeight() != null) {
				if (item.getWeight().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_WEIGHT_ERROR.getCode(),
							ResMessage.PARAM_INFO_WEIGHT_ERROR.getMessage()));
				}
			}

			if (item.getDiameter() != null) {
				if (item.getDiameter().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_DIAMETER_ERROR.getCode(),
							ResMessage.PARAM_INFO_DIAMETER_ERROR.getMessage()));
				}
			}

			if (item.getOuterDiameter() != null) {
				if (item.getOuterDiameter().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_OUTERDIAMETER_ERROR.getCode(),
							ResMessage.PARAM_INFO_OUTERDIAMETER_ERROR.getMessage()));
				}
			}

			if (item.getInnerThickness() != null) {
				if (item.getInnerThickness().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_INNER_THICKNESS_ERROR.getCode(),
							ResMessage.PARAM_INFO_INNER_THICKNESS_ERROR.getMessage()));
				}
			}

			if (item.getCuttingSize() != null) {
				if (item.getCuttingSize().compareTo(BigDecimal.ZERO) < 0) {
					errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_INNER_THICKNESS_ERROR.getCode(),
							ResMessage.PARAM_INFO_INNER_THICKNESS_ERROR.getMessage()));
				}
			}
			// 4.同一注文内で明細番号が重複してはならない
			if (!detailIdSet.add(item.getOrderDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_INFO__ID_DUPLICATED.getCode(),
						ResMessage.PARAM_ORDER_INFO__ID_DUPLICATED.getMessage()));
			}

			// 5.加工種別は定義された6種類のいずれかでなければならない
			if (!ProcessingType.checkType(item.getProcessingType())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_PROCESSINGTYPE_MISMATCH.getCode(),
						ResMessage.PARAM_INFO_PROCESSINGTYPE_MISMATCH.getMessage()));
			}

		}
		return errorMessage;
	}

	/**
	 * 注文中止
	 * 
	 * @param orderID 注文番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes endOrder(String orderID) {
		// 注文の状態を「中止」に更新
		orderMapper.endOrder(orderID);
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());

	}

	/**
	 * 注文復旧
	 * 
	 * @param orderID 注文番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes restoreOrder(String orderID) {

		// 元の注文状態を復元する
		// 1.注文番号が作業指示書に存在し、かつその状態が以下の場合：
		// (1.) 処理待ち → 作業中
		// (2.) 完了 → 作業完了
		// (3.) 作業中 → 再作業の有無を確認

		// 2.再作業指示が存在し、そのステータスが以下の場合：
		// (1.) 処理待ち・作業中 → 再作業中
		// (2.) 中止 → 再作業中止
		// (3.) 完了 → 再作業完了

		// 3.出荷伝票の有無（ここでは考慮しない）
		return null;
	}

	/**
	 * 注文完了
	 * 
	 * @param orderID 注文番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes finishOrder(String orderID) {
		// 出荷伝票の有無（ここでは考慮しない）
		// 注文の状態を「完了」に更新
		orderMapper.finishOrder(orderID);
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());

	}

	/**
	 * 注文情報および選択された明細データを取得
	 * 
	 * @param req 注文番号と選択された明細番号
	 * @return 注文情報および選択された明細データ
	 */
	@Override
	public GetOrderRes getSelectOrder(GetSelectOrderReq req) {

		// 主表データを取得
		Order order = orderMapper.getOrder(req.getOrderID());

		// 選択された明細データを取得
		List<OrderInfo> orderInfo = orderDetailMapper.getSelectOrderInfo(req.getOrderID(), req.getOrderInfoIDList());

		OrderVO res = new OrderVO();

		res.setOrderID(order.getOrderID());
		res.setEstScrapID(order.getEstScrapID());
		res.setCustomerID(order.getCustomerID());
		res.setOrderDate(order.getOrderDate());
		res.setDeliveryDate(order.getDeliveryDate());
		res.setStatus(order.getStatus());
		res.setSubtotal(order.getSubtotal());
		res.setTax(order.getTax());
		res.setTotalAmount(order.getTotalAmount());
		res.setPayment(order.getPayment());
		res.setCreateAt(order.getCreateAt());
		res.setCreateBy(order.getCreateBy());
		res.setUpdateAt(order.getUpdateAt());
		res.setUpdateBy(order.getUpdateBy());
		res.setOrderInfoList(orderInfo);

		return new GetOrderRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 注文番号一覧取得
	 * 
	 * @return 全ての注文番号
	 */
	@Override
	public List<String> getAllOrderID() {
		List<String> res = orderMapper.getOrderID();
		return res;
	}

	/**
	 * 購買注文作成
	 * 
	 * @param orderID 注文番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes setPO(String orderID) {
		orderMapper.setPO(orderID);
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

}
