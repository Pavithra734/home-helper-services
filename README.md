# Home Helper Services

A Spring Boot REST API for managing a Home Helper Service application. The application provides APIs for customers, helpers, bookings, payments, and admin management.

## Features

* Customer registration and login
* Helper registration and login
* Customer management
* Helper management
* Booking creation and management
* Booking status updates
* Payment creation and management
* Admin access to customers, helpers, bookings, and payments
* Exception handling with custom exceptions
* MySQL database integration
* Spring Data JPA
* Password encryption using BCrypt
* RESTful APIs tested using Postman

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Maven
* Postman

## Project Structure

```text
HomeHelperServices
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.homehelper.HomeHelperServices
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── repository
│   │   │       ├── security
│   │   │       ├── service
│   │   │       └── serviceimpl
│   │   └── resources
│   │       └── application.properties
│   └── test
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

## Main Modules

### Customer

Provides APIs for:

* Registration
* Login
* Get all customers
* Get customer by ID
* Update customer
* Delete customer
* Get customer bookings

### Helper

Provides APIs for:

* Registration
* Login
* Get all helpers
* Get helper by ID
* Update helper
* Delete helper
* Get helper bookings

### Booking

Provides APIs for:

* Create booking
* Get all bookings
* Get booking by ID
* Get bookings by customer
* Get bookings by helper
* Update booking
* Update booking status
* Delete booking

### Payment

Provides APIs for:

* Create payment
* Get all payments
* Get payment by ID
* Get payment by booking
* Update payment

### Admin

Provides APIs for:

* Admin login
* View customers
* View customer by ID
* View helpers
* View helper by ID
* View bookings
* View booking by ID
* View payments
* View payment by ID

## API Endpoints

### Customer APIs

```text
POST   /api/customers/register
POST   /api/customers/login
GET    /api/customers
GET    /api/customers/{id}
PUT    /api/customers/{id}
DELETE /api/customers/{id}
GET    /api/customers/{id}/bookings
```

### Helper APIs

```text
POST   /api/helpers/register
POST   /api/helpers/login
GET    /api/helpers
GET    /api/helpers/{id}
PUT    /api/helpers/{id}
DELETE /api/helpers/{id}
GET    /api/helpers/{id}/bookings
```

### Booking APIs

```text
POST   /api/bookings
GET    /api/bookings
GET    /api/bookings/{id}
GET    /api/bookings/customer/{customerId}
GET    /api/bookings/helper/{helperId}
PUT    /api/bookings/{id}
PUT    /api/bookings/{id}/status
DELETE /api/bookings/{id}
```

### Payment APIs

```text
POST   /api/payments
GET    /api/payments
GET    /api/payments/{id}
GET    /api/payments/booking/{bookingId}
PUT    /api/payments/{id}
```

### Admin APIs

```text
POST   /api/admin/login
GET    /api/admin/customers
GET    /api/admin/customers/{id}
GET    /api/admin/helpers
GET    /api/admin/helpers/{id}
GET    /api/admin/bookings
GET    /api/admin/bookings/{id}
GET    /api/admin/payments
GET    /api/admin/payments/{id}
```

## Database

The application uses MySQL.

Database configuration is maintained in:

```text
src/main/resources/application.properties
```

The project uses Spring Data JPA and Hibernate for database operations.

## Running the Application

### 1. Clone the Repository

```bash
git clone https://github.com/Pavithra734/home-helper-services.git
```

### 2. Open the Project

Open the project in Eclipse, IntelliJ IDEA, or another Java IDE.

### 3. Configure MySQL

Create the required MySQL database and update the database configuration in:

```text
application.properties
```

### 4. Run the Application

Using Maven Wrapper:

```bash
mvnw spring-boot:run
```

Or run the main Spring Boot class:

```text
HomeHelperServicesApplication.java
```

The application runs on:

```text
http://localhost:8080
```

## API Testing

The REST APIs were tested using Postman.

### Customer Registration

```text
POST http://localhost:8080/api/customers/register
```

Example request:

```json
{
  "name": "Pavithra",
  "email": "pavithra@gmail.com",
  "password": "123456",
  "phone": "9876543210",
  "address": "Hyderabad"
}
```

## Exception Handling

The project contains custom exceptions for:

* Customer not found
* Helper not found
* Booking not found
* Payment not found

A global exception handler is used to handle application exceptions.

## Security

Spring Security is included in the project, and passwords are encrypted using BCrypt before being stored.

## Author

**Pavithra Mekala**

GitHub: [Pavithra734](https://github.com/Pavithra734)
