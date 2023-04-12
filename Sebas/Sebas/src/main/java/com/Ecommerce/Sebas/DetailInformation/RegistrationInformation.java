package com.Ecommerce.Sebas.DetailInformation;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

@Entity
public class RegistrationInformation {
	
	@Id
	@Column(name="EmailId", columnDefinition="VARCHAR(64)")
	@Email(message="Enter a valid email id")
	@NotBlank(message="Can not be null")
	private String EmailId;
	
	@NotBlank(message="Can not be null")
	private String UserName;
	
	@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$" ,message="Minimum length 8 must have number and uppercase, lowercase letters")
	private String UserPassword;
	
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$" ,message="Phone number is invalid")
	private String UserPhoneNumber;

	@PastOrPresent(message="Not valid")
	private Date UserBirthDate;
	
	private String UserGendar;

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserPhoneNumber() {
		return UserPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		UserPhoneNumber = userPhoneNumber;
	}

	public Date getUserBirthDate() {
		return UserBirthDate;
	}

	public void setUserBirthDate(Date userBirthDate) {
		UserBirthDate = userBirthDate;
	}

	public String getUserGendar() {
		return UserGendar;
	}

	public void setUserGendar(String userGendar) {
		UserGendar = userGendar;
	}

	@Override
	public String toString() {
		return "RegistrationInformation [EmailId=" + EmailId + ", UserName=" + UserName + ", UserPassword="
				+ UserPassword + ", UserPhoneNumber=" + UserPhoneNumber + ", UserBirthDate=" + UserBirthDate
				+ ", UserGendar=" + UserGendar + "]";
	}

	public RegistrationInformation(@Email(message = "Enter a valid email id") @NotBlank(message="Can not be null") String emailId,
			@NotBlank(message = "Can not be null") String userName,
			@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "Minimum length 8 must have number and uppercase, lowercase letters") String userPassword,
			@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Phone number is invalid") String userPhoneNumber,
			@PastOrPresent(message = "Not valid") Date userBirthDate, String userGendar) {
		super();
		EmailId = emailId;
		UserName = userName;
		UserPassword = userPassword;
		UserPhoneNumber = userPhoneNumber;
		UserBirthDate = userBirthDate;
		UserGendar = userGendar;
	}

	public RegistrationInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
