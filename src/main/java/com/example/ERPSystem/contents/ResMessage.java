package com.example.ERPSystem.contents;

public enum ResMessage {
	SUCCESS(200, "成功しました！"),
	PARAM_QUOTATION_ID_ERROR(400, "見積番号が未入力、または無効です。"),
	PARAM_QUOTATION_ID_DUPLICATED(400, "見積番号が重複しています。"),
	PARAM_QUOTATION_DATE_ERROR(400, "見積日が正しく入力されていません。"),
	PARAM_VALID_DATE_ERROR(400, "有効期限が正しく入力されていません。"),
	PARAM_QUOTATION_TYPE_ERROR(400, "見積元が未入力、または不正です。"),
	PARAM_CUSTOMER_ID_ERROR(400, "取引先が未入力、または不正です。"),
	PARAM_Quotation_SUBTOTAL_ERROR(400, "小計金額が不正です。"),
	PARAM_TAX_ERROR(400, "税額が不正です。"),
	PARAM_QUOTATION_TOTALAMOUNT_ERROR(400, "合計金額が不正です。"),
	PARAM_QUOTATION_INFO_ERROR(400, "見積明細の情報が不正です。"),
	PARAM_QUOTATION_INFO_ID_ERROR(400, "見積明細番号が不正です。"),
	PARAM_QUOTATION_INFO_ID_DUPLICATED(400, "見積明細番号が重複しています。"),
	QUOTATION_SET_ORDER_ERROR(400, "見積からの注文に失敗しました。"),
	
	PARAM_INFO_MATERIALID_ERROR(400, "材料IDが未入力です"),
	PARAM_INFO_PROCESSINGTYPE_ERROR(400, "加工種別が未入力です。"),
	PARAM_INFO_PROCESSINGTYPE_MISMATCH(400, "加工種別の内容が不正です"),
	PARAM_INFO_QUANTITY_ERROR(400, "数量が負の値、または未入力です。"),
	PARAM_INFO_UNITPRICE_ERROR(400, "単価が負の値、または未入力です。"),
	PARAM_INFO_SUBTOTAL_ERROR(400, "明細小計が負の値、または未入力です。"),
	PARAM_INFO_THICKNESS_ERROR(400, "厚さの値が不正です。"),
	PARAM_INFO_WIDTH_ERROR(400, "幅の値が不正です。"),
	PARAM_INFO_LENGTH_ERROR(400, "長さの値が不正です。"),
	PARAM_INFO_WEIGHT_ERROR(400, "重量の値が不正です。"),
	PARAM_INFO_DIAMETER_ERROR(400, "直径の値が不正です。"),
	PARAM_INFO_OUTERDIAMETER_ERROR(400, "外径の値が不正です。"),
	PARAM_INFO_INNER_THICKNESS_ERROR(400, "内径の値が不正です。"),
	PARAM_INFO_CUTTINGSIZE_ERROR(400, "カットサイズの値が不正です。"),
	
	QUOTATION_ID_MISMATCH(400, "見積番号が一致しません。"),
	QUOTATION_NOT_FOUND(404, "指定された見積書が見つかりません"),
	
	PARAM_ORDER_ID_ERROR(400, "注文IDが未入力です。"),
	PARAM_ORDER__ID_DUPLICATED(400, "注文IDが重複しています"),
	PARAM_ESTSCRAP_ID_ERROR(400, "予測廃材番号が未入力です。"),
	PARAM_ORDER_DATE_ERROR(400, "注文日が正しく入力されていません。"),
	PARAM_DELIVERY_DATE_ERROR(400, "納期が正しく入力されていません。"),
	PARAM_ORDER_SUBTOTAL_ERROR(400, "注文小計が不正です。"),
	PARAM_ORDER_TOTALAMOUNT_ERROR(400, "注文合計金額が不正です。"),
	PARAM_ORDER_INFO_ERROR(400, "注文明細の情報が不正です。"),
	PARAM_ORDER_INFO__ID_ERROR(400, "注文明細IDが未入力です。"),
	PARAM_ORDER_INFO__ID_DUPLICATED(400, "注文明細IDが重複しています"),
	END_ORDER_ERROR(400, "注文の中止処理に失敗しました。"),
	FINISH_ORDER_ERROR(400, "注文の完了処理に失敗しました。"),
	
	ORDER_NOT_FOUND(404, "指定された注文が見つかりません"),
	ORDER_ID_MISMATCH(400, "注文IDが一致しません"),
	
