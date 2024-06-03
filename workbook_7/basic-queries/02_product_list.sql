-- Question 1: What is the name of the table that holds the items Northwind sells?
SELECT ProductName FROM products;

-- Question 2: Write a query to list the product id, product name, and unit price of every product.
SELECT ProductID, ProductName, UnitPrice FROM products;

-- Question 3: Write a query to list the product id, product name, and unit price of every product. Except this time, order them in ascending order by price.
SELECT ProductID, ProductName, UnitPrice FROM products ORDER BY UnitPrice ASC;

-- Question 4: What are products that we carry where the unit price is $7.50 or less?
SELECT ProductName, UnitPrice FROM products WHERE UnitPrice <= 7.50;

-- Question 5: What are the products that we carry where we have at least 100 units on hand? Order them in descending order by price.
SELECT ProductName, UnitPrice FROM products WHERE UnitsInStock >= 100 ORDER BY UnitPrice DESC;

-- Question 6: What are the products that we carry where we have at least 100 units on hand? Order them in the descending order by price. If two or more have the same price, list those in ascending order by product name.
SELECT ProductName, UnitPrice FROM products WHERE UnitsInStock >= 100 ORDER BY UnitPrice DESC, ProductName ASC;

-- Question 7: What are the products that we carry where we have no units on hand, but 1 or more units of them in backorder? Order them by product name.
SELECT ProductName, UnitsInStock, UnitsOnOrder FROM products WHERE UnitsOnHand = 0 AND UnitsOnOrder >= 1 ORDER BY ProductName;

-- Question 8: What is the name of the table that hold the types (categories) of the items Northwind sells?
SELECT CategoryName FROM categories;

-- Question 9: Write a query that lists all of the columns and all of the rows of the categories table? What is the category id of seafood?
SELECT * FROM categories;
SELECT CategoryID FROM categories WHERE CategoryName = 'Seafood';

-- Question 10: Examine the Products table. How does it identify the type (category) of each item sold? Write a query to list all of the seafood items we carry.
SELECT ProductName, CategoryID FROM products WHERE CategoryID = (SELECT CategoryID FROM categories WHERE CategoryName = 'Seafood');

-- Question 11: What are the first and last names of all of the Northwind employees?
SELECT FirstName, LastName FROM employees;

-- Question 12: What employees have "manager" in their titles?
SELECT * FROM employees WHERE Title LIKE '%manager%';

-- Question 13: List the distinct job titles in employees.
SELECT DISTINCT Title FROM employees;

-- Question 14: What employees have a salary that is between $2000 and $2500.
SELECT FirstName, LastName, Salary FROM employees WHERE Salary BETWEEN 2000 AND 2500;

-- Question 15: List all of the information about all of Northwind's suppliers.
SELECT * FROM suppliers;

-- Question 16: Examine the Products table. How do you know what supplier supplies each product? Write a query to list all of the items that "Tokyo Traders" supplies to Northwind.
SELECT * FROM Products WHERE SupplierID = (SELECT SupplierID FROM suppliers WHERE CompanyName = 'Tokyo Traders');