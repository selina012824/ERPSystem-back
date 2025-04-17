package com.example.ERPSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

//購買注文書明細

@Entity
@Table(name = "purchase_order_info")
@IdClass(value = PurchaseOrderInfoID.class)
public class PurchaseOrderInfo {

	@Id
	@Column(name = "po_detail_id")
	private String poDetailID; // 購買注文書明細番号

	@Id
	@Column(name = "purchase_order_id")
	private String purchaseOrderID; // 購買注文書番号

	@Column(name = "material_id")
	private String materialID; // 材料番号

	@Column(name = "processing_type")
	private String processingType; // 加工種別

	@Column(name = "quantity")
	private int quantity; // 数量

	@Column(name = "unit_price")
	private BigDecimal unitPrice; // 単価

	@Column(name = "subtotal")
	private BigDecimal subtotal; // 小計

	@Column(name = "thickness")
	private BigDecimal thickness; // 厚さ

	@Column(name = "width")
	private BigDecimal width; // 幅

	@Column(name = "length")
	private BigDecimal length; // 長さ

	@Column(name = "weight")
	private BigDecimal weight; // 重量

	@Column(name = "diameter")
	private BigDecimal diameter; // 直径

	@Column(name = "outer_diameter")
	private BigDecimal outerDiameter; // 外径

	@Column(name = "inner_thickness")
	private BigDecimal innerThickness; // 内径

	@Column(name = "cutting_size")
	private BigDecimal cuttingSize; // カットサイズ

	@Column(name = "surface_treatment")
	private String surfaceTreatment; // 表面処理

	@Column(name = "specification")
	private String specification; // 仕様

	@Column(name = "create_at")
	private LocalDateTime createAt; // 作成日時

	@Column(name = "create_clerk_nm")
	private String createClerkNm; // 作成者

	@Column(name = "update_at")
	private LocalDateTime updateAt; // 更新日時

	@Column(name = "update_by")
	private String updateBy; // 更新者

	public PurchaseOrderInfo() {
		super();
	}

	public PurchaseOrderInfo(String poDetailID, String purchaseOrderID, String materialID, String processingType,
			int quantity, BigDecimal unitPrice, BigDecimal subtotal, BigDecimal thickness, BigDecimal width,
			BigDecimal length, BigDecimal weight, BigDecimal diameter, BigDecimal outerDiameter,
			BigDecimal innerThickness, BigDecimal cuttingSize, String surfaceTreatment, String specification,
			LocalDateTime createAt, String createClerkNm, LocalDateTime updateAt, String updateBy) {
		super();
		this.poDetailID = poDetailID;
		this.purchaseOrderID = purchaseOrderID;
		this.materialID = materialID;
		this.processingType = processingType;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.subtotal = subtotal;
		this.thickness = thickness;
		this.width = width;
		this.length = length;
		this.weight = weight;
		this.diameter = diameter;
		this.outerDiameter = outerDiameter;
		this.innerThickness = innerThickness;
		this.cuttingSize = cuttingSize;
		this.surfaceTreatment = surfaceTreatment;
		this.specification = specification;
		this.createAt = createAt;
		this.createClerkNm = createClerkNm;
		this.updateAt = updateAt;
		this.updateBy = updateBy;
	}

	public String getPoDetailID() {
		return poDetailID;
	}

	public void setPoDetailID(String poDetailID) {
		this.poDetailID = poDetailID;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public String getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}

	public String getProcessingType() {
		return processingType;
	}

	public void setProcessingType(String processingType) {
		this.processingType = processingType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getThickness() {
		return thickness;
	}

	public void setThickness(BigDecimal thickness) {
		this.thickness = thickness;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getDiameter() {
		return diameter;
	}

	public void setDiameter(BigDecimal diameter) {
		this.diameter = diameter;
	}

	public BigDecimal getOuterDiameter() {
		return outerDiameter;
	}

	public void setOuterDiameter(BigDecimal outerDiameter) {
		this.outerDiameter = outerDiameter;
	}

	public BigDecimal getInnerThickness() {
		return innerThickness;
	}

	public void setInnerThickness(BigDecimal innerThickness) {
		this.innerThickness = innerThickness;
	}

	public BigDecimal getCuttingSize() {
		return cuttingSize;
	}

	public void setCuttingSize(BigDecimal cuttingSize) {
		this.cuttingSize = cuttingSize;
	}

	public String getSurfaceTreatment() {
		return surfaceTreatment;
	}

	public void setSurfaceTreatment(String surfaceTreatment) {
		this.surfaceTreatment = surfaceTreatment;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public String getCreateClerkNm() {
		return createClerkNm;
	}

	public void setCreateClerkNm(String createClerkNm) {
		this.createClerkNm = createClerkNm;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}
