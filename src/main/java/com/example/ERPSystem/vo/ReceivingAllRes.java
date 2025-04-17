package com.example.ERPSystem.vo;

import java.util.List;

import com.example.ERPSystem.entity.Receiving;

public class ReceivingAllRes extends BasicRes {

	private List<Receiving> receivingList;

	public ReceivingAllRes() {
		super();
	}

	public ReceivingAllRes(int code, String message) {
		super(code, message);
	}

	public ReceivingAllRes(int code, String message, List<Receiving> receivingList) {
		super(code, message);
		this.receivingList = receivingList;
	}

	public ReceivingAllRes(List<Receiving> receivingList) {
		super();
		this.receivingList = receivingList;
	}

	public List<Receiving> getReceivingList() {
		return receivingList;
	}

}
