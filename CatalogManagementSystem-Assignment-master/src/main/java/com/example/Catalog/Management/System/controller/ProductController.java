package com.example.Catalog.Management.System.controller;

import com.example.Catalog.Management.System.dto.PaginationRequestDTO;
import com.example.Catalog.Management.System.dto.ProductDto;
import com.example.Catalog.Management.System.dto.SearchPaginationRequestDTO;
import com.example.Catalog.Management.System.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @PostMapping("/get-products")
    public ResponseEntity<List<ProductDto>> getAllProducts( @RequestBody PaginationRequestDTO paginationRequest) {
        Integer pageNumber = paginationRequest.getPageNumber() != null ? paginationRequest.getPageNumber() : 0;
        Integer pageSize = paginationRequest.getPageSize() != null ? paginationRequest.getPageSize() : 10;  // default 10 items per page
        String sortBy = paginationRequest.getSortBy() != null ? paginationRequest.getSortBy() : "updatedAt";  // default sorting by ID
        String sortType = paginationRequest.getSortType() != null ? paginationRequest.getSortType() : "asc";  // default sorting in ascending order
        List<ProductDto> products = productService.getAllProducts(pageNumber, pageSize, sortBy, sortType);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestBody SearchPaginationRequestDTO paginationRequest) {
        Integer pageNumber = paginationRequest.getPageNumber() != null ? paginationRequest.getPageNumber() : 0;
        Integer pageSize = paginationRequest.getPageSize() != null ? paginationRequest.getPageSize() : 10;
        String sortBy = paginationRequest.getSortBy() != null ? paginationRequest.getSortBy() : "updatedAt";
        String sortType = paginationRequest.getSortType() != null ? paginationRequest.getSortType() : "desc";

        List<ProductDto> products = productService.searchProducts(
                paginationRequest.getName(),
                paginationRequest.getBrand(),
                paginationRequest.getCategory(),
                paginationRequest.getMinPrice(),
                paginationRequest.getMaxPrice(),
                pageNumber, pageSize, sortBy, sortType);

        return ResponseEntity.ok(products);
    }

}
