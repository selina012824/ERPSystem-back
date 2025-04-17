package com.example.ERPSystem.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReceivingDetailsID implements Serializable {
	
	private String receivingDetailID;

	private String receivingID;

	public String getReceivingDetailID() {
		return receivingDetailID;
	}

	public void setReceivingDetailID(String receivingDetailID) {
		this.receivingDetailID = receivingDetailID;
	}

	public String getReceivingID() {
		return receivingID;
	}

	public void setReceivingID(String receivingID) {
		this.receivingID = receivingID;
	}
	
	

}
