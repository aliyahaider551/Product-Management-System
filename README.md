# Product Management System (Java)

This project is a **Product Management System** developed in Java. It enables users to manage products across different categories such as **Electronics**, **Clothing**, and **Furniture**. The system provides functionalities for adding, updating, listing, and searching products, as well as calculating stock values and finding the highest-rated products.

## Features

1. **Add Products**: Add new products to the system with attributes like name, ID, quantity, imported status, rating, company, and price.
2. **Update Products**: Update the price or stock of products by name or ID.
3. **Bulk Product Addition**: Add products in bulk by reading from a file.
4. **Search Products**: Search products by name or ID.
5. **List Products**: Display all products in a specific category.
6. **Calculate Stock Value**: Compute the total stock value for each category.
7. **Find Highest-Rated Product**: Identify the product with the highest rating in each category.

---

## Project Structure

The project is organized into the following classes:

### 1. **`Product_G5`**
- Represents a single product.
- **Attributes**:
  - `name`: Name of the product.
  - `ID`: Unique identifier for the product.
  - `quantity`: Quantity available in stock.
  - `imported`: Boolean indicating if the product is imported.
  - `rating`: Rating of the product (out of 5).
  - `Company`: Name of the product's company.
  - `price`: Price of the product.
- **Key Methods**:
  - `totalPrice()`: Calculates the total price based on quantity.
  - `toString()`: Returns a string representation of the product.

### 2. **`ProductTypes_G5` (Abstract Class)**
- Represents a category of products (Electronics, Clothing, or Furniture).
- **Attributes**:
  - `Categoryname`: Name of the category.
  - `ID`: Unique identifier for the category.
  - `product`: A list of products in the category.
- **Key Methods**:
  - `AddProduct()`: Adds a product to the category.
  - `searchByID(int ID)`: Searches for a product by its ID.
  - `searchByName(String name)`: Searches for a product by its name.
  - `updatePrice()`: Updates the price of a product.
  - `updateQuantity()`: Updates the quantity of a product.
  - `FindHighestRating()`: Finds the highest-rated product in the category.
  - `stockPrice()`: Calculates the total stock value of the category.

### 3. **`Electronics_G5`, `Clothing_G5`, `Furniture_G5`**
- Subclasses of `ProductTypes_G5` representing specific product categories.
- Each class initializes the category with its name and ID.

### 4. **`ProductManager_G5`**
- The main class that interacts with the user and provides a menu-driven interface.
- **Key Functionalities**:
  - Display menu options.
  - Add products to specific categories.
  - Bulk addition of products from a file.
  - Update product details.
  - Calculate and display stock value.
  - List all products in a category.
  - Find the highest-rated product.

