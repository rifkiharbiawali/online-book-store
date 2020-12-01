package com.g2academy.gramedia.controller;

import com.g2academy.gramedia.domain.Customer;
import com.g2academy.gramedia.service.CustomerService;
import com.g2academy.gramedia.service.Dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){return service.findAll();}

    @GetMapping("/customers/{id}")
    public Optional<Customer> findId(@PathVariable Long id){return service.findId(id);}

    @PostMapping("/customers")
    public Customer add( @RequestBody CustomerDto customerDto){
        return service.addCustomer(customerDto);
    }

    @PutMapping("/customers/{id}")
    public Customer edit(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        return service.editC(customerDto, id);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("/customers/name/{keyword}")
    public List<Customer> getName(@PathVariable String keyword){
        return service.findName(keyword);
    }
}
