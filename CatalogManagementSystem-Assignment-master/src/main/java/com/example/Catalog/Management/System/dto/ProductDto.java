package com.example.Catalog.Management.System.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    @NotBlank(message = "Product name is required")
    private String name;
    @NotBlank(message = "Brand name is required")
    private String brand;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @NotBlank(message = "Category is required")
    private String category;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
