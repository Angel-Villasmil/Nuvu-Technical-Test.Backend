package cc.nuvu.technical.test.backend.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cc.nuvu.technical.test.backend.models.CreditCardModel;
import cc.nuvu.technical.test.backend.services.CreditCardService;

@RestController
@RequestMapping("/TDC")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @GetMapping()
    public ArrayList<CreditCardModel> obtenerTDCs(){
        return this.creditCardService.findAllCreditCard();
    }
    
    @GetMapping( path = "/{id}")
    public Optional<CreditCardModel> obtenerTDCPorId(@PathVariable("id") Long id) {
        return this.creditCardService.findCreditCardById(id);
    }

    @PostMapping()
    public String ingresarTDC(@RequestBody CreditCardModel TDC){
        return this.creditCardService.saveCreditCard(TDC);
    }

    @PutMapping()
    public String modificarTDC(@RequestBody CreditCardModel TDC){
        return this.creditCardService.updateCreditCard(TDC);
    }
    
    @DeleteMapping( path = "/{id}")
	public String borrarTDC(@PathVariable Long id){
		return this.creditCardService.deleteCreditCard(id);
		}
}