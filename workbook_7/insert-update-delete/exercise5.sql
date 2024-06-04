-- Question 1: Add a new supplier.
INSERT INTO suppliers (SupplierID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)
VALUES (1337, 'Shed Supply', 'John Doe', 'CEO', '123 Street Drive', 'Charlotte', 'North Carolina', '12345', 'United States', '123-456-7890', '123-456-7891', 'https://google.com');

-- Question 2: Add a new product provided by that supplier.
INSERT INTO products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) VALUES (1111, 'New Product', 1337, 2337, 5, 5, 5, 0, 0, 0);

-- Question 3: List all products and their suppliers.
SELECT p.ProductName, s.CompanyName FROM products p JOIN suppliers s ON p.SupplierID = s.SupplierID;

-- Question 4: Raise the price of your new product by 15%.
UPDATE products SET UnitPrice = UnitPrice * 1.15 WHERE ProductID = 1111;

-- Question 5: List the products and prices of all products from that supplier.
SELECT p.ProductName, p.UnitPrice FROM products p JOIN suppliers s ON p.SupplierID = s.SupplierID WHERE s.CompanyName = 'Shed Supply';

-- Question 6: Delete the new product.
DELETE FROM products WHERE ProductID = 1111;

-- Question 7: Delete the new supplier.
DELETE FROM suppliers WHERE SupplierID = 1337;

-- Question 8: List all products.
SELECT * FROM products;

-- Question 9: List all suppliers.
SELECT * FROM suppliers;