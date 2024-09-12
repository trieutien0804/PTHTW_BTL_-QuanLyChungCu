# Apartment Management System
## 1. Introduction	
 The Apartment Management System is a web-based application designed to help apartment building management teams handle tasks such as apartment unit management, resident management, and building services. The system aims to provide an efficient solution for tracking and managing information related to apartments and residents in a structured and organized way.

## 2. Features
Manage apartment unit information.
Manage residents in each apartment unit.
Oversee building services and facilities.
Send notifications and messages to residents.
Provide fast search and sorting capabilities.

## 3. Technologies Used
This project is built with the following technologies:
Back-end: Java Spring Framework
Front-end: HTML, CSS, JavaScript
Database: MySQL
Project Management: Maven

## 4. Installation
To run this project on your local machine, follow the steps below:

### 4.1. System Requirements
Java 8 or higher
Maven
MySQL Server
IDE with Spring Boot support (e.g., IntelliJ IDEA, Eclipse)
### 4.2. Setup
#### 1. Clone the repository:
git clone https://github.com/trieutien0804/PTHTW_BTL_-QuanLyChungCu.git

#### 2. Configure the Database:
Create a new MySQL database named quanlychungcu.

Update the connection settings in the application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3306/quanlychungcu
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

#### 3. Run the project:

Open the project in your IDE.

Run the Maven command to install dependencies:

mvn clean install
Start the application using the following command:

mvn spring-boot:run
#### 4. Access the application:

Once the server is up and running, open your browser and visit:

http://localhost:8080
## 5. Usage
Log in with admin credentials to manage building and resident information.
Use the admin dashboard to add, edit, or delete apartment units and residents.
Monitor service information and send notifications through the control panel.
## 6. Contribution
If you'd like to contribute to the project, follow these steps:

Fork the repository.
Create a new branch from main for your changes.
Submit a Pull Request for review and merging.
## 7. Contact
For any questions or issues related to this project, feel free to contact me at: trieutien0804@gmail.com.
