package com.Ecommerce.Sebas.DetailInformation;

import com.Ecommerce.Sebas.Cluster.AddToBagClusterPrimaryKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class AddToBagInformation {
	
	@EmbeddedId
	private AddToBagClusterPrimaryKey AddToBagId;
	
	private int ProductPrice;
	
	private String ProductImagePath;
	
	private String ProductName;
	
	private int ProductQuantity;
	
	private String ProductSize;
	
	private String ProductDescription;
	
	private String ProductClass;
	
	public String getProductSize() {
		return ProductSize;
	}

	public void setProductSize(String productSize) {
		ProductSize = productSize;
	}

	public AddToBagClusterPrimaryKey getAddToBagId() {
		return AddToBagId;
	}

	public void setAddToBagId(AddToBagClusterPrimaryKey addToBagId) {
		AddToBagId = addToBagId;
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

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public String getProductClass() {
		return ProductClass;
	}

	public void setProductClass(String productClass) {
		ProductClass = productClass;
	}

	public AddToBagInformation(AddToBagClusterPrimaryKey addToBagId, int productPrice, String productImagePath,
			String productName, int productQuantity, String productSize, String productDescription,
			String productClass) {
		super();
		AddToBagId = addToBagId;
		ProductPrice = productPrice;
		ProductImagePath = productImagePath;
		ProductName = productName;
		ProductQuantity = productQuantity;
		ProductSize = productSize;
		ProductDescription = productDescription;
		ProductClass = productClass;
	}

	public AddToBagInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AddToBagInformation [AddToBagId=" + AddToBagId + ", ProductPrice=" + ProductPrice
				+ ", ProductImagePath=" + ProductImagePath + ", ProductName=" + ProductName + ", ProductQuantity="
				+ ProductQuantity + ", ProductSize=" + ProductSize + ", ProductDescription=" + ProductDescription
				+ ", ProductClass=" + ProductClass + "]";
	}
	
}
