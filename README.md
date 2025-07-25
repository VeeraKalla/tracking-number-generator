# Tracking Number Generator

A scalable, concurrency-safe Spring Boot microservice for generating globally unique tracking numbers, deployed on AWS
EC2.

---

## AWS EC2 API Endpoint

**URL :**  
`http://51.21.244.18:8080/api/next-tracking-number`

**Method :**  
`POST`

**Request Payload (Required) :**

- `origin_country_id`
- `destination_country_id`
- `weight`
- `created_at`
- `customer_id`
- `customer_name`
- `customer_slug`

**Example : Request Payload**

```Request Payload
{
    "origin_country_id": "MY",
    "destination_country_id": "SG",
    "weight": 1.120,
    "created_at": "2025-05-29T04:53:57.0153+05:30",
    "customer_id": "de619854-b59b-425e-9db4-943979e1bd49",
    "customer_name": "REDBOX LOGISTICS",
    "customer_slug": "redbox-logistics"
}
```

**Example : Response Payload**

```
{
    "tracking_number": "T57IV0D5WMRR96Q2",
    "created_at": "2025-07-25T09:05:42.6050000+05:30"
}
```

**Tech Stack :**

* Java 17

* Spring Boot

* Docker

* AWS EC2

**Setup Instructions :**

**1. Clone the project**

git clone https://github.com/VeeraKalla/tracking-number-generator.git

cd tracking-number-generator

**2. Docker Build & Run**

*Build Docker image :* (don't miss full stop at end)

```docker build -t tracking-number-generator . ```

*Run container:*

```docker run -d --name tracking-api -p 8080:8080 tracking-number-generator ```

** Testing**

Use Postman and request payload added above.

**cURL**
```
curl --location 'localhost:8080/api/next-tracking-number' \
--header 'Content-Type: application/json' \
--data '{
    "origin_country_id": "MY",
    "destination_country_id": "SG",
    "weight": 1.120,
    "created_at": "2025-05-29T04:53:57.0153+05:30",
    "customer_id": "de619854-b59b-425e-9db4-943979e1bd49",
    "customer_name": "REDBOX LOGISTICS",
    "customer_slug": "redbox-logistics"
}'
```
**How it Works :**

The TrackingNumberService generates a tracking number using CustomerID, Timestamp, and Random Number (0-99).

The 16 characters tracking number constitutes as below

1. Base36 encoded timestamp which takes max of 8 characters length
2. Base36 encoded customerid which takes max of 6 characters length
3. Base36 encoded random number initiated during the creation of singleton TNGServiceImpl class which takes max of 2
   characters length
4. Total 8 + 6 + 2 = 16 characters Tracking number
5. Shuffles the characters randomly and returns the final unique tracking number

**Assumption :**
Downstream services which ever makes use of Tracking number generator tool will be associating the tracking num with
shipment or orderno.
As part of that snapshot persistence, idempotency of the tracking number can be maintained.

**Author : Veera Venkata Sai Santhosh Kalla**

**Email : veeravenkatasai87@gmail.com**
