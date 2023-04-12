package com.Ecommerce.Sebas.CRUDRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Sebas.Inventory.InventoryProductInformation;

@Repository
public interface InventoryProductRepository extends CrudRepository<InventoryProductInformation, Integer> {
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information")
	public List<InventoryProductInformation> findAllData();
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information WHERE CAST(product_for_which_user AS BINARY) REGEXP BINARY :MenProduct")
	public List<InventoryProductInformation> findAllMenProduct(@Param("MenProduct") String MenProduct);
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information WHERE product_for_which_user REGEXP :WomenProduct")
	public List<InventoryProductInformation> findAllWomenProduct(@Param("WomenProduct") String WomenProduct);
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information WHERE product_category REGEXP :SearchProduct")
	public List<InventoryProductInformation> findAllSearchRegProduct(@Param("SearchProduct") String SearchProduct);
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information WHERE product_category LIKE :SearchProduct")
	public List<InventoryProductInformation> findAllSearchProduct(@Param("SearchProduct") String SearchProduct);
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information WHERE product_id =:ProductId")
	public Optional<InventoryProductInformation> findProductById(@Param("ProductId") int ProductId);
	
	@Query(nativeQuery= true, value= "SELECT * FROM inventory_product_information LIMIT :LimitValue")
	public List<InventoryProductInformation> getLimitValue(@Param("LimitValue") int LimitValue);
}