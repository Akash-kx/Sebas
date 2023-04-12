package com.Ecommerce.Sebas.Inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class InventoryProductInformation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ProductId;
	
	private int ProductPrice;
	
	private String ProductDescription;
	
	private String ProductName;
	
	private String ProductImagePath;  // RequestParam
	
	private String ProductCategory;
	
	private String ProductForWhichUser;
	
	private String ProductClass;

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
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

	public String getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}

	public String getProductForWhichUser() {
		return ProductForWhichUser;
	}

	public void setProductForWhichUser(String productForWhichUser) {
		ProductForWhichUser = productForWhichUser;
	}

	public String getProductClass() {
		return ProductClass;
	}

	public void setProductClass(String productClass) {
		ProductClass = productClass;
	}

	public InventoryProductInformation(int productId, int productPrice, String productDescription, String productName,
			String productImagePath, String productCategory, String productForWhichUser, String productClass) {
		super();
		ProductId = productId;
		ProductPrice = productPrice;
		ProductDescription = productDescription;
		ProductName = productName;
		ProductImagePath = productImagePath;
		ProductCategory = productCategory;
		ProductForWhichUser = productForWhichUser;
		ProductClass = productClass;
	}

	public InventoryProductInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InventoryProductInformation [ProductId=" + ProductId + ", ProductPrice=" + ProductPrice
				+ ", ProductDescription=" + ProductDescription + ", ProductName=" + ProductName + ", ProductImagePath="
				+ ProductImagePath + ", ProductCategory=" + ProductCategory + ", ProductForWhichUser="
				+ ProductForWhichUser + ", ProductClass=" + ProductClass + "]";
	}
	
}
