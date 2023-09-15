package com.Ecommerce.Sebas.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Sebas.DetailInformation.WishListInformation;
import com.Ecommerce.Sebas.MainService.WishListService;
import com.Ecommerce.Sebas.SubDetailInformation.SubDetailInformation;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WishListController {
	
	@Autowired
	private WishListService WishlistService;

	@PostMapping("/AddProductInWishList")
	public boolean AddProductInWishList(HttpServletRequest request, @RequestBody SubDetailInformation WishListSubInformation) {
		
		String ActiveToken= request.getHeader("Authorization");
		String AddWishListStatus= WishlistService.AddProductInWishList(WishListSubInformation.getProductQuantity(), WishListSubInformation.getProductId(), WishListSubInformation.getProductSize(), ActiveToken);
		return AddWishListStatus == null ? false : true;
	}
	
	@GetMapping("/ShowAllProductInWishList")
	public List<WishListInformation> ShowAllProductInWishList(HttpServletRequest request) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<WishListInformation> WishListDetail= WishlistService.GetAllProductInWishList(ActiveToken);
		return WishListDetail.size() == 0 ? null : WishListDetail;
	}

	@DeleteMapping("/DeleteSpecificProductInWishList/{ProductId}")
	public List<WishListInformation> DeleteSpecificProductInWishList(HttpServletRequest request, @PathVariable("ProductId") int ProductId) {
		
		String ActiveToken= request.getHeader("Authorization");
		List<WishListInformation> WishListDetail= WishlistService.GetAllDataAfterDelete(ActiveToken, ProductId);
		return WishListDetail.size() == 0 ? null : WishListDetail;
	}
	
	@PostMapping("/AddProductInAddToBagFromWishList/{ProductId}")
	public List<WishListInformation> AddProductInAddToBagFromWishList(HttpServletRequest request, @PathVariable("ProductId") int ProductId) {

		String ActiveToken= request.getHeader("Authorization");
		List<WishListInformation> AddToBagDetail= WishlistService.addProductToBagFromWishList(ProductId, ActiveToken);
		return AddToBagDetail.size() == 0 ? null : AddToBagDetail;
	}
	
	@PostMapping("/AddProductInAddToBag")
	public String AddProductInAddToBag(HttpServletRequest request, @RequestBody SubDetailInformation AddToBagInformation) {
		
		String ActiveToken= request.getHeader("Authorization");
		String AddToBagStatus= WishlistService.AddProductInAddToBag(AddToBagInformation.getProductQuantity(), AddToBagInformation.getProductId(), AddToBagInformation.getProductSize(), ActiveToken);
		return AddToBagStatus == null ? "Product not added in AddToBag" : "Product added in AddToBag";
	}

}
