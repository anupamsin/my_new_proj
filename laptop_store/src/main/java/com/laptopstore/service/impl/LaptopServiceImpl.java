package com.laptopstore.service.impl;

import com.laptopstore.dto.LaptopDTO;
import com.laptopstore.entity.Laptop;
import com.laptopstore.exception.ResourceNotFoundException;
import com.laptopstore.repository.LaptopRepository;
import com.laptopstore.service.LaptopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    private static LaptopDTO laptopToLaptopDTO(Laptop laptop){
        LaptopDTO laptopDTO=new LaptopDTO();
        BeanUtils.copyProperties(laptop,laptopDTO);
        return laptopDTO;
    }

    @Override
    public List<LaptopDTO> getAllLaptop() {
        List<LaptopDTO> listLaptopDTO=new ArrayList<>();
        laptopRepository.findAll().forEach(laptopData->listLaptopDTO.add(laptopToLaptopDTO(laptopData)));
        if(listLaptopDTO.isEmpty()){
            throw new ResourceNotFoundException("No Laptop Data Found");
        }
        return listLaptopDTO;
    }

    @Override
    public LaptopDTO createALaptop(LaptopDTO laptopDTO) {
        Laptop laptop=new Laptop();
        laptop.setBrand(laptopDTO.getBrand());
        laptop.setName(laptopDTO.getName());
        laptop.setRam(laptopDTO.getRam());
        laptop.setPrice(laptopDTO.getPrice());
        laptop.setProcessor(laptopDTO.getProcessor());
        laptop.setStorage(laptopDTO.getStorage());
        laptopRepository.save(laptop);
        return laptopToLaptopDTO(laptop);
    }

    @Override
    public LaptopDTO getLaptopDetails(Long id) {
        Laptop laptop=laptopRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Laptop with ID : "+id+" not found"));
        return laptopToLaptopDTO(laptop);
    }

    @Override
    public boolean deleteLaptop(Long id) {
        Laptop laptop=laptopRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Laptop with ID : "+id+" not found"));
        if(laptop!=null) {
            laptopRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public LaptopDTO updateLaptop(Long id, LaptopDTO laptopDTO) {
        Laptop laptop=laptopRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Laptop with ID : "+id+" not found"));
        if(laptop!=null) {
            Laptop laptop1=new Laptop();
            laptop1.setId(id);
            laptop1.setBrand(laptopDTO.getBrand());
            laptop1.setName(laptopDTO.getName());
            laptop1.setRam(laptopDTO.getRam());
            laptop1.setPrice(laptopDTO.getPrice());
            laptop1.setProcessor(laptopDTO.getProcessor());
            laptop1.setStorage(laptopDTO.getStorage());
            laptopRepository.save(laptop1);
            return laptopToLaptopDTO(laptop1);
        }
        return laptopToLaptopDTO(laptop);
    }

    @Override
    public List<LaptopDTO> searchByName(String name) {
        List<LaptopDTO> laptopDTOS=new ArrayList<>();
        laptopRepository.findByName(name).forEach(laptopData->laptopDTOS.add(laptopToLaptopDTO(laptopData)));
        if(laptopDTOS.isEmpty()){
            throw new ResourceNotFoundException("No Data Found with Name : "+name);
        }
        return laptopDTOS;
    }

    @Override
    public List<LaptopDTO> searchByPrice(double price) {
        List<LaptopDTO> laptopDTOS=new ArrayList<>();
        laptopRepository.findByPrice(price).forEach(laptopData->laptopDTOS.add(laptopToLaptopDTO(laptopData)));
        if(laptopDTOS.isEmpty()){
            throw new ResourceNotFoundException("No Data Found with Price : "+price);
        }
        return laptopDTOS;
    }

    @Override
    public List<LaptopDTO> searchByBrand(String brand) {
        List<LaptopDTO> laptopDTOS=new ArrayList<>();
        laptopRepository.findByBrand(brand).forEach(laptopData->laptopDTOS.add(laptopToLaptopDTO(laptopData)));
        if(laptopDTOS.isEmpty()){
            throw new ResourceNotFoundException("No Data Found with Brand : "+brand);
        }
        return laptopDTOS;
    }
}
