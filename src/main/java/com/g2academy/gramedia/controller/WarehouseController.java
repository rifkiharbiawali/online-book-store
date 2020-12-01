package com.g2academy.gramedia.controller;

import com.g2academy.gramedia.domain.Warehouse;
import com.g2academy.gramedia.service.Dto.WarehouseDto;
import com.g2academy.gramedia.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WarehouseController {
    private final WarehouseService service;

    WarehouseController(WarehouseService service){
        this.service = service;
    }

    @GetMapping("/warehouse")
    public List<Warehouse> findAll(){return service.findAll();}

    @GetMapping("/warehouse/{id}")
    public Optional<Warehouse> findByid(Long id){
        return service.findId(id);
    }

    @PostMapping("/warehouse")
    public Warehouse addWarehouse(@RequestBody WarehouseDto warehouseDto){
        return service.addWarehouse(warehouseDto);
    }

    @PutMapping("/warehouse/{id}")
    public Warehouse editWarehouse(@RequestBody WarehouseDto warehouseDto, @PathVariable Long id){
        return service.editWarehouse(warehouseDto, id);
    }

    @DeleteMapping("/warehouse/{id}")
    public ResponseEntity<?> deleteWarehouse(@PathVariable Long id){
        return service.deleteWarehouse(id);
    }

    @GetMapping("/warehouse/isbn/{keyword}")
    public List<Warehouse> getByIsbn(@PathVariable String keyword){
        return service.findIsbn(keyword);
    }

    @GetMapping("/warehouse/title/{keyword}")
    public List<Warehouse> getByTitle(@PathVariable String keyword){
        return service.findTitle(keyword);
    }

    @GetMapping("/warehouse/author/{keyword}")
    public List<Warehouse> getByAuthor(@PathVariable String keyword){
        return service.findAuthor(keyword);
    }

    @GetMapping("/warehouse/publisher/{keyword}")
    public List<Warehouse> getByPublisher(@PathVariable String keyword){
        return service.findPublisher(keyword);
    }
}
