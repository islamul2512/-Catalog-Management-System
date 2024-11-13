package com.example.Catalog.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchPaginationRequestDTO {
    private Integer pageSize;
    private Integer pageNumber;
    private String sortBy;
    private String sortType;
    private String name;
    private String brand;
    private String category;
    private Double minPrice;
    private Double maxPrice;
}
