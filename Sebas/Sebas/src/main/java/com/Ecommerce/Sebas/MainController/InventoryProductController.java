package com.Ecommerce.Sebas.MainController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Ecommerce.Sebas.Inventory.InventoryProductInformation;
import com.Ecommerce.Sebas.MainService.InventoryProductService;

@CrossOrigin(origins="*")
@RestController
public class InventoryProductController {
	
	@Autowired
	private InventoryProductService InventoryService;
	
	@PostMapping("/AddProductInInventory")
	public String AddProductInInventory(@RequestParam("ProductImage") MultipartFile ImageFile, @RequestParam("ProductCategory") String ProductCategory, @RequestParam("ProductForWhichUser") String ProductForWhichUser, 
			@RequestParam("ProductDescription") String ProductDescription, @RequestParam("ProductPrice") int ProductPrice, @RequestParam("ProductClass") String ProductClass ,
			@RequestParam("ProductName") String ProductName) 
					throws IllegalStateException, IOException {
		
		String AddProductStatus = InventoryService.AddProductInInventory(ImageFile, ProductCategory, ProductForWhichUser, ProductDescription, ProductPrice, ProductClass, ProductName);
		
		return AddProductStatus != null ? "Product Detail Added" : "Error Occured While Adding Product Detail";
	}

	@GetMapping("/ShowAllProductInInventory")
	public List<InventoryProductInformation> ShowAllProductInInventory() {
		
		List<InventoryProductInformation> AllDataInventory = InventoryService.GetAllProductInInventory();
		return AllDataInventory.size() == 0 ? null : AllDataInventory;
	}
	
	@GetMapping("/ShowAllProductForMen/{ProductFor}")
	public List<InventoryProductInformation> ShowAllProductForMen(@PathVariable("ProductFor") String MenProduct) {
		
		List<InventoryProductInformation> AllProductMen = InventoryService.GetAllProductForMen(MenProduct);
		return AllProductMen.size() == 0 ? null : AllProductMen;
	}
	
	@GetMapping("/ShowAllProductForWomen/{ProductFor}")
	public List<InventoryProductInformation> ShowAllProductForWomen(@PathVariable("ProductFor") String WomenProduct) {
		
		List<InventoryProductInformation> AllProductWomen = InventoryService.GetAllProductForWomen(WomenProduct);
		return AllProductWomen.size() == 0 ? null : AllProductWomen;
	}
	
	@GetMapping("/ShowAllSearchedProduct/{SearchProduct}")
	public List<InventoryProductInformation> ShowAllSearchedProduct(@PathVariable("SearchProduct") String SearchProduct) {
		
		List<InventoryProductInformation> AllSearchProduct = InventoryService.GetAllSearchedProduct(SearchProduct.toLowerCase());
		return AllSearchProduct.size() == 0 ? null : AllSearchProduct;
	}
	
	@GetMapping("/ShowSearchedProduct/{ProductId}")
	public InventoryProductInformation ShowSearchedProduct(@PathVariable("ProductId") int ProductId) {
		
		InventoryProductInformation SearchProduct = InventoryService.GetSearchedProduct(ProductId);
		return SearchProduct;
	}
	
	@GetMapping("/ShowOnlySpecificProduct")
	public List<InventoryProductInformation> ShowOnlySpecificProduct() {
		
		List<InventoryProductInformation> SpecificProduct= InventoryService.GetSpecificProduct();
		return SpecificProduct.size() == 0 ? null : SpecificProduct;
	}
	
}
