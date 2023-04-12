package com.Ecommerce.Sebas.Cluster;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class AddToBagClusterPrimaryKey implements Serializable {
	
	private int ProductId;
	
	@Column(name="EmailId", columnDefinition="VARCHAR(64)")
	private String EmailId;

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(EmailId, ProductId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddToBagClusterPrimaryKey other = (AddToBagClusterPrimaryKey) obj;
		return Objects.equals(EmailId, other.EmailId) && ProductId == other.ProductId;
	}

	@Override
	public String toString() {
		return "AddToBagClusterPrimaryKey [ProductId=" + ProductId + ", EmailId=" + EmailId + "]";
	}

	public AddToBagClusterPrimaryKey(int productId, String emailId) {
		super();
		ProductId = productId;
		EmailId = emailId;
	}

	public AddToBagClusterPrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
