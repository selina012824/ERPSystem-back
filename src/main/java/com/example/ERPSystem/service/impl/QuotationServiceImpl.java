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
import com.example.ERPSystem.entity.Quotation;
import com.example.ERPSystem.entity.QuotationInfo;
import com.example.ERPSystem.mapper.QuotationDetailMapper;
import com.example.ERPSystem.mapper.QuotationMapper;
import com.example.ERPSystem.service.ifs.QuotationService;
import com.example.ERPSystem.vo.AddQuotationReq;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.EditQuotationVO;
import com.example.ERPSystem.vo.GetQuotationRes;
import com.example.ERPSystem.vo.MultiSearchQuotationReq;
import com.example.ERPSystem.vo.QuotationAllRes;
import com.example.ERPSystem.vo.QuotationVO;

import jakarta.transaction.Transactional;

@Service
public class QuotationServiceImpl implements QuotationService {

	@Autowired
	private QuotationMapper quotationMapper;

	@Autowired
	private QuotationDetailMapper quotationDetailMapper;

	/**
	 * 全ての見積書データを取得
	 * 
	 * @return 全ての見積書情報
	 */
	@Override
	public QuotationAllRes getAllQuotation() {
		List<Quotation> res = quotationMapper.getAllQuotation();
		return new QuotationAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 指定見積書データを取得
	 * 
	 * @param quotationID 見積番号
	 * @return 1.指定された見積書データ、2.成功・失敗メッセージ
	 */
	@Override
	public GetQuotationRes getQuotation(String quotationID) {

		// 主表データを取得
		Quotation quotation = quotationMapper.getQuotation(quotationID);
		// 明細データを取得
		List<QuotationInfo> quotationInfoList = quotationDetailMapper.getQuotationInfo(quotationID);

		// レスポンス形式のVOを準備(QuotationVO)
		QuotationVO res = new QuotationVO();

		// 各項目を設定
		res.setQuotationID(quotation.getQuotationID());
		res.setQuotationDate(quotation.getQuotationDate());
		res.setQuotationType(quotation.getQuotationType());
		res.setCustomerID(quotation.getCustomerID());
		res.setCustomerName(quotation.getCustomerName());
		res.setCustomerNickName(quotation.getCustomerNickName());
		res.setPersonInResponse(quotation.getPersonInResponse());
		res.setContactor(quotation.getContactor());
		res.setCustomerPhone(quotation.getCustomerPhone());
		res.setCustomerCellphone(quotation.getCustomerCellphone());
		res.setCustomerFaxNumber(quotation.getCustomerFaxNumber());
		res.setCustomerTaxNumber(quotation.getCustomerTaxNumber());
		res.setCustomerAddress(quotation.getCustomerAddress());
		res.setShipAddress(quotation.getShipAddress());
		res.setInvoiceAddress(quotation.getInvoiceAddress());
		res.setPayment(quotation.getPayment());
		res.setSubtotal(quotation.getSubtotal());
		res.setTax(quotation.getTax());
		res.setTotal(quotation.getTotal());
		res.setTotalAmount(quotation.getTotalAmount());
		res.setValidityPeriod(quotation.getValidityPeriod());
		res.setRemark(quotation.getRemark());
		res.setIfSetOrder(quotation.getIfSetOrder());
		res.setSetOrderTime(quotation.getSetOrderTime());
		res.setCreateAt(quotation.getCreateAt());
		res.setCreateClerkNm(quotation.getCreateClerkNm());
		res.setUpdateAt(quotation.getUpdateAt());
		res.setUpdateBy(quotation.getUpdateBy());
		res.setQuotationInfoList(quotationInfoList);

		return new GetQuotationRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 見積書を新規作成
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> addQuotation(AddQuotationReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 見積番号がすでに存在するかをチェック
		int count = quotationMapper.selectQuotationIDCount(req.getQuotationID());
		if (count != 0) {
			checkRes.add(new BasicRes(ResMessage.PARAM_QUOTATION_ID_DUPLICATED.getCode(),
					ResMessage.PARAM_QUOTATION_ID_DUPLICATED.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 見積書主表データを登録
		Quotation q = new Quotation();

		q.setQuotationID(req.getQuotationID());
		q.setQuotationDate(req.getQuotationDate());
		q.setQuotationType(req.getQuotationType());
		q.setCustomerID(req.getCustomerID());
		q.setCustomerName(req.getCustomerName());
		q.setCustomerNickName(req.getCustomerNickName());
		q.setPersonInResponse(req.getPersonInResponse());
		q.setContactor(req.getContactor());
		q.setCustomerPhone(req.getCustomerPhone());
		q.setCustomerCellphone(req.getCustomerCellphone());
		q.setCustomerFaxNumber(req.getCustomerFaxNumber());
		q.setCustomerTaxNumber(req.getCustomerTaxNumber());
		q.setCustomerAddress(req.getCustomerAddress());
		q.setShipAddress(req.getShipAddress());
		q.setInvoiceAddress(req.getInvoiceAddress());
		q.setPayment(req.getPayment());
		q.setSubtotal(req.getSubtotal());
		q.setTax(req.getTax());
		q.setTotal(req.getTotal());
		q.setTotalAmount(req.getTotalAmount());
		q.setValidityPeriod(req.getValidityPeriod());
		q.setRemark(req.getRemark());
		q.setIfSetOrder(req.getIfSetOrder());
		q.setSetOrderTime(req.getSetOrderTime());
		q.setCreateAt(req.getCreateAt());
		q.setCreateClerkNm(req.getCreateClerkNm());
		q.setUpdateAt(req.getUpdateAt());
		q.setUpdateBy(req.getUpdateBy());

		quotationMapper.insertQuotation(q);

		// 明細情報に見積番号・作成情報を設定
		for (QuotationInfo item : req.getQuotationInfoList()) {
			item.setQuotationID(req.getQuotationID());
			item.setCreateClerkNm(req.getCreateClerkNm());
			item.setCreateAt(req.getCreateAt());
		}

		// 明細データを登録（複数）
		quotationDetailMapper.insertQuotationInfoList(req.getQuotationInfoList());
		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));

		return checkRes;
	}

	/**
	 * 見積書を編集
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Transactional(rollbackOn = Exception.class)
	@Override
	public List<BasicRes> editQuotation(AddQuotationReq req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 見積番号に該当するデータが存在するか確認
		int count = quotationMapper.selectQuotationIDCount(req.getQuotationID());
		if (count < 1) {
			checkRes.add(new BasicRes(ResMessage.QUOTATION_NOT_FOUND.getCode(),
					ResMessage.QUOTATION_NOT_FOUND.getMessage()));
		}

		List<QuotationInfo> quotationInfoList = req.getQuotationInfoList();
		// 明細内の見積番号と主表の見積番号が一致するかチェック
		for (QuotationInfo item : quotationInfoList) {
			if (!req.getQuotationID().equalsIgnoreCase(item.getQuotationID())) {
				checkRes.add(new BasicRes(ResMessage.QUOTATION_ID_MISMATCH.getCode(),
						ResMessage.QUOTATION_ID_MISMATCH.getMessage()));
			}
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 主表データを更新
		EditQuotationVO quotation = new EditQuotationVO();

		quotation.setQuotationDate(req.getQuotationDate());
		quotation.setQuotationType(req.getQuotationType());
		quotation.setCustomerID(req.getCustomerID());
		quotation.setCustomerName(req.getCustomerName());
		quotation.setCustomerNickName(req.getCustomerNickName());
		quotation.setPersonInResponse(req.getPersonInResponse());
		quotation.setContactor(req.getContactor());
		quotation.setCustomerPhone(req.getCustomerPhone());
		quotation.setCustomerCellphone(req.getCustomerCellphone());
		quotation.setCustomerFaxNumber(req.getCustomerFaxNumber());
		quotation.setCustomerTaxNumber(req.getCustomerTaxNumber());
		quotation.setCustomerAddress(req.getCustomerAddress());
		quotation.setShipAddress(req.getShipAddress());
		quotation.setInvoiceAddress(req.getInvoiceAddress());
		quotation.setPayment(req.getPayment());
		quotation.setSubtotal(req.getSubtotal());
		quotation.setTax(req.getTax());
		quotation.setTotal(req.getTotal());
		quotation.setTotalAmount(req.getTotalAmount());
		quotation.setValidityPeriod(req.getValidityPeriod());
		quotation.setRemark(req.getRemark());
		quotation.setUpdateAt(req.getUpdateAt());
		quotation.setUpdateBy(req.getUpdateBy());
		quotation.setQuotationID(req.getQuotationID());

		quotationMapper.editQuotation(quotation);

		// 明細データを削除する
		quotationDetailMapper.deleteQuotationInfo(req.getQuotationID());

		// 明細データを再登録する
		quotationDetailMapper.insertQuotationInfoList(quotationInfoList);
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
	public QuotationAllRes multipleSearch(MultiSearchQuotationReq req) {

		List<Quotation> res = quotationMapper.multiSearch(req);
		return new QuotationAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);

	}

	/**
	 * 注文作成する
	 * 
	 * @param quotationID 見積番号
	 * @return 成功メッセージ
	 */
	@Override
	public BasicRes setOrder(String quotationID) {

		quotationMapper.setOrder(quotationID);
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());

	}

	/**
	 * 見積書入力パラメータの検証
	 * 
	 * @param req 入力されたデータ
	 * @return エラーメッセージのリスト
	 */
	public List<BasicRes> checkParam(AddQuotationReq req) {

		List<BasicRes> errorMessage = new ArrayList<>();

		// 主表の入力値チェック
		// 1. 必須項目が空または null であってはならない
		if (!StringUtils.hasText(req.getQuotationID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_ID_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_ID_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getQuotationType())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_TYPE_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_TYPE_ERROR.getMessage()));
		}

		if (req.getQuotationDate() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_DATE_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_DATE_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getCustomerID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CUSTOMER_ID_ERROR.getCode(),
					ResMessage.PARAM_CUSTOMER_ID_ERROR.getMessage()));
		}
		if (req.getSubtotal() == null || req.getSubtotal().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_Quotation_SUBTOTAL_ERROR.getCode(),
					ResMessage.PARAM_Quotation_SUBTOTAL_ERROR.getMessage()));
		}
		if (req.getTax() == null || req.getTax().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage
					.add(new BasicRes(ResMessage.PARAM_TAX_ERROR.getCode(), ResMessage.PARAM_TAX_ERROR.getMessage()));
		}
		if (req.getTotal() == null || req.getTotal().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_TOTALAMOUNT_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_TOTALAMOUNT_ERROR.getMessage()));
		}
		if (req.getTotalAmount() == null || req.getTotalAmount().compareTo(BigDecimal.ZERO) < 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_TOTALAMOUNT_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_TOTALAMOUNT_ERROR.getMessage()));
		}
		if (req.getValidityPeriod() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_VALID_DATE_ERROR.getCode(),
					ResMessage.PARAM_VALID_DATE_ERROR.getMessage()));
		}
		if (req.getCreateAt() == null) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_CREATE_TIME_ERROR.getCode(),
					ResMessage.PARAM_CREATE_TIME_ERROR.getMessage()));
		}

		if (!StringUtils.hasText(req.getCreateClerkNm())) {
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

		// 2. 有効期限は見積日より前であってはならない
		if (req.getQuotationDate().isAfter(req.getValidityPeriod())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_DATE_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_DATE_ERROR.getMessage()));
		}

		// 明細の入力値チェック
		List<QuotationInfo> quotationInfoList = req.getQuotationInfoList();
		Set<String> detailIdSet = new HashSet<>();

		// 1. 明細は最低1件以上必要
		if (quotationInfoList.size() <= 0) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_INFO_ERROR.getCode(),
					ResMessage.PARAM_QUOTATION_INFO_ERROR.getMessage()));
		}

		for (QuotationInfo item : quotationInfoList) {
			// 2. 必須項目は空または null であってはならない
			if (!StringUtils.hasText(item.getQuotationDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_INFO_ID_ERROR.getCode(),
						ResMessage.PARAM_QUOTATION_INFO_ID_ERROR.getMessage()));
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

			// 4. 同一見積書内の明細番号は重複してはいけない
			if (!detailIdSet.add(item.getQuotationDetailID())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_QUOTATION_INFO_ID_DUPLICATED.getCode(),
						ResMessage.PARAM_QUOTATION_INFO_ID_DUPLICATED.getMessage()));
			}

			// 5. 加工種類は定義された6種類のいずれかである必要がある
			if (!ProcessingType.checkType(item.getProcessingType())) {
				errorMessage.add(new BasicRes(ResMessage.PARAM_INFO_PROCESSINGTYPE_MISMATCH.getCode(),
						ResMessage.PARAM_INFO_PROCESSINGTYPE_MISMATCH.getMessage()));
			}

		}

		return errorMessage;

	}

}
