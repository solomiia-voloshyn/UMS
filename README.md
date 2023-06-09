# User Management System

## Description
This project is a Web App with user management interface.
You can Log In as Admin with possibility to create new user, update users.

## <img alt="" src="https://img.icons8.com/external-flaticons-flat-flat-icons/452/external-functionality-no-code-flaticons-flat-flat-icons.png" width="50" style="margin-bottom:-15px"> Available functionality
- create user
- authorization
- get user
- get all users

## Technologies
- Java 17
- PostgreSQL
- Gradle
- Spring Web
- Spring Data
- Spring Boot

## <img alt="" src="https://img.icons8.com/office/452/parallel-tasks.png" width="50" style="margin-bottom:-15px"> Project structure
3-Tier Architecture
- Controller
- Service
- Model
- Spring Security

## Steps required to get started
1. CREATE DATABASE with name user_db;
2. add your password and username to properties file

Example
>spring.datasource.url=jdbc:postgresql://localhost:5432/user_db
>
>spring.datasource.username=USERNAME
>
>spring.datasource.password=PASSWORD
>
>spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL81Dialect

3. Run application

