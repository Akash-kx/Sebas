package com.Ecommerce.Sebas.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Sebas.CRUDRepository.YourOrderRepository;
import com.Ecommerce.Sebas.DetailInformation.YourOrderInformation;
import com.Ecommerce.Sebas.JWTtoken.JwtUtil;

@Service
public class YourOrderService {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private YourOrderRepository yourOrderRepository;
	
	public String ExtractUsernameFromToken(String ActiveToken) {
		
		String ActiveUserName= null;
		if(ActiveToken.startsWith("Bearer ")) {
			
			ActiveToken= ActiveToken.substring(7);
			ActiveUserName= jwtUtil.extractUsername(ActiveToken);
		}
		
		return ActiveUserName;
	}
	
	public List<YourOrderInformation> GetAllProductInYourOrder(String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		return yourOrderRepository.getAllProductInAddToBag(ActiveUserName);
	}
	
	public List<YourOrderInformation> GetAllDataAfterDelete(String ActiveToken, int ProductId) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		yourOrderRepository.deleteFromYourOrder(ProductId, ActiveUserName);
		return yourOrderRepository.getAllProductInAddToBag(ActiveUserName);
	}

}
