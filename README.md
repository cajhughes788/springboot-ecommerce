# Vacation Booking Backend – Spring Boot

This is the backend service for a full-stack vacation booking system. Built with Java and Spring Boot, it provides RESTful APIs to manage customers, vacations, excursions, cart operations, and order tracking. It integrates with a MySQL database and serves an Angular frontend.

---

## Features

- RESTful API endpoints for managing:
  - Customers
  - Vacations and Excursions
  - Cart and Cart Items
  - Orders with tracking and status
- Real-time inventory validation
- MySQL database integration with JPA/Hibernate
- Order tracking number generation
- Data validation (e.g., min/max inventory constraints)
- JSON data exchange between frontend and backend

---

## Languages & Tools

- **Java 17**
- **Spring Boot 3**
- **MySQL**
- **Maven**
- **Hibernate / JPA**
- **Lombok**

---

## Development Tools

- IntelliJ IDEA or VS Code
- Git & GitHub
- MySQL Workbench (for database)

---

## API Integration

- Integrated with Angular frontend via HTTP REST APIs

---

## Database Setup

This project uses a MySQL database. A full SQL script is provided in the `/sql` folder to create the schema and insert sample data.

1. Open MySQL Workbench (or your preferred SQL client)
2. Run the following script:
   - `d288_create_and_populate_db_with_status_in_cart_mod_fk.sql`
3. Ensure your MySQL credentials and database name match the values in `application.properties`

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/cajhughes788/springboot-ecommerce.git
   cd springboot-ecommerce

2. Open in IntelliJ or VS Code.

3. Ensure MySQL is running and matches the credentials in application.properties.

4. Build and run the project using:

./mvnw spring-boot:run

5. Backend will be accessible at:

http://localhost:8080

Related Repository
Frontend (Angular):
https://github.com/cajhughes788/vacation-booking-frontend
