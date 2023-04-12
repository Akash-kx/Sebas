package com.Ecommerce.Sebas.Cluster;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class YourOrderClusterPrimaryKey implements Serializable {
	
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
		YourOrderClusterPrimaryKey other = (YourOrderClusterPrimaryKey) obj;
		return Objects.equals(EmailId, other.EmailId) && ProductId == other.ProductId;
	}

	@Override
	public String toString() {
		return "YourOrderClusterPrimaryKey [ProductId=" + ProductId + ", EmailId=" + EmailId + "]";
	}

	public YourOrderClusterPrimaryKey(int productId, String emailId) {
		super();
		ProductId = productId;
		EmailId = emailId;
	}

	public YourOrderClusterPrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
