# Banking Project — Backend Only

This project follows the simple Spring Boot/Maven folder structure used in the supplied group-project repositories. It intentionally has no frontend.

## Modules
- Banking: Customer records
- Loan: Loan records
- Insurance: Insurance policy records

## Technologies
Java 17, Spring Boot, Spring Web REST APIs, Spring Data JPA, Hibernate, Maven.
H2 is configured by default for easy first run; MySQL Connector/J is included for optional MySQL setup.

## Run
1. Extract the ZIP.
2. Open Eclipse → File → Import → Maven → Existing Maven Projects.
3. Select the `bankingproject` folder inside the extracted `Banking-Project-Matched` folder.
4. Click Finish and wait for dependencies.
5. Run `BankingprojectApplication.java` as Java Application.
6. Use Postman or Thunder Client to test the APIs.

Terminal option: open a terminal in the `bankingproject` folder and run `mvn spring-boot:run`.

## API routes
Customers: `/api/customer`
Loans: `/api/loan`
Insurance policies: `/api/insurance-policies`

For each module:
- `GET /api/...` list all
- `GET /api/.../{id}` read one
- `POST /api/...` create
- `PUT /api/.../{id}` update
- `DELETE /api/.../{id}` delete

Example customer POST body:
```json
{"name":"Amit Sharma","city":"Pune","phone":"9876543210","email":"amit@example.com"}
```

H2 console: `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:file:./data/bankingdb`; username `sa`; password blank.

This is a learning project, not production banking software. It contains backend APIs only; no frontend is included.
