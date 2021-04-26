package cc.nuvu.technical.test.backend.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import cc.nuvu.technical.test.backend.models.CreditCardModel;
import cc.nuvu.technical.test.backend.repositories.CreditCardRepository;
import cc.nuvu.technical.test.backend.repositories.CustomerRepository;

@Service
public class CreditCardService {
	
    @Autowired
    CreditCardRepository creditCardRepository;
    CustomerRepository customerRepository;
    
	public ArrayList<CreditCardModel> findAllCreditCard(){
		return (ArrayList<CreditCardModel>) creditCardRepository.findAll();
	}
	
	public Optional<CreditCardModel> findCreditCardById(Long id){
		return creditCardRepository.findById(id);
	}
    
    public String saveCreditCard(CreditCardModel creditCard){
    	try {
        	creditCardRepository.addCreditCard(creditCard.getBank(),
        			creditCard.getBin(), creditCard.getExpiryDate(),
        			creditCard.getCardholder(), creditCard.getBrand(),
        			creditCard.getCvv(), creditCard.getCustomer().getId());
        	
        	return "Tarjeta de Credito agregada correctamente!";
    	}catch (Exception e){
    		System.out.println(e);
    		return "Error! Tarjeta de Credito no agregada.";
    	}
    }
    
	public String deleteCreditCard(Long id){
		if (creditCardRepository.findById(id).isPresent()){
			creditCardRepository.removeCreditCard(id);
			return "Tarjeta de Credito eliminada correctamente.";
			}
		return "Error! La Tarjeta de Credito no existe.";
	}
	
	public String updateCreditCard(CreditCardModel CreditCardToUpdate){
		if (creditCardRepository.findById(CreditCardToUpdate.getId()).isPresent()){
			creditCardRepository.save(CreditCardToUpdate);
			return "Tarjeta de Credito modificada.";
			}
		return "Error al modificar la Tarjeta de Credito.";
	}
}