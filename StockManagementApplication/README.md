##Stock management API

#### API know how
This application Web Service runs on a docker container using embedded tomcat in spring boot
and uses Postgresql which also runs on a docker container.

#### How to build the project:
- Clone the project from git repo.
- Import as a maven project in IDE using pom.xml of the application
- Do a maven build with goal "clean install"

#### Run the application and Postgresql in Docker
Navigate to the project base path which contains the docker-compose.yml and run the below command
 $ docker-compose up


#### Quick test
##### Scenario 1:> To fetch all available stock details

- Select method as GET
- Request url: localhost:8081/api/stocks
- Query Params:
{
    KEY=offset,
    VALUE=1
}
- The example response recieved to a sucessfull request would be as below:-
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

##### Scenario 2:> To fetch stock details for supplied id

- Select method as GET
- Request url: localhost:8081/api/stocks/1
     Here 1 is a path variable which is the stock id to be supplied.

- The example response received to a successful request would be as below:-
{
    "id": 1,
    "name": "Google",
    "currentPrice": 100.0,
    "lastUpdate": "2022-01-28 11:14:08 AM"
}

##### Scenario 3:> To create a new stock

- Select method as POST
- Request url: localhost:8081/api/stocks
- Request body is below:-

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
	
##### Scenario 4:> To update a stock's price

- Select method as PATCH
- Request url: localhost:8081/api/stocks/2
     Here 2 is a path variable which is the stock id to be supplied.
- Request body is below:-

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


#### Improvements to make

- Code coverage for unit tests could be improved.
- Exception handling could be improved.
- Caching can be introduced.

