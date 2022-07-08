# TakeHomeProject

Take Home Project

Project is not fully complete, but I am out of time.

The main issue blocking my progress is my unfamiliarity with WireMock. In the "BookingProcessorGateway.java" file, I'm always returning a null object when running the postForObject method and I'm not sure why.

Assuming the postForObject method worked as intended, I would have created more unit tests to test scenarios where a product could not be booked (lack of inventory).

This is a very bare-bone project. In a real world scenarios, There would be a payment process, a cart system, a check-out system, a task processor to not overload the system and a db to manipulate the inventory as purchases are made and new stock comes in.

Endpoint to retrieve products:
GET http://localhost:8080/products

Endpoint to retrieve product (id 1,2 or 3):
GET http://localhost:8080/products(id)

Endpoint to book product:
POST http://localhost:8080/book/1
