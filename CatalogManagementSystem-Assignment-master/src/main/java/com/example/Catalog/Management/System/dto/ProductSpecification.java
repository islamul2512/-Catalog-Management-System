package com.example.Catalog.Management.System.dto;
import com.example.Catalog.Management.System.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name != null ? criteriaBuilder.like(root.get("name"), "%" + name + "%") : null;
    }

    public static Specification<Product> hasBrand(String brand) {
        return (root, query, criteriaBuilder) ->
                brand != null ? criteriaBuilder.like(root.get("brand"), "%" + brand + "%") : null;
    }

    public static Specification<Product> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                category != null ? criteriaBuilder.equal(root.get("category"), category) : null;
    }

    public static Specification<Product> hasMinPrice(Double minPrice) {
        return (root, query, criteriaBuilder) ->
                minPrice != null ? criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice) : null;
    }

    public static Specification<Product> hasMaxPrice(Double maxPrice) {
        return (root, query, criteriaBuilder) ->
                maxPrice != null ? criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice) : null;
    }
}
