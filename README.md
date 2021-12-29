# Airport Assessment

### Run the Application
./gradlew bootRun


### Airport API Endpoint Details

1. Runways for each airport given a country code or country name: **GET /airports/runways/{country}**

`curl --request GET \
--url http://localhost:8080/airports/runways/{country} \`

2. Top 10 countries with highest number of airports: **GET /airports/countries/highest**

`curl --request GET \
--url http://localhost:8080/airports/countries/highest \`


### Bonus feature Implemented

Retrieving the information given a partial/fuzzy country code/name as input parameter.

### Frameworks
1. Java
2. SpringBoot
3. H2 Database
4. Lombok