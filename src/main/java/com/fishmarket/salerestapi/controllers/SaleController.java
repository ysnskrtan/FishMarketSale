package com.fishmarket.salerestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fishmarket.salerestapi.models.Sale;
import com.fishmarket.salerestapi.repositories.SaleRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class SaleController {

	@Autowired
	SaleRepository saleRepository;
	
	@GetMapping("/sales")
	public List<Sale> getAllsales(){
		return saleRepository.findAll();
	}
	
	@PostMapping("/sales")
	public Sale createUser(@RequestBody Sale sale) {
		return saleRepository.save(sale);
	}
	
	@GetMapping(value="/sales/{id}")
	public ResponseEntity<Sale> getUserById(@PathVariable("id") String id){
		return saleRepository.findById(id).map(sale -> ResponseEntity.ok().body(sale)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/sales/{id}")
    public ResponseEntity<Sale> updateTodo(@PathVariable("id") String id,
                                           @RequestBody Sale sale) {
        return saleRepository.findById(id)
                .map(saleData -> {
                	saleData.setTitle(sale.getTitle());
                    saleData.setLocationName(sale.getLocationName());
                    saleData.setLocationId(sale.getLocationId());
                    saleData.setUserId(sale.getUserId());
                    Sale updatedUser = saleRepository.save(saleData);
                    return ResponseEntity.ok().body(updatedUser);
                }).orElse(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping(value="/sales/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        return saleRepository.findById(id)
                .map(user -> {
                    saleRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
