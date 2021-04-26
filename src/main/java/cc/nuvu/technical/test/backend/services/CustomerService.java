package cc.nuvu.technical.test.backend.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import cc.nuvu.technical.test.backend.models.CustomerModel;
import cc.nuvu.technical.test.backend.repositories.CustomerRepository;

@Service
public class CustomerService {
	
    @Autowired
    CustomerRepository customerRepository;
    
	public ArrayList<CustomerModel> findAllCustomer(){
		return (ArrayList<CustomerModel>) customerRepository.findAll();
	}
	
	public Optional<CustomerModel> findCustomerById(Long id){
		return customerRepository.findById(id);
	}
    
    public CustomerModel saveCustomer(CustomerModel customer){
        return customerRepository.save(customer);
    }
    
	public String deleteCustomer(Long id){
		if (customerRepository.findById(id).isPresent()){
			customerRepository.deleteById(id);
			return "Cliente eliminado correctamente.";
			}
		return "Error! El Cliente no existe.";
	}
	
	public String updateCustomer(CustomerModel customerToUpdate){
		if (customerRepository.findById(customerToUpdate.getId()).isPresent()){
			customerRepository.save(customerToUpdate);
			return "Cliente modificado.";
			}
		return "Error al modificar el Cliente.";
	}
}