# solutio_spring_boot_demo

This is a microservice built using Spring Boot and Maven. 
This a example on how to connect to the Twitter API and save some tweets.

## Installation

Create an application.yml on resource folder. (Template below)
Run as spring boot application. If you need, add Dockerfile to run in docker. More info at [docker homepage](https://www.docker.com/) 


```bash
$ mvn spring-boot:run
```

## Usage
If you wish more info about the endpoints, the app comes with and OpenAPI docs.
Set your api key / secret and token key / secret in application.yml 
Set the port and contextPath and boot the application.

## Application properties template

```yaml

server:
  servlet.contextPath: "/api"
  port: 8080

spring:
   data.mongodb:
         port: 27017
         host: localhost
         database: Twitter

twitter:
   app:
       minFollowers: 1500
       allowedLanguages: "es,it,fr" 
          
   config: #Set your keys here
      apiKey: #your key here
      apiSecret: #your key here
      token: #your key here
      tokenSecret: #your key here
      spainWOEID: 23424950 #Make sure this is always de same value for Spain
```
## Where are the documentation?
Once app is running, you can find in:

```bash
http://localhost:${server.port}${server.servlet.contextPath}/swagger-ui.html
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)