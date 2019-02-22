# SpringWithMongoDB
SpringBoot with MongoDB POC with the Methods (GET / POST / PUT / DELETE) 

GET : http://localhost:8080/5c6bbb132890ebfd27135196

To get the specific User OBJECT
No request body needed for GET

Response: 
{
  "userId": "5c6bbb132890ebfd27135196",
  "name": "Anjan",
  "creationDate": "2019-02-19T08:15:10.699+0000",
  "userSettings": {
    "bike": "Yamaha R15 V3"
  }
}

POST : http://localhost:8080

To create a User object and stores in MONGODB

Request : 
{
    "name": "Kumar123",
    "creationDate": "2019-02-20T12:42:10.049+0000",
    "userSettings": {
      "bike": "pulsar"
    }
}


Response :
{
    "userId": "1802498573453",
    "name": "Kumar123",
    "creationDate": "2019-02-20T12:42:10.049+0000",
    "userSettings": {
      "bike": "pulsar"
    }
 } 


PUT : http://localhost:8080/1802 

To update the Existing User, need to pass userId in the URL {1802}
Payload should contain each and every field excep id

Request : 
  {
    "name": "Datami",
    "creationDate": "2020-02-20T08:07:38.580+0000",
    "userSettings": {
      "bike": "Yamaha R15",
      "Number": "5163123456",
      "cost" : "165000"
    }
  }
  
 Response:
 {
  "userId": "1802",
  "name": "Datami",
  "creationDate": "2020-02-20T08:07:38.580+0000",
  "userSettings": {
    "bike": "Yamaha R15",
    "Number": "5163123456",
    "cost": "165000"
  }
  }
  
  DELETE : http://localhost:8080/1802
  
  To Delte the user Object you need to pass the user Id in the URL
  No Request body needed
  
  Response : "Successfully deleted"
   
  
  
  
