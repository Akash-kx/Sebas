package com.Ecommerce.Sebas.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Sebas.DetailInformation.AddToBagInformation;
import com.Ecommerce.Sebas.MainService.AddToBagService;
import com.Ecommerce.Sebas.SubDetailInformation.SubDetailInformation;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AddToBagController {
	
	@Autowired
	private AddToBagService AddBagService;

	@GetMapping("/ShowAllProductInAddToBag")
	public List<AddToBagInformation> ShowAllProductInAddToBag(HttpServletRequest request) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<AddToBagInformation> AddToBagDetail= AddBagService.GetAllProductInAddToBag(ActiveToken);
		return AddToBagDetail.size() == 0 ? null : AddToBagDetail;
	}
	
	@DeleteMapping("/DeleteSpecificProductInAddToBag/{ProductId}")
	public List<AddToBagInformation> DeleteSpecificProductInWishList(HttpServletRequest request, @PathVariable("ProductId") int ProductId) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<AddToBagInformation> AddToBagDetail= AddBagService.GetAllDataAfterDelete(ActiveToken, ProductId);
		return AddToBagDetail.size() == 0 ? null : AddToBagDetail;
	}
	
	@PostMapping("/MoveProductToWishList/{ProductId}")
	public List<AddToBagInformation> MoveProductToWishList(HttpServletRequest request, @PathVariable("ProductId") int ProductId) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<AddToBagInformation> AddToBagDetail= AddBagService.GetAllDataAfterMovingToWishList(ActiveToken, ProductId);
		return AddToBagDetail.size() == 0 ? null : AddToBagDetail;
	}
	
	@PutMapping("/UpdateProductInAddToBag")
	public List<AddToBagInformation> UpdateProductInAddToBag(HttpServletRequest request, @RequestBody SubDetailInformation AddToBagSubDetail) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<AddToBagInformation> AddToBagDetail= AddBagService.GetAllDataAfterUpdateProduct(ActiveToken, AddToBagSubDetail.getProductId(), AddToBagSubDetail.getProductQuantity(), AddToBagSubDetail.getProductSize());
		return AddToBagDetail.size() == 0 ? null : AddToBagDetail;
	}
	
	@GetMapping("/ShowAllProductIdInAddToBag")
	public List<Integer> ShowAllProductIdInAddToBag(HttpServletRequest request) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<Integer> AllProductId= AddBagService.GetAllProductId(ActiveToken);
		return AllProductId.size() == 0 ? null : AllProductId;
	}
	
	@PostMapping("/MoveProductToYourOrder/{ProductId}")
	public List<AddToBagInformation> MoveProductToYourOrder(HttpServletRequest request, @PathVariable("ProductId") List<Integer> ProductId) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<AddToBagInformation> YourOrderDetail= AddBagService.GetAllDataAfterMovingToYourOrder(ProductId, ActiveToken);
		return YourOrderDetail.size() == 0 ? null : YourOrderDetail;
	}
}
