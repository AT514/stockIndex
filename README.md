# StockIndex

This a spring boot application. 
When the application is run, it will load data set from dow_jones_index.csv file into in memory H2 database.


## Testing 
In order to test the application, JUnit tests in *StockIndexApplicationTests* can be executed to test the functionality.
When running the application locally, the server port is set to *5000*



URLS for REST services 
* GET     http://localhost:5000/dowjones/stockIndexes/  ---   Fetches all the Stock data in mem database.
* POST    http://localhost:5000/dowjones/stockIndexes/   ---  create new Stock object as shown below to post it

```
{
    "quarter": 3,
    "stock": "ABC",
    "date":"08/24/2020",
    "open":"$111.0",
    "high":"$555.0",
    "low":"$99.0"
}
```

*  GET Stock by Id   http://localhost:5000/dowjones/stockIndexes/ABC  ---   fetches stock just created.   
