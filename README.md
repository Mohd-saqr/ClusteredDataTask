# ClusteredData Warehouse


## Description
This project is a Spring Boot application that handles deals and provides an API to save deals.

## Technologies Used
- Java 8
- Spring Boot 
- PostgreSQL
- Docker

## Setup Instructions
1. Clone the repository.
2. Configure the PostgreSQL database by modifying the `application.properties` file. Update the following properties 
 spring.datasource.url
 spring.datasource.username
 spring.datasource.password

# Running the Project with Eclipse
1. Open Eclipse. 
 2. Click on File in the menu bar, then select  Import Maven then  Existing Maven Projects
In the dialog that appears, select Directory and click Browse to navigate to the directory where you cloned the project. Click Finish or Open to import the project.
3. Once the project is imported,  go to  src/main/java/ClusteredDataTaskApplication.java 
Right-click on  class and select Run As > Java Application to run the application.


## Run With Docker
1. Clone the repository.

### Running with Docker
1. Navigate to the project's root directory.
2. Open the `docker-compose.yml` file.
3. Update the environment variables for the `db` service:
 - `POSTGRES_USER`: Set the desired username for the PostgreSQL database.
 - `POSTGRES_PASSWORD`: Set the desired password for the PostgreSQL database.
 - `POSTGRES_DB`: Set the desired name for the PostgreSQL database.
4. Save the `docker-compose.yml` file.
5. Open a terminal or command prompt and navigate to the project's root directory.
6. Run the following command to start the Docker containers:
 `` docker-compose up``

## API Endpoints
- `POST  http://localhost:8080/api/save_deal`
- Description: Saves a deal.
- Request Body:
 ```
 {
   "fromCurrency": "<from currency>",
   "toCurrency": "<to currency>",
   "dealDate": "<deal date>",
   "dealAmount": <deal amount>
 }
 ```
- Response:
 ```
 {
   "massage": "Deal Processed Successfully",
   "status": "CREATED"
   "time"  :"Current time"
 }
 ```
- Response (Duplicate Deal):
 ```
 {
   "massage": "Failed to save the deal. The deal already exists.",
   "status": "BAD_REQUEST"
   "time"  :"Current time"
 }
 ```
- Response (Business Exception):
 ```
 {
   "massage": "Failed to save the deal.",
   "status": "BAD_REQUEST"
   "time"  :"Current time"
 }
 ```

## Testing API
To test the application, you can perform the following test cases:

- **Test Case 1: Saving a New Deal**
- Description: Tests the successful saving of a new deal.
- Steps:
1. Send a `POST` request to `/api/save_deal` with a valid deal JSON in the request body.
2. Verify that the response status is `201 Created`.
3. Verify that the response body contains the message `"Deal Processed Successfully"`.

- **Test Case 2: Saving a Duplicate Deal**
- Description: Tests the scenario where a duplicate deal is provided.
- Steps:
1. Send a `POST` request to `/api/save_deal` with a deal JSON that already exists in the database.
2. Verify that the response status is `400 Bad Request`.
3. Verify that the response body contains the message `"Failed to save the deal. The deal already exists."`.

- **Test Case 3: Saving a Deal with Invalid Data**
- Description: Tests the scenario where invalid data is provided in the deal.
- Steps:
1. Send a `POST` request to `/api/save_deal` with a deal JSON that contains invalid data (e.g., negative deal amount).
2. Verify that the response status is `400 Bad Request`.
3. Verify that the response body contains the message `"Invalid deal data provided."`.

You can perform these test cases using a tool like Postman.

### Running the Test Cases with Maven
1. Open a terminal or command prompt.
2. Navigate to the root directory of your project (where the `pom.xml` file is located).
3. Run the following command to execute the tests:
```shell
mvn test