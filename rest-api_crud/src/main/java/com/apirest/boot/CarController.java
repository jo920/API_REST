package com.apirest.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarController {
	
@Autowired	
CarRepository repository;
	
	@GetMapping("/carro")
	public List<Car> getAllCarros(){
		return repository.findAll();
	}
	
	@GetMapping("/carro/{id}")
	public Car getCarroById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/carro")
	public Car saveCarro(@RequestBody Car carro) {
		return repository.save(carro);
	}
	
	@DeleteMapping("/carro/{id}")
	public void deleteCarro(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
