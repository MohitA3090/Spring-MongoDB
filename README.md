# Spring-MongoDB

This is a dockerized application created using Spring framework and MongoDB as backened database. Follow the below instructions to run the application:
```
 git clone https://github.com/MohitA3090/Spring-MongoDB.git
 cd Spring-MongoDB
 mkdir temp
 docker-compose -d up
```
Use `docker container ls` to see that the dockers are up and running. 

Use Postman (or any other tool) to test the application, following APIs are available:

- To list all employees (GET) <br>
  http://localhost:8080/app/v1/employees
 
- To get an employee (GET) <br>
  http://localhost:8080/app/v1/employees/employee_id
  
- To add an employee (POST) <br>
  http://localhost:8080/app/v1/employees
  ```
  {
     "firstName":"Jason",
     "lastName":"Bourne",
     "emailId":"abc@gmail.com"
  }
  ```
- To update an employee (PUT) <br>
  http://localhost:8080/app/v1/employees/employee_id
  
  ```
  {
     "firstName":"Jason",
     "lastName":"Bourne",
     "emailId":"abc@gmail.com"
  }
  ```
- To delete an employee (DELETE) <br>
  http://localhost:8080/app/v1/employees/employee_id
  