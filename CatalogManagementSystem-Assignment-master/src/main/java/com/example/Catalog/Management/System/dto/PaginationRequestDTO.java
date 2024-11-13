package com.example.Catalog.Management.System.dto;
public class PaginationRequestDTO
{

    private Integer pageSize;
    private Integer pageNumber;
    private String sortBy;
    private String sortType;


    public String getSortBy() {
        return sortBy;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    public String getSortType() {
        return sortType;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }



}
