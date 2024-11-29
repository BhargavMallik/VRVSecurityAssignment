# **Role-Based Access Control (RBAC) System**

## **Overview**

This project demonstrates a secure **Authentication**, **Authorization**, and **Role-Based Access Control (RBAC)** system implemented using **Spring Boot**. The application ensures secure user management, role assignments, and access control based on defined roles.

---

## **Features**

### **Authentication**
- User registration and login.
- JWT-based session management for stateless authentication.

### **Authorization**
- Access control based on user roles.
- Restricted endpoints for specific roles (e.g., Admin, User, Viewer).

### **Role-Based Access Control (RBAC)**
- Role hierarchy management.
- Granting or revoking access dynamically based on roles.
- Role-specific permissions for secured resources.

---

## **Technologies Used**
- **Spring Boot**: Framework for building the application.
- **Spring Security**: Managing authentication and authorization.
- **MySQL**: Database for storing user credentials and roles.
- **JPA/Hibernate**: ORM for database interaction.

---

## **Setup and Installation**

### **Prerequisites**
- **Java 17**
- **Maven**
- **MySQL** database

### **Steps to Run**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo-url/rbac-system.git
