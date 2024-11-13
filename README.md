# Catalog Management System

This is a Spring Boot application designed for managing a catalog of products, featuring product creation, retrieval, updating, deletion, and search functionality with pagination support.

## Requirements

- **Java 17** (Ensure `JAVA_HOME` is set to Java 17)
- **Maven** (to build the project)
- **MySQL Database** (or any other supported database, with necessary configuration in `application.properties`)

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd catalog-management-system

 ## API Endpoints

Below are the API endpoints available in this Catalog Management System.

### 1. Create Product
- **URL**: `/api/products/create-product`
- **Method**: `POST`
- **Description**: Creates a new product with the provided details.
- **Request Body**:
  ```json
  {
    "name": "Product1",
    "brand": "BrandX",
    "category": "CategoryA",
    "price": 99.99
  }

 Get All Products (Paginated)
URL: /api/products/get-products
Method: POST
Description: Retrieves all products, paginated and sorted by specified fields.
Request Body:
json
Copy code
{
  "pageNumber": 0,
  "pageSize": 10,
  "sortBy": "price",
  "sortType": "asc"
}

Response:
Status: 200 OK
Body:
json
Copy code
[
  {
    "id": 1,
    "name": "Product1",
    "brand": "BrandX",
    "category": "CategoryA",
    "price": 99.99
  },
  ...
]
 Get Product by ID
URL: /api/products/{id}
Method: GET
Description: Retrieves a product by its unique ID.
Path Parameter:
id (Long): The unique ID of the product.
Response:
Status: 200 OK
Body:
json
Copy code
{
  "id": 1,
  "name": "Product1",
  "brand": "BrandX",
  "category": "CategoryA",
  "price": 99.99,
  "createdAt": "2024-11-13T00:00:00",
  "updatedAt": "2024-11-13T00:00:00"
}
4. Update Product
URL: /api/products/{id}
Method: PUT
Description: Updates an existing product's details.
Path Parameter:
id (Long): The unique ID of the product to be updated.
Request Body:
json
Copy code
{
  "name": "UpdatedProduct",
  "brand": "BrandX",
  "category": "CategoryA",
  "price": 120.00
}
Response:
Status: 200 OK
Body:
json
Copy code
{
  "id": 1,
  "name": "UpdatedProduct",
  "brand": "BrandX",
  "category": "CategoryA",
  "price": 120.00,
  "createdAt": "2024-11-13T00:00:00",
  "updatedAt": "2024-11-14T00:00:00"
}
5. Delete Product
URL: /api/products/{id}
Method: DELETE
Description: Deletes a product by its ID.
Path Parameter:
id (Long): The unique ID of the product.
Response:
Status: 204 No Content
6. Search Products
URL: /api/products/search
Method: POST
Description: Searches for products based on filters like name, brand, category, and price range, with pagination support.
Request Body:
json
Copy code
{
  "name": "Product",
  "brand": "BrandX",
  "category": "CategoryA",
  "minPrice": 50,
  "maxPrice": 150,
  "pageNumber": 0,
  "pageSize": 10,
  "sortBy": "price",
  "sortType": "desc"
}
Response:
Status: 200 OK
Body:
json
Copy code
[
  {
    "id": 1,
    "name": "Product1",
    "brand": "BrandX",
    "category": "CategoryA",
    "price": 99.99
  },
  ...
]
sql
Copy code
