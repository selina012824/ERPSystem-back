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
import com.example.ERPSystem.entity.PurchaseOrderInfo;
import com.example.ERPSystem.entity.PurchaseOrders;
import com.example.ERPSystem.mapper.PODetailMapper;
import com.example.ERPSystem.mapper.POMapper;
import com.example.ERPSystem.service.ifs.PurchaseOrderService;
import com.example.ERPSystem.vo.AddPoReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.EditPoVO;
import com.example.ERPSystem.vo.GetPORes;
import com.example.ERPSystem.vo.MultiSearchPOReq;
import com.example.ERPSystem.vo.PurchaseOrderAllRes;
import com.example.ERPSystem.vo.PurchaseOrderVO;

import jakarta.transaction.Transactional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private POMapper poMapper;

	@Autowired
	private PODetailMapper poDetailMapper;

	/**
	 * 全ての購買注文データを取得
	 * 
	 * @return 全ての購買注文データ
	 */
	@Override
	public PurchaseOrderAllRes getAllPO() {

		List<PurchaseOrders> res = poMapper.getAllPO();
		return new PurchaseOrderAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 指定された購買注文データを取得
	 * 
	 * @param purchaseOrderID 購買注文番号
	 * @return 1.指定された購買注文データ、2.成功・失敗メッセージ
	 */
	@Override
	public GetPORes getPO(String purchaseOrderID) {
		// 主表データを取得
		PurchaseOrders purchaseOrder = poMapper.getPO(purchaseOrderID);
		
		// 明細データを取得
		List<PurchaseOrderInfo> poInfoList = poDetailMapper.getPOInfo(purchaseOrderID);
		
		// レスポンス形式のVOを準備(PurchaseOrderVO)
		PurchaseOrderVO res = new PurchaseOrderVO();

		// 各項目を設定
		res.setPurchaseOrderID(purchaseOrder.getPurchaseOrderID());
		res.setOrderID(purchaseOrder.getOrderID());
		res.setSupplierID(purchaseOrder.getSupplierID());
		res.setOrderDate(purchaseOrder.getOrderDate());
		res.setDeliveryDate(purchaseOrder.getDeliveryDate());
		res.setStatus(purchaseOrder.getStatus());
		res.setIsApproved(purchaseOrder.getIsApproved());
		res.setApprovedBy(purchaseOrder.getApprovedBy());
		res.setApprovedAt(purchaseOrder.getApprovedAt());
		res.setSubtotal(purchaseOrder.getSubtotal());
		res.setTax(purchaseOrder.getTax());
		res.setTotalAmount(purchaseOrder.getTotalAmount());
		res.setCreateAt(purchaseOrder.getCreateAt());
		res.setCreateBy(purchaseOrder.getCreateBy());
		res.setUpdateAt(purchaseOrder.getUpdateAt());
		res.setUpdateBy(purchaseOrder.getUpdateBy());
		res.setPoInfoList(poInfoList);

		return new GetPORes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 購買注文書を新規作成
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> addPO(AddPoReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 購買注文番号がすでに存在するかをチェック
		int count = poMapper.selectPOIDCount(req.getPurchaseOrderID());
		if (count > 0) {
			checkRes.add(new BasicRes(ResMessage.PARAM_PO_ID_DUPLICATED.getCode(),
					ResMessage.PARAM_PO_ID_DUPLICATED.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 明細情報に購買注文番号・作成情報を設定
		for (PurchaseOrderInfo item : req.getPoInfoList()) {
			item.setPurchaseOrderID(req.getPurchaseOrderID());
			item.setCreateAt(req.getCreateAt());
			item.setCreateClerkNm(req.getCreateBy());
			item.setUpdateAt(req.getUpdateAt());
			item.setUpdateBy(req.getUpdateBy());
		}

		// 購買注文主表データを登録
		PurchaseOrders po = new PurchaseOrders();
		po.setPurchaseOrderID(req.getPurchaseOrderID());
		po.setOrderID(req.getOrderID());
		po.setSupplierID(req.getSupplierID());
		po.setOrderDate(req.getOrderDate());
		po.setDeliveryDate(req.getDeliveryDate());
		po.setStatus(req.getStatus());
		po.setIsApproved(req.getIsApproved());
		po.setApprovedBy(req.getApprovedBy());
		po.setApprovedAt(req.getApprovedAt());
		po.setSubtotal(req.getSubtotal());
		po.setTax(req.getTax());
		po.setTotalAmount(req.getTotalAmount());
		po.setCreateAt(req.getCreateAt());
		po.setCreateBy(req.getCreateBy());
		po.setUpdateAt(req.getUpdateAt());
		po.setUpdateBy(req.getUpdateBy());

		poMapper.insertPO(po);

		// 明細データを登録（複数）
		poDetailMapper.insertPOInfoList(req.getPoInfoList());
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));
		return checkRes;
	}

	/**
	 * 購買注文書を編集
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> editPO(AddPoReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 購買注文番号に該当するデータが存在するか確認
		int count = poMapper.selectPOIDCount(req.getPurchaseOrderID());
		if (count != 1) {
			checkRes.add(new BasicRes(ResMessage.PURCHASE_ORDER_NOT_FOUND.getCode(),
					ResMessage.PURCHASE_ORDER_NOT_FOUND.getMessage()));
		}

		List<PurchaseOrderInfo> poInfoList = req.getPoInfoList();
		// 明細内の購買注文番号と主表の購買注文番号が一致するかチェック
		for (PurchaseOrderInfo item : poInfoList) {
			if (!req.getPurchaseOrderID().equalsIgnoreCase(item.getPurchaseOrderID())) {
				checkRes.add(new BasicRes(ResMessage.PURCHASE_ORDER_ID_MISMATCH.getCode(),
						ResMessage.PURCHASE_ORDER_ID_MISMATCH.getMessage()));
			}
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 主表データを更新
		EditPoVO po = new EditPoVO();
		po.setOrderID(req.getOrderID());
		po.setSupplierID(req.getSupplierID());
		po.setOrderDate(req.getOrderDate());
		po.setDeliveryDate(req.getDeliveryDate());
		po.setStatus(req.getStatus());
		po.setIsApproved(req.getIsApproved());
		po.setApprovedBy(req.getApprovedBy());
		po.setApprovedAt(req.getApprovedAt());
		po.setSubtotal(req.getSubtotal());
		po.setTax(req.getTax());
		po.setTotalAmount(req.getTotalAmount());
		po.setUpdateAt(req.getUpdateAt());
		po.setUpdateBy(req.getUpdateBy());
		po.setPurchaseOrderID(req.getPurchaseOrderID());

		poMapper.editPO(po);

		// 明細データを削除する
		poDetailMapper.deletePOInfo(req.getPurchaseOrderID());

		// 明細データを再登録する
		poDetailMapper.insertPOInfoList(poInfoList);
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
	public PurchaseOrderAllRes mulitiSearch(MultiSearchPOReq req) {
		List<PurchaseOrders> res = poMapper.multiSearch(req);
		return new PurchaseOrderAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 購買注文番号一覧取得
	 * 
	 * @return 全ての購買注文番号
	 */
	@Override
	public List<String> getAllPOID() {
		List<String> res = poMapper.getPOID();
		return res;
	}

	/**
	 * 注文入力パラメータの検証
	 * 
	 * @param req 入力されたデータ
	 * @return エラーメッセージのリスト
	 */
	public List<BasicRes> checkParam(AddPoReq req) {

		List<BasicRes> errorMessage = new ArrayList<>();

		// 主表の入力値チェック
		// 1. 必須項目が空または null であってはならない
		if (!StringUtils.hasText(req.getPurchaseOrderID())) {
			errorMessage.add(
					new BasicRes(ResMessage.PARAM_PO_ID_ERROR.getCode(), ResMessage.PARAM_PO_ID_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getSupplierID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_SUPPLIER_ERROR.getCode(),
					ResMessage.PARAM_SUPPLIER_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getStatus())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PO_STATUS_ERROR.getCode(),
					ResMessage.PARAM_PO_STATUS_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getIsApproved())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_IS_APPROVED_ERROR.getCode(),
					ResMessage.PARAM_IS_APPROVED_ERROR.getMessage()));
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

		// 2.納期は発注日より前であってはならない
		if (req.getOrderDate().isAfter(req.getDeliveryDate())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_ORDER_DATE_ERROR.getCode(),
					ResMessage.PARAM_ORDER_DATE_ERROR.getMessage()));
		}

		// 明細の入力値チェック
		List<PurchaseOrderInfo> poInfoList = req.getPoInfoList();
		Set<String> detailIdSet = new HashSet<>();

		// 1. 明細は最低1件以上必要
		if (poInfoList.size() <= 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PO_INFO_ERROR.getCode(),
					ResMessage.PARAM_PO_INFO_ERROR.getMessage()));
		}

		for (PurchaseOrderInfo item : poInfoList) {
			// 2. 必須項目は空または null であってはならない
			if (!StringUtils.hasText(item.getPoDetailID())) {
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
			// 4.同一購買注文内で明細番号が重複してはならない
			if (!detailIdSet.add(item.getPoDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_PO_INFO_ID_DUPLICATED.getCode(),
						ResMessage.PARAM_PO_INFO_ID_DUPLICATED.getMessage()));
			}

			// 5.加工種別は定義された6種類のいずれかでなければならない
			if (!ProcessingType.checkType(item.getProcessingType())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_PROCESSINGTYPE_MISMATCH.getCode(),
						ResMessage.PARAM_INFO_PROCESSINGTYPE_MISMATCH.getMessage()));
			}

		}
		return errorMessage;
	}

}
