-- Question 1: What is the product name(s) of the most expensive products? HINT: Find the max price in a subquery and then use that value to find products whose price equals that value.
SELECT ProductName FROM products WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM products);

-- Question 2: What is the order id, shipping name and shipping address of all orders shipped via "Federal Shipping"? HINT: Find the shipper if of "Federal Shipping" in a subquery and then use that value to find the orders that used the shipper.
SELECT OrderID, ShipName, ShipAddress FROM orders WHERE ShipVia = (SELECT ShipperID FROM shippers WHERE CompanyName = 'Federal Shipping');

-- Question 3: What are the order ids of the orders that ordered "Sasquatch Ale"? HINT: Find the product id of "Sasquatch Ale" in a subquery and then use that value to find the matching orders from the `order details` table. Because the `order details` table has a space in its name, you will need to surround it with back ticks in the FROM clause.
SELECT OrderID FROM `Order Details` WHERE ProductID = (SELECT ProductID FROM products WHERE ProductName = 'Sasquatch Ale');

-- Question 4: What is the name of the employee that sold order 10266?
SELECT e.FirstName, e.LastName FROM employees e JOIN orders o ON e.EmployeeID = o.EmployeeID WHERE o.OrderID = 10266;

-- Question 5: What is the name of the customer that bought order 10266?
SELECT c.CompanyName FROM customers c JOIN orders o ON c.CustomerID = o.CustomerID WHERE o.OrderID = 10266;