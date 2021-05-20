# URL-Shortner API Using java and SQL Database (H2)

## Setup

* Install Java 15
* Install Maven

Run the below commands in the core

```
mvn clean
```

```
mvn install
```

Execute any of the two commands below to run the application

```
java -jar target/url-shortner-h2-db-0.0.1-SNAPSHOT.jar
```

```
mvn spring-boot:run
```

The Default port is 9090 and base-url is set to /scapula (both can be changed in application.properties)

---

# API

POST request to http://localhost:9090/scapula/url with the url to shorten in the request-body

* Sample Response

```
{
    "id": "wzdavnzc",
    "originalValue": "https://github.com/hardikSinghBehl",
    "visitors": 0,
    "createdAt": "2021-05-20T16:19:09.116648"
}
```

The Received id is the shortened-url and can be used in the following form 
* http://localhost:9090/scapula/url/{recievedId}
* Will be redirected to the orginal url on success

