package com.example.ERPSystem.contents;

public enum StockStatus {
	
	NOT_RECEIVED("未入荷"),PART_RECEIVED("一部入荷"),FULL_RECEIVED("入荷済み");
	
	private String stockStatus;

	private StockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getStockStatus() {
		return stockStatus;
	}
	
	public static boolean checkStatus(String stockStatus) {
		for (StockStatus item : StockStatus.values()) {
			if (stockStatus.equalsIgnoreCase(item.getStockStatus())) {
				return true;
			}
		}
		return false;
	}

}
