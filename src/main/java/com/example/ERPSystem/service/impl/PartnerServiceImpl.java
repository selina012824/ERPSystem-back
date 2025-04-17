package com.example.ERPSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ERPSystem.contents.ResMessage;
import com.example.ERPSystem.entity.Partner;
import com.example.ERPSystem.mapper.PartnerMapper;
import com.example.ERPSystem.service.ifs.PartnerService;
import com.example.ERPSystem.vo.BasicRes;
import com.example.ERPSystem.vo.CustomerSearchReq;
import com.example.ERPSystem.vo.EditPartnerVO;
import com.example.ERPSystem.vo.GetPartnerRes;
import com.example.ERPSystem.vo.MultiSearchPartnerReq;
import com.example.ERPSystem.vo.PartnerAllRes;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerMapper partnerMapper;

	/**
	 * すべての取引先情報を取得
	 * 
	 * @return すべての取引先情報
	 */
	@Override
	public PartnerAllRes getAllPartner() {

		List<Partner> res = partnerMapper.getAllPartner();
		return new PartnerAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 指定された取引先情報を取得
	 * 
	 * @Param partnerID 取引先番号
	 * @return 指定された取引先情報
	 */
	@Override
	public GetPartnerRes getPartner(String partnerID) {

		Partner res = partnerMapper.getPartner(partnerID);
		return new GetPartnerRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 取引先を新規登録
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Override
	public List<BasicRes> addPartner(Partner req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 取引先番号がすでに存在するかをチェック
		int count = partnerMapper.selectPartnerIDCount(req.getPartnerID());
		if (count > 0) {
			checkRes.add(new BasicRes(ResMessage.PARAM_PARTNER_ID_DUPLICATED.getCode(),
					ResMessage.PARAM_PARTNER_ID_DUPLICATED.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() > 0) {
			return checkRes;
		}

		// 取引先データを登録
		partnerMapper.insertPartner(req);

		checkRes.add(new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage()));
		return checkRes;
	}

	/**
	 * 取引先情報を編集
	 * 
	 * @param req 入力されたデータ
	 * @return 成功またはエラーメッセージのリスト
	 */
	@Override
	public List<BasicRes> editPartner(Partner req) {

		// 入力パラメータを検証
		List<BasicRes> checkRes = checkParam(req);

		// 取引先番号に該当するデータが存在するか確認
		int count = partnerMapper.selectPartnerIDCount(req.getPartnerID());
		if (count != 1) {
			checkRes.add(
					new BasicRes(ResMessage.PARTNER_NOT_FOUND.getCode(), ResMessage.PARTNER_NOT_FOUND.getMessage()));
		}

		// エラーがある場合、処理を中止してメッセージを返す
		if (checkRes.size() != 0) {
			return checkRes;
		}

		// 取引先情報を更新
		EditPartnerVO partner = new EditPartnerVO();

		partner.setPartnerType(req.getPartnerType());
		partner.setPartnerName(req.getPartnerName());
		partner.setPartnerNickName(req.getPartnerNickName());
		partner.setInResponse(req.getInResponse());
		partner.setContactor(req.getContactor());
		partner.setPhone(req.getPhone());
		partner.setCellphone(req.getCellphone());
		partner.setFaxNumber(req.getFaxNumber());
		partner.setTaxNumber(req.getTaxNumber());
		partner.setAddress(req.getAddress());
		partner.setShipAddress(req.getShipAddress());
		partner.setInvoiceAddress(req.getInvoiceAddress());
		partner.setPayment(req.getPayment());
		partner.setRemark(req.getRemark());
		partner.setUpdatedAt(req.getUpdatedAt());
		partner.setUpdatedBy(req.getUpdatedBy());
		partner.setPartnerID(req.getPartnerID());

		partnerMapper.editPartner(partner);
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
	public PartnerAllRes multiSearch(MultiSearchPartnerReq req) {
		List<Partner> res = partnerMapper.multiSerach(req);
		return new PartnerAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 複数条件で取引先を検索（新規登録画面用）
	 * 
	 * @param req 検索条件
	 * @return 検索結果
	 */
	@Override
	public PartnerAllRes searchCustomer(CustomerSearchReq req) {
		List<Partner> res = partnerMapper.searchCustomer(req);
		return new PartnerAllRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
	}

	/**
	 * 取引先入力パラメータの検証
	 * 
	 * @param req 入力されたデータ
	 * @return エラーメッセージのリスト
	 */
	public List<BasicRes> checkParam(Partner req) {

		List<BasicRes> errorMessage = new ArrayList<>();

		// 必填選項不可為空值或null
		if (!StringUtils.hasText(req.getPartnerID())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_ID_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_ID_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getPartnerType())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_TYPE_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_TYPE_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getPartnerName())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_NAME_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_NAME_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getInResponse())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_IN_RESPONSE_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_IN_RESPONSE_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getContactor())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_CONTACTOR_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_CONTACTOR_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getPhone())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_PHONE_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_PHONE_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getCellphone())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_CELLPHONE_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_CELLPHONE_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getAddress())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_PARTNER_ADDRESS_ERROR.getCode(),
					ResMessage.PARAM_PARTNER_ADDRESS_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getShipAddress())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_SHIP_ADDRESS_ERROR.getCode(),
					ResMessage.PARAM_SHIP_ADDRESS_ERROR.getMessage()));
		}
		if (!StringUtils.hasText(req.getInvoiceAddress())) {
			errorMessage.add(new BasicRes(ResMessage.PARAM_INVOICE_ADDRESS_ERROR.getCode(),
					ResMessage.PARAM_INVOICE_ADDRESS_ERROR.getMessage()));
		}

		return errorMessage;
	}

}
