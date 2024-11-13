package com.example.Catalog.Management.System.service;


import com.example.Catalog.Management.System.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);



    List<ProductDto> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortType);

    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);



    List<ProductDto> searchProducts(String name, String brand, String category,
                                    Double minPrice, Double maxPrice,
                                    Integer pageNumber, Integer pageSize,
                                    String sortBy, String sortType);
}
