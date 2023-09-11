package com.laptopstore.service;

import com.laptopstore.dto.LaptopDTO;

import java.util.List;

public interface LaptopService {
    List<LaptopDTO> getAllLaptop();

    LaptopDTO createALaptop(LaptopDTO laptopDTO);

    LaptopDTO getLaptopDetails(Long id);

    boolean deleteLaptop(Long id);

    LaptopDTO updateLaptop(Long id, LaptopDTO laptopDTO);

   /* List<LaptopDTO> searchByName(String name);

    List<LaptopDTO> searchByPrice(double price);

    List<LaptopDTO> searchByBrand(String brand);*/

    List<LaptopDTO> search(String name, Double price, String brand);
}
