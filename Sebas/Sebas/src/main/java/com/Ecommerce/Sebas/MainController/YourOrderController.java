package com.Ecommerce.Sebas.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Sebas.DetailInformation.YourOrderInformation;
import com.Ecommerce.Sebas.MainService.YourOrderService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins="*")
@RestController
public class YourOrderController {
	
	@Autowired
	private YourOrderService yourOrderService;
	
	@GetMapping("/ShowAllProductInYourOrder")
	public List<YourOrderInformation> ShowAllProductInYourOrder(HttpServletRequest request) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<YourOrderInformation> YourOrderDetail= yourOrderService.GetAllProductInYourOrder(ActiveToken);
		return YourOrderDetail.size() == 0 ? null : YourOrderDetail;
	}
	
	@DeleteMapping("/DeleteSpecificProductInYourOrder/{ProductId}")
	public List<YourOrderInformation> DeleteSpecificProductInAddToBag(HttpServletRequest request, @PathVariable("ProductId") int ProductId) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<YourOrderInformation> YourOrderDetail= yourOrderService.GetAllDataAfterDelete(ActiveToken, ProductId);
		return YourOrderDetail.size() == 0 ? null : YourOrderDetail;
	}

}
