package com.Ecommerce.Sebas.SubDetailInformation;

public class SubDetailInformation {
	
	private int productId;
	
	private String ProductSize;
	
	private int ProductQuantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductSize() {
		return ProductSize;
	}

	public void setProductSize(String productSize) {
		ProductSize = productSize;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public SubDetailInformation(int productId, String productSize, int productQuantity) {
		super();
		this.productId = productId;
		ProductSize = productSize;
		ProductQuantity = productQuantity;
	}

	public SubDetailInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubDetailInformation [productId=" + productId + ", ProductSize=" + ProductSize + ", ProductQuantity="
				+ ProductQuantity + "]";
	}

}
