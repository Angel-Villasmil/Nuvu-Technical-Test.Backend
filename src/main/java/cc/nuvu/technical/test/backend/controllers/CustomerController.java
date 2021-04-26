package cc.nuvu.technical.test.backend.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cc.nuvu.technical.test.backend.models.CustomerModel;
import cc.nuvu.technical.test.backend.services.CustomerService;

@RestController
@RequestMapping("/cliente")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ArrayList<CustomerModel> obtenerClientes(){
        return this.customerService.findAllCustomer();
    }
    
    @GetMapping( path = "/{id}")
    public Optional<CustomerModel> obtenerClientePorId(@PathVariable("id") Long id) {
        return this.customerService.findCustomerById(id);
    }

    @PostMapping()
    public CustomerModel igresarCliente(@RequestBody CustomerModel cliente){
        return this.customerService.saveCustomer(cliente);
    }

    @PutMapping()
    public String modificarCliente(@RequestBody CustomerModel cliente){
        return this.customerService.updateCustomer(cliente);
    }
    
    @DeleteMapping( path = "/{id}")
	public String borrarCliente(@PathVariable Long id){
		return this.customerService.deleteCustomer(id);
		}
}