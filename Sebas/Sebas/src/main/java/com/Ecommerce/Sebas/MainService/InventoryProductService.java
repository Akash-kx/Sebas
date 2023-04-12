package com.Ecommerce.Sebas.MainService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Ecommerce.Sebas.CRUDRepository.InventoryProductRepository;
import com.Ecommerce.Sebas.Inventory.InventoryProductInformation;

@Service
public class InventoryProductService {
	
	@Autowired
	private InventoryProductRepository InventoryRepository;
	
	private final String ImageStoreLocation=  "F:/SebasEcomm/SebasFront/SebasEcommFront/src/assets/ImageInventory/";

	public String AddProductInInventory(MultipartFile ImageFile, String ProductCategory, String ProductForWhichUser,
			String ProductDescription, int ProductPrice, String ProductClass, String ProductName) throws IllegalStateException, IOException {
		
		String SingleImageLocation= ImageStoreLocation + ImageFile.getOriginalFilename();
        
        String ImagePathDatabase= "/assets/ImageInventory/" + ImageFile.getOriginalFilename();
		
        InventoryProductInformation FileData= InventoryRepository.save(InventoryProductInformation.builder()
        		.ProductCategory(ProductCategory)
        		.ProductDescription(ProductDescription)
        		.ProductForWhichUser(ProductForWhichUser)
        		.ProductImagePath(ImagePathDatabase)
        		.ProductName(ProductName)
        		.ProductPrice(ProductPrice)
        		.ProductClass(ProductClass).build());
		
		ImageFile.transferTo(new File(SingleImageLocation));
		
		if(FileData != null)
		{
			return "File Is Been Added";
		}
		
		return null;
	}
	
	public List<InventoryProductInformation> GetAllProductInInventory() {
		
		return InventoryRepository.findAllData();
	}
	
	public List<InventoryProductInformation> GetAllProductForMen(String MenProduct) {
		
		return InventoryRepository.findAllMenProduct(MenProduct);
	}
	
	public List<InventoryProductInformation> GetAllProductForWomen(String WomenProduct) {
		
		return InventoryRepository.findAllMenProduct(WomenProduct);
	}
	
	public List<InventoryProductInformation> GetAllSearchedProduct(String SearchProduct) {

		SearchProduct= SearchProduct.replaceAll("[^a-zA-Z]", "");
		SearchProduct= SearchProduct.replaceAll("\\s", "");
		
		if(SearchProduct.equals("shirt")) {
			
			return InventoryRepository.findAllSearchProduct(SearchProduct);
		}
		
		else {

			return InventoryRepository.findAllSearchRegProduct(SearchProduct);
		}
	}
	
	public InventoryProductInformation GetSearchedProduct(int ProductId) {
		
		return InventoryRepository.findProductById(ProductId).orElseThrow(() -> new NullPointerException("No such Id present"));
	}
	
	public List<InventoryProductInformation> GetSpecificProduct() {
		
		int LimitValue= 8;
		return InventoryRepository.getLimitValue(LimitValue);
	}
	
}
