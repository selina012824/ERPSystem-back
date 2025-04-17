package com.example.ERPSystem.contents;

// 加工種類
public enum ProcessingType {

	PANEL("ステンレス板材"), POLE("ステンレス丸棒"), TUBE("ステンレスパイプ"), PANELCUT("ステンレス一枚切断"), ANGLEIRON("ステンレスアングル"),
	CHANNELIRON("ステンレスチャンネル");

	private String type;

	private ProcessingType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static boolean checkType(String type) {
		for (ProcessingType item : ProcessingType.values()) {
			if (type.equalsIgnoreCase(item.getType())) {
				return true;
			}
		}
		return false;
	}

}
