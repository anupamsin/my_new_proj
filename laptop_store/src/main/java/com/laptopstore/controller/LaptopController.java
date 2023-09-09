package com.laptopstore.controller;

import com.laptopstore.dto.LaptopDTO;
import com.laptopstore.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/test")
    public ResponseEntity<String> testConnection() {
        return new ResponseEntity<>("Connection Successful", HttpStatus.OK);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<LaptopDTO>> getAllLaptops() {
        return new ResponseEntity<>(laptopService.getAllLaptop(), HttpStatus.OK);
    }

    @PostMapping("/laptops")
    public ResponseEntity<LaptopDTO> createLaptop(@Valid @RequestBody LaptopDTO laptopDTO) {
        return new ResponseEntity<>(laptopService.createALaptop(laptopDTO), HttpStatus.CREATED);
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity<LaptopDTO> laptopDetailsById(@PathVariable Long id) {
        return new ResponseEntity<>(laptopService.getLaptopDetails(id), HttpStatus.OK);
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<String> deleteLaptopById(@PathVariable Long id) {
        boolean status=laptopService.deleteLaptop(id);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/laptops/{id}")
    public ResponseEntity<LaptopDTO> updateLaptopById(@PathVariable Long id, @RequestBody LaptopDTO laptopDTO) {
        return new ResponseEntity<>(laptopService.updateLaptop(id, laptopDTO), HttpStatus.OK);
    }

    @GetMapping("/laptops/search")
    public ResponseEntity<List<LaptopDTO>> searchLaptop(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "price", required = false) Double price,
            @RequestParam(name = "brand", required = false) String brand) {
        List<LaptopDTO> laptops = null;
        if (name != null) {
            laptops = laptopService.searchByName(name);
        } else if (price != null) {
            laptops = laptopService.searchByPrice(price);
        } else if (brand != null) {
            laptops = laptopService.searchByBrand(brand);
        }

        if (laptops != null && !laptops.isEmpty()) {
            return new ResponseEntity<>(laptops, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
