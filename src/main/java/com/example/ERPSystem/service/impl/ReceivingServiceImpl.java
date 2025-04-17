package com.example.ERPSystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ERPSystem.contents.InvoiceStatus;
import com.example.ERPSystem.contents.ResMessage;
import com.example.ERPSystem.contents.StockStatus;
import com.example.ERPSystem.entity.PurchaseOrderInfo;
import com.example.ERPSystem.entity.Receiving;
import com.example.ERPSystem.entity.ReceivingDetails;
import com.example.ERPSystem.mapper.PODetailMapper;
import com.example.ERPSystem.mapper.ReceivingDetailMapper;
import com.example.ERPSystem.mapper.ReceivingMapper;
import com.example.ERPSystem.service.ifs.ReceivingService;
import com.example.ERPSystem.vo.AddReceivingReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.EditReceivingVO;
import com.example.ERPSystem.vo.GetReceivingRes;
import com.example.ERPSystem.vo.MultiSerachReceivingReq;
import com.example.ERPSystem.vo.ReceivingAllRes;
import com.example.ERPSystem.vo.ReceivingVO;

import jakarta.transaction.Transactional;

@Service
public class ReceivingServiceImpl implements ReceivingService {

	@Autowired
	private PODetailMapper poDetailMapper;

	@Autowired
	private ReceivingMapper receivingMapper;

	@Autowired
	private ReceivingDetailMapper receivingDateilMapper;

