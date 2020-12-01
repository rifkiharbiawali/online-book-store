package com.g2academy.gramedia.controller;

import com.g2academy.gramedia.domain.Wb;
import com.g2academy.gramedia.service.Dto.WbDto;
import com.g2academy.gramedia.service.WbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WbController {
    private final WbService service;

    WbController(WbService service){
        this.service = service;
    }

    @GetMapping("/wb")
    public List<Wb> findAll(){return service.findAll();}

    @PostMapping("/wb/{idBook}/{idWarehouse}")
    public Wb add(@RequestBody WbDto wbDto, @PathVariable Long idBook, @PathVariable Long idWarehouse){
        return service.add(wbDto, idBook, idWarehouse);
    }
}
