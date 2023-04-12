package com.Ecommerce.Sebas.CRUDRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Sebas.Cluster.YourOrderClusterPrimaryKey;
import com.Ecommerce.Sebas.DetailInformation.YourOrderInformation;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface YourOrderRepository extends CrudRepository<YourOrderInformation, YourOrderClusterPrimaryKey> {
	
	@Query(nativeQuery= true, value= "SELECT * FROM your_order_information WHERE email_id =:ActiveUserName")
	public List<YourOrderInformation> getAllProductInAddToBag(@Param("ActiveUserName") String ActiveUserName);
	
	@Modifying
	@Query(nativeQuery= true, value= "DELETE FROM your_order_information WHERE email_id =:ActiveUserName AND product_id =:ProductId")
	public void deleteFromYourOrder(@Param("ProductId") int ProductId, @Param("ActiveUserName") String ActiveUserName);
}
