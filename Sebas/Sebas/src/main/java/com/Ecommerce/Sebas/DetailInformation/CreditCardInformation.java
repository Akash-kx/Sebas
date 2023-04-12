package com.Ecommerce.Sebas.DetailInformation;

import java.sql.Date;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class CreditCardInformation {
	
	@CreditCardNumber(message= "Not valid")
	private String CreditCard;
	
	@NotBlank(message= "Not valid")
	private String CardHolderName;
	
	@PastOrPresent(message= "Not valid")
	private Date EndDate;
	
	@Pattern(regexp= "^(?=.*\\d.*\\d.*\\d).{3}$", message= "Not valid")
	private String CVC;

	public String getCreditCard() {
		return CreditCard;
	}

	public void setCreditCard(String creditCard) {
		CreditCard = creditCard;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String cVC) {
		CVC = cVC;
	}

	public String getCardHolderName() {
		return CardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		CardHolderName = cardHolderName;
	}

	public CreditCardInformation(@CreditCardNumber(message = "Not valid") String creditCard,
			@NotBlank(message = "Not valid") String cardHolderName, @PastOrPresent(message = "Not valid") Date endDate,
			@Pattern(regexp = "^(?=.*\\d.*\\d.*\\d).{3}$", message = "Not valid") String cVC) {
		super();
		CreditCard = creditCard;
		CardHolderName = cardHolderName;
		EndDate = endDate;
		CVC = cVC;
	}

	public CreditCardInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CreditCardInformation [CreditCard=" + CreditCard + ", CardHolderName=" + CardHolderName + ", EndDate="
				+ EndDate + ", CVC=" + CVC + "]";
	}
	
}
