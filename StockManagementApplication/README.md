#Stock management API

#### API know how
This application Web Service runs on a docker container using embedded tomcat in spring boot
and uses Postgresql which also runs on a docker container.

This application loads the data in the database from the data.sql file placed in src/main/resources path.
The application also has Swagger enabled to view the APi document , and it can be viewed using this url 
http://localhost:8081/stock-api-docs after application startup.

#### How to build the project:
- Clone the project from git repository.
- Import as a maven project in IDE using pom.xml of the application
- Do a maven build with goal "clean install"

#### How to run the application and Postgresql in Docker
(Assumption- Docker is running on system)
- Open a terminal.
- Navigate to the project base path which contains the docker-compose.yml.
- Run the below command

	$ docker-compose up


#### Quick test
##### Scenario 1:> To fetch all available stock details in postman:

- Select method as GET
- Request url: localhost:8081/api/stocks
- Select Params
- under Query Params table provide the below values:
	For column KEY put offset and for column VALUE put 1

- Sample response JSON:

	{
	  "content": [
	    {
	      "id": 4,
	      "name": "Tesla",
	      "currentPrice": 500.0,
	      "lastUpdate": "2022-02-14 23:45:48.12 PM"
	    },
	    {
	      "id": 5,
	      "name": "TCS",
	      "currentPrice": 200.0,
	      "lastUpdate": "2022-01-28 11:14:08.12 AM"
	    },
	    {
	      "id": 6,
	      "name": "CTS",
	      "currentPrice": 550.0,
	      "lastUpdate": "2022-02-23 01:10:18.11 AM"
	    }
	  ],
	  "pageable": {
	    "sort": {
	      "sorted": false,
	      "unsorted": true,
	      "empty": true
	    },
	    "pageNumber": 1,
	    "pageSize": 3,
	    "offset": 3,
	    "paged": true,
	    "unpaged": false
	  },
	  "totalPages": 3,
	  "totalElements": 8,
	  "last": false,
	  "sort": {
	    "sorted": false,
	    "unsorted": true,
	    "empty": true
	  },
	  "numberOfElements": 3,
	  "first": false,
	  "size": 3,
	  "number": 1,
	  "empty": false
	}

##### Scenario 2:> To fetch stock details for supplied id in postman

- Select method as GET
- Request url: localhost:8081/api/stocks/1
  Here 1 is a path variable which is the stock id to be supplied.

- Sample response is as below:

	{
	    "id": 1,
	    "name": "Google",
	    "currentPrice": 100.0,
	    "lastUpdate": "2022-01-28 11:14:08 AM"
	}

##### Scenario 3:> To create a new stock in postman

- Select method as POST
- Request url: localhost:8081/api/stocks
- Request body is below:

	{
        "name":"Yahoo",
        "currentPrice": 175
    }

- Sample response is as below:

	{
	    "id": 9,
	    "name": "X",
	    "currentPrice": 175.0,
	    "lastUpdate": "2022-01-30 03:10:57 AM"
	}
	
##### Scenario 4:> To update a stock's price in postman

- Select method as PATCH
- Request url: localhost:8081/api/stocks/2
  Here 2 is a path variable which is the stock id to be supplied.
- Sample request body is as below:

	{
        "currentPrice": 500
    }

- Sample response is as below:

	{
	    "id": 2,
	    "name": "Amazon",
	    "currentPrice": 500.0,
	    "lastUpdate": "2022-01-30 03:13:43 AM"
	}

##### Scenario 5:> To delete a stock in postman

- Select method as DELETE
- Request url: localhost:8081/api/stocks/2
  Here 2 is a path variable which is the stock id to be supplied.
- Status Code: 204 No Content

#### Improvements to make

- Code coverage for unit tests could be improved so that it covers all possible cases.
- We can implement caching so that the application performs faster.
- We can implement filters to validate data for further improvements.

Note: This application uses LOMBOK annotations so please enable option for Lombok annotations in the IDE if required.