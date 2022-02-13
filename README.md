# HRMS-SERVICE install

## For running hrms application

  ```
  cd ~\hrms-service\docker
  ```
  ```
  docker-compose up
  ```
 
 
 ## if you want to re-build docker image;
 
  ```
  cd ~\hrms-service
  ```
  ```
  mvnw install
  ```
 

# For Use

  ## User service
  `Save User`
  ```
  curl -X POST "http://localhost:8080/v1/api/user/saveUser" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"email\": \"cihathan@cihathan\", \"firstName\": \"cihathan\", \"lastName\": \"toparlak\", \"password\": \"test\", \"phoneNumber\": \"545454552\"}"
  ```

`Save Cv`

```
curl -X POST "http://localhost:8080/v1/api/cv/saveCv" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"address\": \"Konya\", \"educationInfos\": [ { \"cvId\": 0, \"education\": \"Konya\", \"educationPeriod\": \"string\", \"id\": 0 } ], \"id\": 0, \"jobExperiences\": [ { \"cvId\": 0, \"id\": 0, \"jobDescription\": \"string\", \"workPlace\": \"string\", \"yearsOfExperience\": \"string\" } ], \"jobSkills\": [ { \"cvId\": 0, \"id\": 0, \"jobSkill\": \"string\" } ], \"userId\": 0}"
```

## alternate http://localhost:8080/swagger-ui.html#
