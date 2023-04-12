package com.Ecommerce.Sebas.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Sebas.CRUDRepository.AddToBagRepository;
import com.Ecommerce.Sebas.CRUDRepository.InventoryProductRepository;
import com.Ecommerce.Sebas.CRUDRepository.WishListRepository;
import com.Ecommerce.Sebas.Cluster.AddToBagClusterPrimaryKey;
import com.Ecommerce.Sebas.Cluster.WishListClusterPrimaryKey;
import com.Ecommerce.Sebas.DetailInformation.AddToBagInformation;
import com.Ecommerce.Sebas.DetailInformation.WishListInformation;
import com.Ecommerce.Sebas.Inventory.InventoryProductInformation;
import com.Ecommerce.Sebas.JWTtoken.JwtUtil;

@Service
public class WishListService {
	
	@Autowired
	private WishListRepository WishlistRepository;
	
	@Autowired
	private InventoryProductRepository InventoryRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AddToBagRepository AddBagRepository;
	
	public String ExtractUsernameFromToken(String ActiveToken) {
		
		String ActiveUserName= null;
		if(ActiveToken.startsWith("Bearer ")) {
			
			ActiveToken= ActiveToken.substring(7);
			ActiveUserName= jwtUtil.extractUsername(ActiveToken);
		}
		
		return ActiveUserName;
	}
	
	@SuppressWarnings("unused")
	public String AddProductInWishList(int ProductQuantity, int ProductId , String ProductSize, String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		
		InventoryProductInformation ProductDataById= InventoryRepository.findProductById(ProductId).orElseThrow(() -> new NullPointerException("No such Id present"));
		
		WishListClusterPrimaryKey WishListCluster= new WishListClusterPrimaryKey(ProductDataById.getProductId(), ActiveUserName);
		WishListInformation WishListDetail= new WishListInformation(WishListCluster, ProductDataById.getProductPrice(), ProductDataById.getProductImagePath(), ProductDataById.getProductName(), 
				ProductQuantity, ProductSize, ProductDataById.getProductClass(), ProductDataById.getProductDescription()); 
		
		if(WishListDetail != null) {
			
			WishlistRepository.save(WishListDetail);
			return "WishList Added";
		}
		
		return null;
	}
	
	public List<WishListInformation> GetAllProductInWishList(String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		return WishlistRepository.getAllProductInWishList(ActiveUserName);
	}
	
	public List<WishListInformation> GetAllDataAfterDelete(String ActiveToken, int ProductId) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		WishlistRepository.deleteFromWishList(ProductId, ActiveUserName);
		return WishlistRepository.getAllProductInWishList(ActiveUserName);
	}

	@SuppressWarnings("unused")
	public List<WishListInformation> addProductToBagFromWishList(int ProductId, String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		
		WishListInformation ProductInWishList= WishlistRepository.findTheWishListProduct(ProductId, ActiveUserName).orElseThrow(() -> new NullPointerException("No such Id present"));
		
		AddToBagClusterPrimaryKey AddToBagCluster= new AddToBagClusterPrimaryKey(ProductInWishList.getWishListClusterId().getProductId(), ProductInWishList.getWishListClusterId().getUserEmail());
		AddToBagInformation AddToBagDetail= new AddToBagInformation(AddToBagCluster, ProductInWishList.getProductPrice(), ProductInWishList.getProductImagePath(), ProductInWishList.getProductName(), 
				ProductInWishList.getProductQuantity(), ProductInWishList.getProductSize(), ProductInWishList.getProductDescription(), ProductInWishList.getProductClass());
		
		if(AddToBagDetail != null) {
			
			AddBagRepository.save(AddToBagDetail);
			WishlistRepository.deleteFromWishList(ProductId, ActiveUserName);
			return WishlistRepository.getAllProductInWishList(ActiveUserName);
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	public String AddProductInAddToBag(int ProductQuantity, int ProductId, String ProductSize, String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		
		InventoryProductInformation ProductDataById= InventoryRepository.findProductById(ProductId).orElseThrow(() -> new NullPointerException("No such Id present"));
		
		AddToBagClusterPrimaryKey  AddToBagCluster= new AddToBagClusterPrimaryKey(ProductDataById.getProductId(), ActiveUserName);
		AddToBagInformation AddToBagDetail= new AddToBagInformation(AddToBagCluster, ProductDataById.getProductPrice(), ProductDataById.getProductImagePath(), ProductDataById.getProductName() ,
				ProductQuantity, ProductSize, ProductDataById.getProductDescription(), ProductDataById.getProductClass());
		
		if(AddToBagDetail != null) {
			
			AddBagRepository.save(AddToBagDetail);
			return "AddToBag Added";
		}
		
		return null;
	}

}
