
<h1 align="center" id="title">Spring POS BACKEND</h1>

<p id="description">This project is the backend component for a Point of Sale (POS) system. It is developed using the Spring Framework to handle RESTful API requests. The system is designed with a layered architecture, following best coding practices for maintainability and scalability.

Tech Stack</p>

  
  
<h2>🧐 Features</h2>

Here're some of the project's best features:

*   Manage customers items and orders.
*   Order creation with payment methods (cash/card/mobile).
*   Database: MySQL with Hibernate ORM.
*   Exception handling and validation using Spring Validator.
*   REST API with JSON responses.



<p>1. The application will start on</p>

```
http://localhost:8080
```

<h2>API Endpoints</h2> 

<h3>Customer Endpoints</h3>

  * GET /customer: Retrieve all customers.
  * POST /customer: Create a new customer.
  * PUT /customer: Update an existing customer.
  * DELETE /customer/{id}: Delete a customer by ID.

<h3>Item Endpoints</h3>

  * GET /item: Retrieve all items.
  * POST /item: Create a new item.
  * PUT /item: Update an existing item.
  * DELETE /item/{id}: Delete an item by ID.

<h3>Order Endpoints</h3>

  * POST /order: Create a new order.
  
<h2>💻 Built with</h2>

Technologies used in the project:

*   Spring- Backend framework in java
*   Hibernate- ORM for database interaction
*   Spring Data JPA- Data repository layer
*   MySQL- Database
*   Lombok- To reduce boilerplate code

<h2> API Documentation </h2>

* You can view the detailed API documentation with example requests and responses <a href="https://documenter.getpostman.com/view/35384895/2sAXxV6A1E"here</a>.


<h2>🛡️ License:</h2>

This project is licensed under the MIT License - see the LICENSE file for details.
