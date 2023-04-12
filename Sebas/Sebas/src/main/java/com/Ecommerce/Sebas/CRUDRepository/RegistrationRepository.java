package com.Ecommerce.Sebas.CRUDRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Sebas.DetailInformation.RegistrationInformation;

@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationInformation, String> {

	@Query(nativeQuery= true, value= "SELECT email_id FROM registration_information WHERE email_id =:EmailId")
	public String EmailExistOrNot(@Param("EmailId") String EmailId);
	
	@Query(nativeQuery= true, value= "SELECT * FROM registration_information WHERE email_id =:EmailId")
	public Optional<RegistrationInformation> EmailAndPasswordLogin(@Param("EmailId") String EmailId);
}
