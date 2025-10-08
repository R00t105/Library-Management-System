# Library Management System

A Spring Boot REST API application to manage books, members, and borrowing records in a library.

## Features

- Manage **Books** (Add, Update, Delete, Search)
- Manage **Members** (Add, Update, Delete)
- Record **Borrowing** and **Returning** of books
- Automatically calculate **return dates** based on borrow date
- Track **returned books** and overdue books
- Authentication & Authoraization
- Add Users with Encrypt Password
- JSON input/output support
- Date formatting for readability (`dd-MM-yyyy`)

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security
- Hibernate
- MySQL
- Lombok
- Jackson (for JSON serialization)
- Maven
- DTOs

## Entity Relationships

- **Book** ↔ **BorrowRecord** : One-to-Many
- **Member** ↔ **BorrowRecord** : One-to-Many
- **Author** ↔ **Book** : One-to-Many


