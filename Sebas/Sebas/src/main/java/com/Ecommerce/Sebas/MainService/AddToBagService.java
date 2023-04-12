package com.Ecommerce.Sebas.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Sebas.CRUDRepository.AddToBagRepository;
import com.Ecommerce.Sebas.CRUDRepository.WishListRepository;
import com.Ecommerce.Sebas.CRUDRepository.YourOrderRepository;
import com.Ecommerce.Sebas.Cluster.WishListClusterPrimaryKey;
import com.Ecommerce.Sebas.Cluster.YourOrderClusterPrimaryKey;
import com.Ecommerce.Sebas.DetailInformation.AddToBagInformation;
import com.Ecommerce.Sebas.DetailInformation.WishListInformation;
import com.Ecommerce.Sebas.DetailInformation.YourOrderInformation;
import com.Ecommerce.Sebas.JWTtoken.JwtUtil;

@Service
public class AddToBagService {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AddToBagRepository AddBagRepository;
	
	@Autowired
	private WishListRepository WishlistRepository;
	
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

	public List<AddToBagInformation> GetAllProductInAddToBag(String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		return AddBagRepository.getAllProductInAddToBag(ActiveUserName);
	}
	
	public List<AddToBagInformation> GetAllDataAfterDelete(String ActiveToken, int ProductId) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		AddBagRepository.deleteFromAddToBag(ProductId, ActiveUserName);
		return AddBagRepository.getAllProductInAddToBag(ActiveUserName);
	}
	
	@SuppressWarnings("unused")
	public List<AddToBagInformation> GetAllDataAfterMovingToWishList(String ActiveToken, int ProductId) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		
		AddToBagInformation ProductInWishList= AddBagRepository.findTheWishListProduct(ProductId, ActiveUserName).orElseThrow(() -> new NullPointerException("No such Id present"));
		
		WishListClusterPrimaryKey WishListCluster= new WishListClusterPrimaryKey(ProductInWishList.getAddToBagId().getProductId(), ActiveUserName);
		WishListInformation WishListDetail= new WishListInformation(WishListCluster, ProductInWishList.getProductPrice(), ProductInWishList.getProductImagePath(), ProductInWishList.getProductName(),
				ProductInWishList.getProductQuantity(), ProductInWishList.getProductSize(), ProductInWishList.getProductDescription(), ProductInWishList.getProductClass());
		
		if(WishListDetail != null) {
			
			WishlistRepository.save(WishListDetail);
			AddBagRepository.deleteFromAddToBag(ProductId, ActiveUserName);
			return AddBagRepository.getAllProductInAddToBag(ActiveUserName);
		}
		
		return null;
	}
	
	public List<AddToBagInformation> GetAllDataAfterUpdateProduct(String ActiveToken, int ProductId, int ProductQuantity, String ProductSize) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		
		if(ProductQuantity == 0) {
			
			AddBagRepository.deleteFromAddToBag(ProductId, ActiveUserName);
		}
		else if(ProductQuantity >= 1) {
			
			AddBagRepository.updateFromAddToBag(ActiveUserName, ProductId, ProductQuantity, ProductSize);
		}
		
		return AddBagRepository.getAllProductInAddToBag(ActiveUserName);
	}
	
	public List<Integer> GetAllProductId(String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		List<Integer> AllProductId= AddBagRepository.getAllProductId(ActiveUserName);
		return AllProductId;
	}

	//
	public List<AddToBagInformation> GetAllDataAfterMovingToYourOrder(List<Integer> ProductIds, String ActiveToken) {
		
		String ActiveUserName= ExtractUsernameFromToken(ActiveToken);
		
		try {
			
			ProductIds.forEach(ProductId -> {
				
				System.out.println(ProductId);
				System.out.println(ActiveUserName);
				
				AddToBagInformation AddToBagDetail= AddBagRepository.findTheAddToBagProduct(ProductId, ActiveUserName).orElseThrow(() -> new NullPointerException("No such Id present"));
				
				YourOrderClusterPrimaryKey YourOrderCluster= new YourOrderClusterPrimaryKey(AddToBagDetail.getAddToBagId().getProductId(), AddToBagDetail.getAddToBagId().getEmailId());
				YourOrderInformation YourOrderDetail= new YourOrderInformation(YourOrderCluster, AddToBagDetail.getProductName(), AddToBagDetail.getProductImagePath(), AddToBagDetail.getProductPrice(), 
						AddToBagDetail.getProductQuantity(), AddToBagDetail.getProductSize(), AddToBagDetail.getProductDescription());
				
				yourOrderRepository.save(YourOrderDetail);
				
				AddBagRepository.deleteFromAddToBag(ProductId, ActiveUserName);
			});
			
			return AddBagRepository.getAllProductInAddToBag(ActiveUserName);
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}

	}
}
