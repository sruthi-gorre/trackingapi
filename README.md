# Tracking Number Generator API

This is a Spring Boot REST API that generates unique tracking numbers for parcels.  
It ensures high performance, uniqueness, and is scalable for concurrent access.


## Features

- ✅ RESTful GET API: `/next-tracking-number`
- ✅ Uniqueness ensured via database constraints
- ✅ Compliant with tracking number pattern: `^[A-Z0-9]{1,16}$`
- ✅ Uses MySQL + Spring Data JPA
- ✅ Horizontally scalable

---

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web, JPA, MySQL
- Maven
- Lombok (optional)

---

## 📂 Project Structure
src/main/java/com/example/trackingapi/
├── controller/ # REST controller
├── model/ # JPA entity
├── repository/ # JPA repository
├── service/ # Business logic
└── TrackingApiApplication.java

Create MySQL Database:
CREATE DATABASE trackingdb;

Application Property file:
spring.datasource.url=jdbc:mysql://localhost:3306/trackingdb
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

Build the Project
./mvnw clean install

End Point:
GET /next-tracking-number

Example Request:
GET http://localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2025-07-28T10:00:00Z&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics





