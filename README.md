# ADBMS_Assignment
This repository contains the code for the Distributed Database Assignment of IN3400 Advance Database Management Systems module.

There are 3 Microservices in this application.
  1) User_Management_Server
  2) Order_Placement_Server
  3) Inventory_Management_Server

User_Management_Server is using MySql and runs on port 8080.
Order_Placement_Server is using MSSql and runs on port 8081.
Inventory_Management_Server is using MongoDB and runs on port 8082.

All 3 Microservices has CRUD operations. 

I have used spring webFlux in order to implement communication mechanisms between the microservices.

Here are the URLs for each microservice APIs.


User_Management_Server
  1) http://localhost:8080/api/user/getUser/{userID} - Get the user information
  2) http://localhost:8080/api/user/{userId} - Check if a user exists with the given user id
  3) http://localhost:8080/api/user/getAll - Get All the users
  4) http://localhost:8080/api/user/updateUser - Update User Information
  5) http://localhost:8080/api/user/deleteUser/{userID} - Delete a user with givern user id

Order_Placement_Server
  1) http://localhost:8081/api/order/createOrder - Create a new order
  2) http://localhost:8081/api/order/getOrder/{orderId} - Get orders with an order id
  3) http://localhost:8081/api/order/getAllOrders - Get all orders
  4) http://localhost:8081/api/order/updateOrder - Update an order information
  5) http://localhost:8081/api/order/deleteOrder/{orderId} - Delete an order with a given order id
  6) http://localhost:8081/api/order/deleteUser/{userId} - Delete all orders of a user with a given user id

Inventory_Management_Server
  1) http://localhost:8082/api/inventory/createInventory - Create an inventory item
  2) http://localhost:8082/api/inventory/getInventory/{itemID} - Get inventory item information with a given item id
  3) http://localhost:8082/api/inventory/getAllInventory - Get all inventory information
  4) http://localhost:8082/api/inventory/?itemID={itemId}&quantity={quantity} - Check whether an item exists with given quantity
  5) http://localhost:8082/api/inventory/updateInventory - Update inventory item information
  6) http://localhost:8082/api/inventory/updateQuantity?itemID={itemId}&quantity={quantity} - Remove a given item quantity from the inventory
  7) http://localhost:8082/api/inventory/deleteInventory/{itemID} - Delete an item from the inventory


Within these 3 microservice, the following communications occur.
  1) Whenever a order is being placed, Order_Placement_Server communicates with User_Management_Server and check if there is a user with the given id.
  2) Order_Placement_Server communicates with Inventory_Management_Server to check if the intventory item is available and it has the required quantity.
  3) Order_Placement_Server communicates with Inventory_Management_Server and updates the quantity after each order.
  4) Whenever we delete a user from User_Management_Server, it communicates with Order_Placement_Server and delete all orders of that user from there.
