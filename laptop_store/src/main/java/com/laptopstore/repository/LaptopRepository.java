package com.laptopstore.repository;

import com.laptopstore.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
    List<Laptop> findByName(String name);

    List<Laptop> findByPrice(double price);

    List<Laptop> findByBrand(String brand);
}