	/**
	 * 全ての入荷伝票データを取得
	 * 
	 * @return 全ての入荷データ
	 */
	@Override
	public ReceivingAllRes getAllReceiving() {

		List<Receiving> res = receivingMapper.getAllReceiving();
		return new ReceivingAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 指定した入荷伝票データを取得
	 * 
	 * @param receivingID 入荷伝票番号
	 * @return 1.指定した入荷伝票データ、2.成功・失敗メッセージ
	 */
	@Override
	public GetReceivingRes getReceiving(String receivingID) {
		
		// 主表データを取得
		Receiving receiving = receivingMapper.getReceiving(receivingID);
		// 明細データを取得
		List<ReceivingDetails> receivingDetailList = receivingDateilMapper.getReceivingDetails(receivingID);

		// レスポンス形式のVOを準備(ReceivingVO)
		ReceivingVO res = new ReceivingVO();

		// 各項目を設定
		res.setReceivingID(receiving.getReceivingID());
		res.setPurchaseOrderID(receiving.getPurchaseOrderID());
		res.setReceivingDate(receiving.getReceivingDate());
		res.setStatus(receiving.getStatus());
		res.setInspector(receiving.getInspector());
		res.setInspectionResult(receiving.getInspectionResult());
		res.setSupplierID(receiving.getSupplierID());
		res.setInvoiceStatus(receiving.getInvoiceStatus());
		res.setCreatedAt(receiving.getCreatedAt());
		res.setCreatedBy(receiving.getCreatedBy());
		res.setUpdatedAt(receiving.getUpdatedAt());
		res.setUpdatedBy(receiving.getUpdatedBy());
		res.setReceivingInfoList(receivingDetailList);

		return new GetReceivingRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 入荷伝票を新規作成
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> addReceiving(AddReceivingReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 入荷伝票番号がすでに存在するかをチェック
		int count = receivingMapper.selectReceivingIDCount(req.getReceivingID());
		if (count > 0) {
			checkRes.add(new BasicRes(ResMessage.PARAM_RECEIVING_ID_DUPLICATED.getCode(),
					ResMessage.PARAM_RECEIVING_ID_DUPLICATED.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() > 0) {
			return checkRes;
		}

		// 入荷伝票主表データを登録
		Receiving receiving = new Receiving();
		receiving.setReceivingID(req.getReceivingID());
		receiving.setPurchaseOrderID(req.getPurchaseOrderID());
		receiving.setReceivingDate(req.getReceivingDate());
		receiving.setStatus(req.getStatus());
		receiving.setInspector(req.getInspector());
		receiving.setInspectionResult(req.getInspectionResult());
		receiving.setSupplierID(req.getSupplierID());
		receiving.setInvoiceStatus(req.getInvoiceStatus());
		receiving.setCreatedAt(req.getCreatedAt());
		receiving.setCreatedBy(req.getCreatedBy());
		receiving.setUpdatedAt(req.getUpdatedAt());
		receiving.setUpdatedBy(req.getUpdatedBy());

		receivingMapper.insertReceiving(receiving);

		// 明細情報に入荷伝票番号を設定
		for (ReceivingDetails item : req.getReceivingInfoList()) {
			item.setReceivingID(req.getReceivingID());
		}

		// 明細データを登録（複数）
		receivingDateilMapper.insertReceivingDetail(req.getReceivingInfoList());
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));

		return checkRes;
	}

	/**
	 * 入荷伝票を編集
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> editReceiving(AddReceivingReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 入荷伝票番号に該当するデータが存在するか確認
		int count = receivingMapper.selectReceivingIDCount(req.getReceivingID());
		if (count != 1) {
			checkRes.add(new BasicRes(ResMessage.RECEIVING_NOT_FOUND.getCode(),
					ResMessage.RECEIVING_NOT_FOUND.getMessage()));
		}

		List<ReceivingDetails> receivingDetailList = req.getReceivingInfoList();

		// 明細内の入荷伝票番号と主表の入荷伝票番号が一致するかチェック
		for (ReceivingDetails item : receivingDetailList) {
			if (!req.getReceivingID().equalsIgnoreCase(item.getReceivingID())) {
				checkRes.add(new BasicRes(ResMessage.RECEIVING_ID_MISMATCH.getCode(),
						ResMessage.RECEIVING_ID_MISMATCH.getMessage()));
			}
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() > 0) {
			return checkRes;
		}

		// 主表データを更新
		EditReceivingVO receiving = new EditReceivingVO();
		receiving.setReceivingDate(req.getReceivingDate());
		receiving.setStatus(req.getStatus());
		receiving.setInspector(req.getInspector());
		receiving.setInspectionResult(req.getInspectionResult());
		receiving.setSupplierID(req.getSupplierID());
		receiving.setInvoiceStatus(req.getInvoiceStatus());
		receiving.setUpdatedAt(req.getUpdatedAt());
		receiving.setUpdatedBy(req.getUpdatedBy());
		receiving.setReceivingID(req.getReceivingID());

		receivingMapper.editReceiving(receiving);

		// 明細データを削除する
		receivingDateilMapper.deleteReceivingDetail(req.getReceivingID());

		// 明細データを再登録する
		receivingDateilMapper.insertReceivingDetail(receivingDetailList);
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
	public ReceivingAllRes multiSearch(MultiSerachReceivingReq req) {

		List<Receiving> res = receivingMapper.multiSearch(req);
		return new ReceivingAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 入荷伝票入力パラメータの検証
	 * 
	 * @param req 入力されたデータ
	 * @return エラーメッセージのリスト
	 */
	public List<BasicRes> checkParam(AddReceivingReq req) {

		List<BasicRes> errorMessage = new ArrayList<>();

		// 主表の入力値チェック
		// 1. 必須項目が空または null であってはならない
		if (!StringUtils.hasText(req.getReceivingID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_RECEIVING_ID_ERROR.getCode(),
					ResMessage.PARAM_RECEIVING_ID_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getPurchaseOrderID())) {
			errorMessage.add(
					new BasicRes(ResMessage.PARAM_PO_ID_ERROR.getCode(), ResMessage.PARAM_PO_ID_ERROR.getMessage()));
		}
		if (req.getReceivingDate() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_RECEIVING_DATE_ERROR.getCode(),
					ResMessage.PARAM_RECEIVING_DATE_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getStatus())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_RECEIVING_STATUS_ERROR.getCode(),
					ResMessage.PARAM_RECEIVING_STATUS_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getSupplierID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_SUPPLIER_ERROR.getCode(),
					ResMessage.PARAM_SUPPLIER_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getInvoiceStatus())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_INVOICE_STATUS_ERROR.getCode(),
					ResMessage.PARAM_INVOICE_STATUS_ERROR.getMessage()));
		}

		// 2. 請求書状態は3種類のいずれかに一致しなければならない
		if (!InvoiceStatus.checkStatus(req.getInvoiceStatus())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_INVOICE_STATUS_MISMATCH.getCode(),
					ResMessage.PARAM_INVOICE_STATUS_MISMATCH.getMessage()));
		}

		// 明細の入力値チェック
		List<ReceivingDetails> receivingDetailList = req.getReceivingInfoList();
		Set<String> detailIdSet = new HashSet<>();

		// 1. 明細の件数は購買注文書の明細件数と一致する必要がある
		List<PurchaseOrderInfo> poDetailList = poDetailMapper.getPOInfo(req.getPurchaseOrderID());

		if (receivingDetailList.size() != poDetailList.size()) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_RECEIVING_DETAIL_ERROR.getCode(),
					ResMessage.PARAM_RECEIVING_DETAIL_ERROR.getMessage()));
		}

		// 2. 必須項目は空または null であってはならない
		for (ReceivingDetails item : receivingDetailList) {
			if (!StringUtils.hasText(item.getReceivingDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_RECEIVING_DETAIL_ID_ERROR.getCode(),
						ResMessage.PARAM_RECEIVING_DETAIL_ID_ERROR.getMessage()));
			}
			if (!StringUtils.hasText(item.getMaterialID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_MATERIALID_ERROR.getCode(),
						ResMessage.PARAM_INFO_MATERIALID_ERROR.getMessage()));
			}

			// 3. 数値は0未満であってはならない
			if (item.getQuantityReceived() < 0) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_QUANTITY_RECEIVED_ERROR.getCode(),
						ResMessage.PARAM_QUANTITY_RECEIVED_ERROR.getMessage()));
			}

			if (item.getQuantityAccepted() < 0) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_QUANTITY_ACCEPTED_ERROR.getCode(),
						ResMessage.PARAM_QUANTITY_ACCEPTED_ERROR.getMessage()));
			}

			if (item.getQuantityRejected() < 0) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_QUANTITY_REJECTED_ERROR.getCode(),
						ResMessage.PARAM_QUANTITY_REJECTED_ERROR.getMessage()));
			}
			// 4. 合格数量と不合格数量の合計は実際受入数量と等しくなければならない
			if (item.getQuantityAccepted() + item.getQuantityRejected() != item.getQuantityReceived()) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_QUANTITY_ERROR.getCode(),
						ResMessage.PARAM_INFO_QUANTITY_ERROR.getMessage()));
			}

			// 5. 同じ入荷伝票内で明細番号は重複してはならない
			if (!detailIdSet.add(item.getReceivingDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_RECEIVING_DETAIL_ID_DUPLICATE.getCode(),
						ResMessage.PARAM_RECEIVING_DETAIL_ID_DUPLICATE.getMessage()));
			}

			// 6. 入荷状態は3種類のいずれかに一致しなければならない
			if (!StockStatus.checkStatus(item.getStockStatus())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_STOCK_STATUS_MISMATCH.getCode(),
						ResMessage.PARAM_STOCK_STATUS_MISMATCH.getMessage()));
			}
		}

		return errorMessage;
	}

}
