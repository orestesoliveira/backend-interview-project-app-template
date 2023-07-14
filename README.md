# NinjaOne Backend Interview Project

This project contains [Instructions](INSTRUCTIONS.md) that must be read in order to perform NinjaOne's code assessment.
Also the project is configured to use an in-memory H2 database that is volatile. If you wish to make it maintain data on
application shut down, you can change the spring.database.jdbc-url to point at a file like `jdbc:h2:file:/{your file path here}`

## Starting the Application

Run the `BackendInterviewProjectApplication` class

Go to:
* http://localhost:8080/sample/1
* http://localhost:8080/sample/2

You should see results for both of these. The application is working and connected to the H2 database. 

## H2 Console 

In order to see and interact with your db, access the h2 console in your browser.
After running the application, go to:

http://localhost:8080/h2-console

Enter the information for the url, username, and password in the application.yml:

```yml
url: jdbc:h2:mem:localdb
username: sa 
password: password
```

You should be able to see a db console now that has the Sample Repository in it.

Type:

```sql
SELECT * FROM SAMPLE;
````

Click `Run`, you should see two rows, for ids `1` and `2`

### Suggestions

Feel free to remove or repurpose the existing Sample Repository, Entity, Controller, and Service. 


-------
Orestes Oliveira

URLS Postman workspace

TO insert need to submi via post the following json 2 times, on the first try u get a exception because the DeviceType object cannot be found.
```JSON

{
    "id": 99,
    "systemName": "Dev Server test Random name 12",
    "deviceType": {
        "id": 1,
        "description": "Windows Workstation 443"
    }
    ,
    "services": [
        {
            "id": 9,
            "serviceName": "Testing Service 5",
            "value": 300.00
        },
        {
            "id": 10,
            "serviceName": "Testing Service 6",
            "value": 500.00
        },
        {
            "id": 11,
            "serviceName": "Testing Service 7",
            "value": 400.00
        }
    ]
}

```



```agsl

http://localhost:8080/type/1

http://localhost:8080/service/1
```


relation fetching

http://localhost:8080/device/1

```json

{
    "id": 1,
    "systemName": "Dev Server test 1",
    "deviceType": {
        "id": 1,
        "description": "Windows Workstation",
        "hibernateLazyInitializer": {}
    },
    "services": [
        {
            "id": 1,
            "serviceName": "Testing Service 1",
            "value": 300.00
        },
        {
            "id": 3,
            "serviceName": "Testing Service 3",
            "value": 500.00
        },
        {
            "id": 2,
            "serviceName": "Testing Service 2",
            "value": 400.00
        }
    ]
}


```