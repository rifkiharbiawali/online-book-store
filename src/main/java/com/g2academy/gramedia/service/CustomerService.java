package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Customer;
import com.g2academy.gramedia.repository.CustomerRepository;
import com.g2academy.gramedia.service.Dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository customerRepository){
        this.repository = customerRepository;
    }

    public List<Customer> findAll(){return repository.findAll();}

    public Optional<Customer> findId(Long id){return repository.findById(id);}

    @Transactional
    public Customer addCustomer(CustomerDto customerDto){
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .address(customerDto.getAddress())
                .phone(customerDto.getPhone())
                .build();
        return repository.save(customer);
    }

    public Customer editC(CustomerDto customerDto, Long id){
        Optional<Customer> aEntity = repository.findById(id);
        Customer customer = aEntity.orElse(null);
        if (customer!=null){
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setAddress(customerDto.getAddress());
            customer.setPhone(customerDto.getAddress());
            return repository.save(customer);
        }
        return null;
    }

    public ResponseEntity<?> delete(Long id){
        return repository.findById(id).map(bookE -> {
            repository.delete(bookE);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new RuntimeException("Customer tidak ditemukan"));
    }

    public List<Customer> findName(String name){
        if (name != null){
            return repository.findName(name);
        }
        return null;
    }
}
