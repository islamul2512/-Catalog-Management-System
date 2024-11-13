# Catalog Management System

## Overview
The Catalog Management System provides functionality for managing products in a catalog. It allows users to create, retrieve, update, delete, and search for products. The application uses **Spring Boot** with a **MySQL** database and implements a **REST API**.

## Prerequisites
Before running the Spring Boot application, ensure the following:

- **Java 17 or higher** is installed on your machine.
- **Maven** or **Gradle** is installed for building the application.
- **MySQL** database setup with the credentials provided in `application.properties`.

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-repository-url/catalog-management-system.git
cd catalog-management-system

## 2. Configure Database
Open src/main/resources/application.properties and update the following properties with your MySQL database details:

spring.datasource.url=jdbc:mysql://localhost:3306/catalog_dbone
spring.datasource.username=root 
spring.datasource.password=Md@8969684321
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Build and Run the Application
Using Maven:
mvn spring-boot:run

4. Access the Application
Once the application starts, you can access the API at http://localhost:8080.

API Endpoints
1. Create a Product
URL: /api/products/create-product
Method: POST
Request Body:
json
{
  "name": "Product Name",
  "brand": "Brand Name",
  "description": "Product description",
  "price": 100.00,
  "quantity": 50,
  "category": "Electronics"
}

Response:
{
  "id": 1,
  "name": "Product Name",
  "brand": "Brand Name",
  "description": "Product description",
  "price": 100.00,
  "quantity": 50,
  "category": "Electronics",
  "createdAt": "2024-11-13T12:34:56.789",
  "updatedAt": "2024-11-13T12:34:56.789"
}

2. Get All Products
URL: /api/products/get-products
Method: POST
Request Body:
json
{
  "pageNumber": 0,
  "pageSize": 10,
  "sortBy": "updatedAt",
  "sortType": "asc"
}
Response:

[
  {
    "id": 1,
    "name": "Product Name",
    "brand": "Brand Name",
    "description": "Product description",
    "price": 100.00,
    "quantity": 50,
    "category": "Electronics",
    "createdAt": "2024-11-13T12:34:56.789",
    "updatedAt": "2024-11-13T12:34:56.789"
  },
  ...
]

3. Get Product by ID
URL: /api/products/{id}
Method: GET
Response:
json
{
  "id": 1,
  "name": "Product Name",
  "brand": "Brand Name",
  "description": "Product description",
  "price": 100.00,
  "quantity": 50,
  "category": "Electronics",
  "createdAt": "2024-11-13T12:34:56.789",
  "updatedAt": "2024-11-13T12:34:56.789"
}

4. Update a Product
URL: /api/products/{id}
Method: PUT
Request Body:
json
{
  "name": "Updated Product Name",
  "brand": "Updated Brand",
  "description": "Updated description",
  "price": 120.00,
  "quantity": 40,
  "category": "Electronics"
}
Response:
{
  "id": 1,
  "name": "Updated Product Name",
  "brand": "Updated Brand",
  "description": "Updated description",
  "price": 120.00,
  "quantity": 40,
  "category": "Electronics",
  "createdAt": "2024-11-13T12:34:56.789",
  "updatedAt": "2024-11-13T13:34:56.789"
}

5. Delete a Product
URL: /api/products/{id}
Method: DELETE
Response: HTTP status 204 (No Content).
6. Search Products
URL: /api/products/search
Method: POST
Request Body:
json
{
  "name": "Product Name",
  "brand": "Brand Name",
  "category": "Electronics",
  "minPrice": 50,
  "maxPrice": 200,
  "pageNumber": 0,
  "pageSize": 10,
  "sortBy": "price",
  "sortType": "asc"
}
Response
[
  {
    "id": 1,
    "name": "Product Name",
    "brand": "Brand Name",
    "description": "Product description",
    "price": 100.00,
    "quantity": 50,
    "category": "Electronics",
    "createdAt": "2024-11-13T12:34:56.789",
    "updatedAt": "2024-11-13T12:34:56.789"
  },
  ...
]

Additional Notes
Spring Boot Version: 3.x

Dependencies:

Spring Boot Web
Spring Data JPA
Spring Validation
Lombok
Hibernate
MySQL Driver
Database Configuration:

The application uses MySQL for storing product data.
The created_at and updated_at fields are automatically populated using Hibernate annotations (@CreationTimestamp and @UpdateTimestamp).
Pagination & Sorting:

All GET endpoints for listing products support pagination and sorting.
The default values for pagination are 10 items per page, with sorting based on updatedAt.
Testing
For testing the API endpoints, you can use Postman or Swagger:

Postman: Import the provided Postman collection (if available) to test the endpoints.
Swagger UI: Access Swagger at http://localhost:8080/swagger-ui/ if Swagger is configured.
Conclusion
This Catalog Management System allows efficient management of products with features like pagination, searching, and CRUD operations. The system is built using Spring Boot, and it supports a RESTful API for seamless integration.


