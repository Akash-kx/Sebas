package com.Ecommerce.Sebas.MainController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Ecommerce.Sebas.DetailInformation.RegistrationInformation;
import com.Ecommerce.Sebas.MainService.RegisterationFormService;

import jakarta.validation.Valid;

@CrossOrigin(origins="*")
@Controller
public class RegisterationFormController {
	
	@Autowired
	private RegisterationFormService RegisterionService;
	
	@GetMapping("/ShowRegistrationForm")
	public ModelAndView ShowRegistrationForm(ModelAndView modelAndView) {
		
		RegistrationInformation RegisterDetail = new RegistrationInformation();
		modelAndView.addObject("RegistrationInformation", RegisterDetail);
		modelAndView.setViewName("RegisterFormContent");
		return modelAndView;
	}
	
	@PostMapping("/UserRegistrationInformation")
	public String UserRegistrationInformation(@Valid @ModelAttribute("RegistrationInformation") RegistrationInformation RegisterationDetail, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "RegisterFormContent";
		}
		else if(RegisterionService.EmailExistOrNot(RegisterationDetail)) {
			
			model.addAttribute("ExistOrNot", "Email already exist");
			return "RegisterFormContent";
		}
		else {
			
			RegisterionService.AddRegistrationDetail(RegisterationDetail);
		}
		
		return "http://localhost:4200/LoginPage";
	}

}
