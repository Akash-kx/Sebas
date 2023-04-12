package com.Ecommerce.Sebas.DetailInformation;

import com.Ecommerce.Sebas.Cluster.WishListClusterPrimaryKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class WishListInformation {
	
	@EmbeddedId
	private WishListClusterPrimaryKey WishListClusterId;
	
	private int ProductPrice;
	
	private String ProductImagePath;
	
	private String ProductName;
	
	private int ProductQuantity;
	
	private String ProductSize;
	
	private String ProductClass;
	
	private String ProductDescription;

	public String getProductSize() {
		return ProductSize;
	}

	public void setProductSize(String productSize) {
		ProductSize = productSize;
	}

	public WishListClusterPrimaryKey getWishListClusterId() {
		return WishListClusterId;
	}

	public void setWishListClusterId(WishListClusterPrimaryKey wishListClusterId) {
		WishListClusterId = wishListClusterId;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductImagePath() {
		return ProductImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		ProductImagePath = productImagePath;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

	public String getProductClass() {
		return ProductClass;
	}

	public void setProductClass(String productClass) {
		ProductClass = productClass;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public WishListInformation(WishListClusterPrimaryKey wishListClusterId, int productPrice, String productImagePath,
			String productName, int productQuantity, String productSize, String productClass,
			String productDescription) {
		super();
		WishListClusterId = wishListClusterId;
		ProductPrice = productPrice;
		ProductImagePath = productImagePath;
		ProductName = productName;
		ProductQuantity = productQuantity;
		ProductSize = productSize;
		ProductClass = productClass;
		ProductDescription = productDescription;
	}

	public WishListInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "WishListInformation [WishListClusterId=" + WishListClusterId + ", ProductPrice=" + ProductPrice
				+ ", ProductImagePath=" + ProductImagePath + ", ProductName=" + ProductName + ", ProductQuantity="
				+ ProductQuantity + ", ProductSize=" + ProductSize + ", ProductClass=" + ProductClass
				+ ", ProductDescription=" + ProductDescription + "]";
	}
	
}
