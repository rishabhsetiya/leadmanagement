# Udaan Assignment - Lead Management System

### Project overview

This can be used by Key Account Managers to manage restaurant leads.
We can add/update/delete restaurants, order details, restaurant POC details
and store/retrieve call history. 
Additionally, we can find well performing and under performing leads.
We can also find out which leads require a call today.

### System requirements

Java 17

### Installation and running instructions

Build the jar and run it. No additional steps needed.

### API documentation

###### The specifically important features are highlighted with their titles
#### Other curl commands are for general CRUD operations 

#### Create a New Restaurant

This endpoint allows you to add a new restaurant to the database.

##### URL
`http://localhost:8080/restaurants`

##### Method
`POST`

##### Headers
- `Content-Type: application/json`

### Example Request Body
```json
{
  "id": 4,
  "name": "The Food Ocean",
  "address": "123 Main Street",
  "status": "QUALIFIED",
  "frequency": "WEEKLY"
}
```

curl --request POST \
  --url http://localhost:8080/restaurants \
  --header 'Content-Type: application/json' \
  --data '{
	"id": 4, 
	"name":"The Food Ocean", 
	"address":"123 Main Street",
	"status":"QUALIFIED",
	"frequency":"WEEKLY"
}'

curl --request GET \
--url http://localhost:8080/restaurants

### Well performing and under performing leads

curl --request GET \
--url http://localhost:8080/restaurants/well-performing/40/2

curl --request GET \
--url http://localhost:8080/restaurants/under-performing/40/2

curl --request DELETE \
--url http://localhost:8080/restaurants/4 \
--header 'Content-Type: application/json'

### Get last call of restaurant by restaurant id

curl --request GET \
--url http://localhost:8080/call-details/1

### Get list of restaurants which need a call today
curl --request GET \
--url http://localhost:8080/call-details

curl --request POST \
--url http://localhost:8080/orders \
--header 'Content-Type: application/json' \
--data '{
"orderId": 6,
"restaurantId": 4,
"timestamp": "2024-01-01T12:00:00",
"amount": 550.75
}'

curl --request GET \
--url http://localhost:8080/orders

curl --request DELETE \
--url http://localhost:8080/orders/1

curl --request POST \
--url http://localhost:8080/contacts \
--header 'Content-Type: application/json' \
--data '{
"contactId": 4,
"restaurantId": 1,
"name": "Rishabh Setiya",
"email": "rishabh.setiya@example.com",
"phoneNumber": "123-456-7890",
"role": "OWNER"
}'

curl --request GET \
--url http://localhost:8080/contacts

curl --request POST \
--url http://localhost:8080/calls \
--header 'Content-Type: application/json' \
--data '{
"callTimestamp": "2024-11-23T12:00:00",
"contactId": 1,
"restaurantId": 101
}'

curl --request GET \
--url http://localhost:8080/calls
