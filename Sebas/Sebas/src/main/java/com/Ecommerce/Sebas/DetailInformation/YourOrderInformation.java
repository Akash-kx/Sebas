package com.Ecommerce.Sebas.DetailInformation;

import com.Ecommerce.Sebas.Cluster.YourOrderClusterPrimaryKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class YourOrderInformation {
	
	@EmbeddedId
	private YourOrderClusterPrimaryKey YourOrderClusterId;
	
	private String ProductName;
	
	private String ProductImagePath;
	
	private int ProductPrice;
	
	private int ProductQuantity;
	
	private String productSize;
	
	private String productDescription;

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public YourOrderClusterPrimaryKey getYourOrderClusterId() {
		return YourOrderClusterId;
	}

	public void setYourOrderClusterId(YourOrderClusterPrimaryKey yourOrderClusterId) {
		YourOrderClusterId = yourOrderClusterId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductImagePath() {
		return ProductImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		ProductImagePath = productImagePath;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public YourOrderInformation(YourOrderClusterPrimaryKey yourOrderClusterId, String productName,
			String productImagePath, int productPrice, int productQuantity, String productSize,
			String productDescription) {
		super();
		YourOrderClusterId = yourOrderClusterId;
		ProductName = productName;
		ProductImagePath = productImagePath;
		ProductPrice = productPrice;
		ProductQuantity = productQuantity;
		this.productSize = productSize;
		this.productDescription = productDescription;
	}

	public YourOrderInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "YourOrderInformation [YourOrderClusterId=" + YourOrderClusterId + ", ProductName=" + ProductName
				+ ", ProductImagePath=" + ProductImagePath + ", ProductPrice=" + ProductPrice + ", ProductQuantity="
				+ ProductQuantity + ", productSize=" + productSize + ", productDescription=" + productDescription + "]";
	}
	
}
