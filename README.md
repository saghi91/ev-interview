# Checkout VAT
## Application description
Checkout VAT is a shopping cart checkout service. It exposes API `/generate-report` which consumes article ids with prices and their respective VATs and calculate total shopping cart price.

Sample request with single article:
```
{
  "articleNettPrices": {
    "pepsi": 10
  },
  "articleVatPercentages": {
    "pepsi": 20
  }
}
```

Expected response with single article:
```
{
    "total": 12.0,
    "timestamp": "2022-10-10T00:00:00.000000Z"
}
```

Sample request with multiple article ids:
```
{
  "articleNettPrices": {
    "pepsi": 10,
    "cola": 10,
    "fanta": 10
  },
  "articleVatPercentages": {
    "pepsi": 20,
    "cola": 10,
    "fanta": 30
  }
}
```
Expected response with multiple articles:
```
{
    "total": 36.0,
    "timestamp": "2022-10-10T00:00:00.000000Z"
}
```




