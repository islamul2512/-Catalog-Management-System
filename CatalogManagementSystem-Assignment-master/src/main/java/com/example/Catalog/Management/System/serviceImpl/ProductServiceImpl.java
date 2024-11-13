package com.example.Catalog.Management.System.serviceImpl;

import com.example.Catalog.Management.System.dto.ProductDto;
import com.example.Catalog.Management.System.dto.ProductSpecification;
import com.example.Catalog.Management.System.entity.Product;
import com.example.Catalog.Management.System.exception.ResourceNotFoundException;
import com.example.Catalog.Management.System.repository.ProductRepository;
import com.example.Catalog.Management.System.service.ProductService;
import com.example.Catalog.Management.System.utils.ObjectMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final String className = ProductServiceImpl.class.getSimpleName();

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        logger.info("{} - createProduct() invoked with {}", className, productDto);
        Product product = ObjectMapperUtils.map(productDto, Product.class);
        Product savedProduct = productRepository.saveAndFlush(product);
        logger.info("{} - Product created successfully: {}", className, savedProduct);
        return ObjectMapperUtils.map(savedProduct, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortType) {
        logger.info("{} - getAllProducts() invoked with pageNumber: {}, pageSize: {}, sortBy: {}, sortType: {}",
                className, pageNumber, pageSize, sortBy, sortType);

        Sort sort = sortType.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductDto> productDtos = ObjectMapperUtils.mapAll(productPage.getContent(), ProductDto.class);


        logger.info("{} - Retrieved {} products", className, productDtos.size());
        return productDtos;
    }


    @Override
    public ProductDto getProductById(Long id) {
        logger.info("{} - getProductById() invoked with id: {}", className, id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        logger.info("{} - Product found: {}", className, product);
        return convertToDto(product);
    }
    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        logger.info("{} - updateProduct() invoked with id: {} and data: {}", className, id, productDto);


        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));


        ObjectMapperUtils.map(productDto, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        logger.info("{} - Product updated successfully: {}", className, updatedProduct);
        return ObjectMapperUtils.map(updatedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        logger.info("{} - deleteProduct() invoked with id: {}", className, id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
        logger.info("{} - Product deleted successfully with id: {}", className, id);
    }

    private ProductDto convertToDto(Product product) {
        return ObjectMapperUtils.map(product, ProductDto.class);
    }
    @Override
    public List<ProductDto> searchProducts(String name, String brand, String category,
                                           Double minPrice, Double maxPrice,
                                           Integer pageNumber, Integer pageSize,
                                           String sortBy, String sortType) {

        Sort sort = sortType.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);


        Specification<Product> spec = Specification
                .where(ProductSpecification.hasName(name))
                .and(ProductSpecification.hasBrand(brand))
                .and(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.hasMinPrice(minPrice))
                .and(ProductSpecification.hasMaxPrice(maxPrice));


        Page<Product> productPage = productRepository.findAll(spec, pageable);


        return ObjectMapperUtils.mapAll(productPage.getContent(), ProductDto.class);
    }
}
