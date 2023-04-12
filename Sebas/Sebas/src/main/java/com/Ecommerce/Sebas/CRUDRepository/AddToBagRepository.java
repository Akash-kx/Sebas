package com.Ecommerce.Sebas.CRUDRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Sebas.Cluster.AddToBagClusterPrimaryKey;
import com.Ecommerce.Sebas.DetailInformation.AddToBagInformation;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface AddToBagRepository extends CrudRepository<AddToBagInformation, AddToBagClusterPrimaryKey> {

	@Query(nativeQuery= true, value= "SELECT * FROM add_to_bag_information WHERE email_id =:ActiveUserName")
	public List<AddToBagInformation> getAllProductInAddToBag(@Param("ActiveUserName") String ActiveUserName);
	
	@Query(nativeQuery= true, value= "SELECT * FROM add_to_bag_information WHERE email_id =:ActiveUserName AND product_id =:ProductId")
	public Optional<AddToBagInformation> findTheWishListProduct(@Param("ProductId") int ProductId, @Param("ActiveUserName") String ActiveUserName);
	
	@Modifying
	@Query(nativeQuery= true, value= "DELETE FROM add_to_bag_information WHERE email_id =:ActiveUserName AND product_id =:ProductId")
	public void deleteFromAddToBag(@Param("ProductId") int ProductId, @Param("ActiveUserName") String ActiveUserName);
	
	@Modifying
	@Query(nativeQuery= true, value= "UPDATE add_to_bag_information SET product_quantity =:ProductQuantity, product_size =:ProductSize WHERE product_id =:ProductId AND email_id =:ActiveUserName")
	public void updateFromAddToBag(@Param("ActiveUserName") String ActiveUserName, @Param("ProductId") int ProductId, @Param("ProductQuantity") int ProductQuantity, @Param("ProductSize") String ProductSize);

	@Query(nativeQuery= true, value= "SELECT product_id FROM add_to_bag_information WHERE email_id =:ActiveUserName")
	public List<Integer> getAllProductId(@Param("ActiveUserName") String ActiveUserName);
	
	@Query(nativeQuery= true, value= "SELECT * FROM add_to_bag_information WHERE product_id =:ProductId AND email_id =:ActiveUserName")
	public Optional<AddToBagInformation> findTheAddToBagProduct(@Param("ProductId") int ProductId, @Param("ActiveUserName") String ActiveUserName);
}
