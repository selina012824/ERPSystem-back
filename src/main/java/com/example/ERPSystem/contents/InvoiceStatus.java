package com.example.ERPSystem.contents;

public enum InvoiceStatus {

	NOT_ISSUED("未発行"), ISSUED("発行済"), RECONCILED("照合済");

	private String invoiceStatus;

	private InvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public static boolean checkStatus(String invoiceStatus) {
		for (InvoiceStatus item : InvoiceStatus.values()) {
			if (invoiceStatus.equalsIgnoreCase(item.getInvoiceStatus())) {
				return true;
			}
		}
		return false;
	}

}
