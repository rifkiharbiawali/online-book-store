package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.domain.Warehouse;
import com.g2academy.gramedia.domain.Wb;
import com.g2academy.gramedia.repository.BookRepository;
import com.g2academy.gramedia.repository.WarehouseRepository;
import com.g2academy.gramedia.repository.WbRepository;
import com.g2academy.gramedia.service.Dto.WbDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WbService {
    private final WbRepository repository;
    private final BookRepository bookRepository;
    private final WarehouseRepository warehouseRepository;

    WbService(WbRepository repository, BookRepository bookRepository, WarehouseRepository warehouseRepository){
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<Wb> findAll() {return repository.findAll();}

    public Wb add(WbDto wbDto, Long idBook, Long idWarehouse){
        Optional<Book> bEntity = bookRepository.findById(idBook);
        Book book = bEntity.orElse(null);
        Optional<Warehouse> wEntity = warehouseRepository.findById(idWarehouse);
        Warehouse warehouse = wEntity.orElse(null);
        Wb wb = Wb.builder()
                .book(book)
                .warehouse(warehouse)
                .count(wbDto.getCount())
                .build();
        return repository.save(wb);
    }
}
