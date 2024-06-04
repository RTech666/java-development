-- Question 1: List the product id, product name, unit price and category name of all products. Order by category name and within that, by product name.
SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName FROM products p JOIN categories c ON p.CategoryID = c.CategoryID ORDER BY c.CategoryName, p.ProductName;

-- Question 2: List the product id, product name, unit price and supplier name of all products that cost more than $75. Order by product name.
SELECT p.ProductID, p.ProductName, p.UnitPrice, s.CompanyName FROM products p JOIN suppliers s ON p.SupplierID = s.SupplierID WHERE p.UnitPrice > 75 ORDER BY p.ProductName;

-- Question 3: List the product id, product name, unit price, category name, and supplier name of every product. Order by product name.
SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName, s.CompanyName FROM products p JOIN categories c ON p.CategoryID = c.CategoryID JOIN suppliers s on p.SupplierID = s.SupplierID ORDER BY p.ProductName;

-- Question 4: What is the product name(s) and categories of the most expensive products? HINT: Find the max price in a subquery and then use that in your more complex query that joins products with categories.
SELECT p.ProductName, c.CategoryName FROM products p JOIN categories c ON p.CategoryID = c.CategoryID WHERE p.UnitPrice = (SELECT MAX(UnitPrice) FROM products);

-- Question 5: List the order id, ship name, ship address, and shipping company name of every order that shipped to Germany.
SELECT o.OrderID, o.ShipName, o.ShipAddress, s.CompanyName FROM orders o JOIN shippers s ON o.ShipVia = s.ShipperID WHERE o.ShipCountry = 'Germany';

-- Question 6: List the order id, order date, ship name, ship address of all orders that ordered "Sasquatch Ale"?
SELECT o.OrderID, o.OrderDate, o.ShipName, o.ShipAddress FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID JOIN products p ON od.ProductID = p.ProductID WHERE p.ProductName = 'Sasquatch Ale';