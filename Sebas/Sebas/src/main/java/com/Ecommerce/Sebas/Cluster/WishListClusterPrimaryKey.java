package com.Ecommerce.Sebas.Cluster;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class WishListClusterPrimaryKey implements Serializable{
	
	private int ProductId;
	
	@Column(name="EmailId", columnDefinition="VARCHAR(64)")
	private String UserEmail;

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ProductId, UserEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishListClusterPrimaryKey other = (WishListClusterPrimaryKey) obj;
		return ProductId == other.ProductId && Objects.equals(UserEmail, other.UserEmail);
	}

	public WishListClusterPrimaryKey(int productId, String userEmail) {
		super();
		ProductId = productId;
		UserEmail = userEmail;
	}

	public WishListClusterPrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
