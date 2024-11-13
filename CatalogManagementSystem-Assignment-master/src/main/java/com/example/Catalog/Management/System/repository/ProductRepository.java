package com.example.Catalog.Management.System.repository;

import com.example.Catalog.Management.System.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByBrandIgnoreCase(String brand);

    List<Product> findByCategoryIgnoreCase(String category);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    Page<Product> findAll(Specification<Product> spec, Pageable pageable);
}
