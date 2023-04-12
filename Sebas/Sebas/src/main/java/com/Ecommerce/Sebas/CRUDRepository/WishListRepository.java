package com.Ecommerce.Sebas.CRUDRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Sebas.Cluster.WishListClusterPrimaryKey;
import com.Ecommerce.Sebas.DetailInformation.WishListInformation;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface WishListRepository extends CrudRepository<WishListInformation, WishListClusterPrimaryKey> {

	@Query(nativeQuery= true, value= "SELECT * FROM wish_list_information WHERE email_id =:ActiveUserName")
	public List<WishListInformation> getAllProductInWishList(@Param("ActiveUserName") String ActiveUserName);
	
	@Modifying
	@Query(nativeQuery= true, value= "DELETE FROM wish_list_information WHERE product_id =:ProductId AND email_id =:ActiveUserName")
	public void deleteFromWishList(@Param("ProductId") int productId, @Param("ActiveUserName") String ActiveUserName);
	
	@Query(nativeQuery= true, value= "SELECT * FROM wish_list_information WHERE product_id =:ProductId AND email_id =:ActiveUserName")
	public Optional<WishListInformation> findTheWishListProduct(@Param("ProductId") int ProductId, @Param("ActiveUserName") String ActiveUserName);
	
	/*
	@Modifying
	@Query(nativeQuery= true, value= "UPDATE wish_list_information SET product_quantity =:ProductQuantity WHERE product_id =:ProductId AND email_id =:ActiveUserName")
	public void updateFromWishList(@Param("ProductId") int ProductId, @Param("ActiveUserName") String ActiveUserName, @Param("ProductQuantity") String ProductQuantity);
	*/
}
