package com.example.ERPSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

// 入荷明細
@Entity
@Table(name = "receiving_details")
@IdClass(value = ReceivingDetailsID.class)
public class ReceivingDetails {

	@Id
	@Column(name = "receiving_detail_id")
	private String receivingDetailID; // 入荷明細番号

	@Id
	@Column(name = "receiving_id")
	private String receivingID; // 入荷伝票番号

	@Column(name = "material_id")
	private String materialID; // 材料番号

	@Column(name = "quantity_received")
	private int quantityReceived; // 実受入数量

	@Column(name = "quantity_accepted")
	private int quantityAccepted; // 合格数量

	@Column(name = "quantity_rejected")
	private int quantityRejected; // 不合格数量

	@Column(name = "storage_location")
	private String storageLocation; // 入荷位置

	@Column(name = "stock_status")
	private String stockStatus; // 入荷状態

	public ReceivingDetails() {
		super();
	}

	public ReceivingDetails(String receivingDetailID, String receivingID, String materialID, int quantityReceived,
			int quantityAccepted, int quantityRejected, String storageLocation, String stockStatus) {
		super();
		this.receivingDetailID = receivingDetailID;
		this.receivingID = receivingID;
		this.materialID = materialID;
		this.quantityReceived = quantityReceived;
		this.quantityAccepted = quantityAccepted;
		this.quantityRejected = quantityRejected;
		this.storageLocation = storageLocation;
		this.stockStatus = stockStatus;
	}

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

	public String getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}

	public int getQuantityReceived() {
		return quantityReceived;
	}

	public void setQuantityReceived(int quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public int getQuantityAccepted() {
		return quantityAccepted;
	}

	public void setQuantityAccepted(int quantityAccepted) {
		this.quantityAccepted = quantityAccepted;
	}

	public int getQuantityRejected() {
		return quantityRejected;
	}

	public void setQuantityRejected(int quantityRejected) {
		this.quantityRejected = quantityRejected;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	
	

}
