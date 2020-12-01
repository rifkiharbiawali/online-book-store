package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Basket;
import com.g2academy.gramedia.domain.Customer;
import com.g2academy.gramedia.repository.BasketRepository;
import com.g2academy.gramedia.repository.CustomerRepository;
import com.g2academy.gramedia.service.Dto.BasketDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BasketService {
    private final BasketRepository repository;
    private final CustomerRepository customerRepository;

    BasketService(BasketRepository repository, CustomerRepository customerRepository){
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Basket addCustomer(BasketDto basketDto, Long idCustomer){
        Optional<Customer> cEntity = customerRepository.findById(idCustomer);
        Customer customer = cEntity.orElse(null);
        if (customer!= null){
            Basket basket = Basket.builder()
                    .customer(customer)
                    .build();
            return repository.save(basket);
        }
            return null;
    }
}