	PARAM_PO_ID_ERROR(400, "購買注文IDが未入力です。"),
	PARAM_SUPPLIER_ERROR(400, "仕入先が未入力です。"),
	PARAM_PO_STATUS_ERROR(400, "購買注文状態が未入力です。"),
	PARAM_IS_APPROVED_ERROR(400, "承認状況が未入力です。"),
	PARAM_PO_INFO_ERROR(400, "購買注文明細の情報が不正です。"),
	PARAM_PO_INFO_ID_DUPLICATED(400, "購買注文明細IDが重複しています"),
	PARAM_PO_ID_DUPLICATED(400, "購買注文IDが重複しています"),
	PURCHASE_ORDER_NOT_FOUND(404, "指定された購買注文が見つかりません"),
	PURCHASE_ORDER_ID_MISMATCH(400, "購買注文IDが一致しません。"),
	
	PARAM_RECEIVING_ID_ERROR(400, "入荷IDが未入力です。"),
	RECEIVING_ID_MISMATCH(400, "入荷IDが一致しません。"),
	PARAM_RECEIVING_ID_DUPLICATED(400, "入荷IDが重複しています。"),
	PARAM_RECEIVING_DATE_ERROR(400, "入荷日が正しく入力されていません。"),
	PARAM_RECEIVING_STATUS_ERROR(400, "入荷状態が未入力です。"),
	PARAM_INVOICE_STATUS_ERROR(400, "請求書状態が未入力です。"),
	PARAM_RECEIVING_DETAIL_ERROR(400, "入荷明細の情報が不足しています。"),
	PARAM_RECEIVING_DETAIL_ID_ERROR(400, "入荷明細IDが未入力です。"),
	PARAM_RECEIVING_DETAIL_ID_DUPLICATE(400, "入荷明細IDが重複しています。"),
	PARAM_QUANTITY_RECEIVED_ERROR(400, "実受入数量が不正です。"),
	PARAM_QUANTITY_ACCEPTED_ERROR(400, "合格数量が不正です。"),
	PARAM_QUANTITY_REJECTED_ERROR(400, "不合格数量が不正です。"),
	PARAM_STOCK_STATUS_MISMATCH(400, "在庫状態が無効です。"),
	PARAM_INVOICE_STATUS_MISMATCH(400, "請求状態が無効です。"),
	RECEIVING_NOT_FOUND(404, "指定された入荷伝票が見つかりません。"),
	
	PARAM_PARTNER_ID_ERROR(400,"取引先IDが未入力です。"),
	PARAM_PARTNER_ID_DUPLICATED(400,"取引先IDが重複しています。"),
	PARAM_PARTNER_TYPE_ERROR(400,"取引先種別が未入力です。"),
	PARAM_PARTNER_NAME_ERROR(400,"取引先名が未入力です。"),
	PARAM_PARTNER_IN_RESPONSE_ERROR(400,"責任者が未入力です。"),
	PARAM_PARTNER_CONTACTOR_ERROR(400,"担当者が未入力です。"),
	PARAM_PARTNER_PHONE_ERROR(400,"電話番号が未入力です。"),
	PARAM_PARTNER_CELLPHONE_ERROR(400,"携帯番号が未入力です。"),
	PARAM_PARTNER_ADDRESS_ERROR(400,"所在地が未入力です。"),
	PARAM_INVOICE_ADDRESS_ERROR(400,"請求先住所が未入力です。"),
	PARAM_SHIP_ADDRESS_ERROR(400,"納品先住所が未入力です。"),
	PARTNER_NOT_FOUND(404, "指定された取引先が見つかりません。"),
	
	PARAM_WORK_ORDER_ID_ERROR(400,"作業指示書IDが未入力です。"),
	PARAM_WORK_ORDER_ID_DUPLICATED(400,"作業指示書IDが重複しています。"),
	PARAM_WORK_ORDER_STATUS_ERROR(400,"作業指示書状態が未入力です。"),
	PARAM_WORK_ORDER_PLANNED_DATE_ERROR(400,"予定開始日が予定完了日より遅い日付になっています。"),
	PARAM_WORK_ORDER_ACTUAL_DATE_ERROR(400,"実際開始日が実際完了日より遅い日付になっています。"),
	WORK_ORDER_IS_CREATED(400,"この注文にはすでに作業指示書が作成されています。"),
	WORK_ORDER_NOT_FOUND(404, "指定された作業指示書が見つかりません。"),

	PARAM_CREATE_TIME_ERROR(400, "作成日時が未入力です。"),
	PARAM_CREATE_CLERK_ERROR(400, "作成者名が未入力です。"),
	PARAM_UPDATE_TIME_ERROR(400, "更新日時が未入力です。"),
	PARAM_UPDATE_CLERK_ERROR(400, "更新者名が未入力です。"),

	MULTI_SEARCH_ERROR(400, "条件検索でエラーが発生しました。"),
	DATA_SAVE_ERROR(400, "データの保存に失敗しました。"),
	DATA_COPY_ERROR(400, "データのコピーに失敗しました。");

	private int code;
	private String message;

	private ResMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
