# funding-match
A service to match funding requests with funding products

## Getting Started

This is a simple Sprint Boot application using the Gradle build system. 

You can run the application via an IDE or using the following command line:

```shell
gradle bootRun
```

Once the app is running you can verify it is working by calling the following endpoint:

```shell

% curl http://127.0.0.1:8080/allProducts
% [{"name":"Funding Product 1","funder":"Funder A","maximumTermMonths":12,"price":3.49},{"name":"Funding Product 2","funder":"Funder A","maximumTermMonths":24,"price":3.19},{"name":"Funding Product 3","funder":"Funder B","maximumTermMonths":6,"price":2.25},{"name":"Funding Product 4","funder":"Funder B","maximumTermMonths":12,"price":1.0},{"name":"Funding Product 5","funder":"Funder C","maximumTermMonths":48,"price":0.07}]     

% curl 'http://127.0.0.1:8080/findMatches?industry=farming&companyType=PARTNERSHIP&fundingAmount=15000&currentDebt=50000'
% []
```
`
## How to Run the Tests

You can run the tests via an IDE or using the following command line:

```shell
gradle test
```
