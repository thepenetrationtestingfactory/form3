# form3
REST API example for form3

This is a maven project built in Java 8, Spring and Nitrite NoSQL data base (http://www.dizitart.org/nitrite-database/) to provide persistence for the payments loaded from http://mockbin.org/bin/41ca3269-d8c4-4063-9fd5-f306814ff03f and created using the rest API

To build the project

mvn clean install

To run it using the embedded Jetty server:

mvn jetty:run

The server will be running at http://localhost:8090/ and the rest API at http://localhost:8090/api/payments/

Once the application is started a new file is created in the file system (/tmp/form3.db) to store the data base. This data base will be populated with the payments from http://mockbin.org/bin/41ca3269-d8c4-4063-9fd5-f306814ff03f in order to have some initial data to operate.

There are four different entry points methods:

/api/payments/ 				GET 	-> finds all payments in db

/api/payments/{id}			GET		-> finds the payment which id is passed as parameter

/api/payments/create/		POST	-> creates a new payment with the data passed in the body of the request
/api/payments/delete/{id}	DELETE	-> deletes the payment which id is passed as parameter returning true/false in case deletion was successful/unsuccessful	

/api/payments/update/{id}	POST	-> update the payment which id is passed as parameter with the data passed in the body of the request




