package com.Ecommerce.Sebas.MainController;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Sebas.DetailInformation.CreditCardInformation;

import jakarta.validation.Valid;

@RestController
public class CreditFormController {

	@PostMapping("/UserCardDetail")
	public boolean UserCardDetail(@Valid @RequestBody CreditCardInformation CardDetail, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return false;
		}
		
		return true;
	}
}
