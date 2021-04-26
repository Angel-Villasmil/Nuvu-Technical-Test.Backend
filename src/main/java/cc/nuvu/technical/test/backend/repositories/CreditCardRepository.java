package cc.nuvu.technical.test.backend.repositories;

import java.util.Calendar;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.nuvu.technical.test.backend.models.CreditCardModel;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardModel, Long> {
	
    @Modifying
	@Query(value="INSERT INTO credit_card(Bank, BIN, expiry_date, Cardholder, Brand, CVV, fk_id_customer) VALUES "
			+ "(:Bank,:BIN,:expiry_date,:Cardholder,:Brand,:CVV,:fk_id_customer)", nativeQuery=true)
    @Transactional
    void addCreditCard(	@Param("Bank") String Bank,
    					@Param("BIN") String BIN,
    					@Param("expiry_date") Calendar expiry_date,
    					@Param("Cardholder") String Cardholder,
    					@Param("Brand") String Brand,
    					@Param("CVV") String CVV,
    					@Param("fk_id_customer") Long fk_id_customer);
    
    @Modifying
	@Query(value="DELETE FROM credit_card WHERE id_credit_card = :id_credit_card", nativeQuery=true)
    @Transactional
    void removeCreditCard(@Param("id_credit_card") Long id_credit_card);
}
