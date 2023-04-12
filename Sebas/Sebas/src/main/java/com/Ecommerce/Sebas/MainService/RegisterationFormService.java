package com.Ecommerce.Sebas.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Sebas.CRUDRepository.RegistrationRepository;
import com.Ecommerce.Sebas.DetailInformation.RegistrationInformation;

@Service
public class RegisterationFormService {
	
	@Autowired
	private RegistrationRepository RegisterationFormRepository;
	
	public void AddRegistrationDetail(RegistrationInformation RegisterationDetail) {
		
		if(RegisterationDetail != null) {
			
			RegisterationFormRepository.save(RegisterationDetail);
		}
	}
	
	public boolean EmailExistOrNot(RegistrationInformation RegisterationDetail) {
		
		String ExistOrNot = RegisterationFormRepository.EmailExistOrNot(RegisterationDetail.getEmailId());
		if(ExistOrNot == null) {
			
			return false;
		}
		return true;
	}

}
