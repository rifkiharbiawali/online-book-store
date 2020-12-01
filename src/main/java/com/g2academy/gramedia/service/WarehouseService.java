package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Warehouse;
import com.g2academy.gramedia.repository.WarehouseRepository;
import com.g2academy.gramedia.service.Dto.WarehouseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository repository;

    WarehouseService (WarehouseRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Warehouse addWarehouse(WarehouseDto warehouseDto){
        Warehouse warehouse = Warehouse.builder()
                .phone(warehouseDto.getPhone())
                .address(warehouseDto.getAddress())
                .build();
        return repository.save(warehouse);
    }

    public List<Warehouse> findAll(){return repository.findAll();}
    public Optional<Warehouse> findId(Long id){return repository.findById(id);}

    public Warehouse editWarehouse(WarehouseDto warehouseDto, Long id){
        Optional<Warehouse> wEntity = repository.findById(id);
        Warehouse warehouse = wEntity.orElse(null);
        if (warehouse != null){
            warehouse.setAddress(warehouseDto.getAddress());
            warehouse.setPhone(warehouseDto.getPhone());
            return repository.save(warehouse);
        }
        return null;
    }

    public ResponseEntity<?> deleteWarehouse(Long id){
        return repository.findById(id).map(warehouseE -> {
            repository.delete(warehouseE);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new RuntimeException("Warehouse tidak ditemukan"));
    }

    public List<Warehouse> findIsbn(String isbn){
        if (isbn != null){
            return repository.findIsbn(isbn);
        }
        return null;
    }

    public List<Warehouse> findTitle(String title){
        if (title != null){
            return repository.findTitle(title);
        }
        return null;
    }

    public List<Warehouse> findAuthor(String author){
        if (author != null){
            return repository.findAuthor(author);
        }
        return null;
    }

    public List<Warehouse> findPublisher(String publisher){
        if (publisher != null){
            return repository.findPublisher(publisher);
        }
        return null;
    }

}
