
---
## product ( 상품정보 )

### 요청 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|productId|물품번호|INT UNSIGNED|0~4294967295|0|1|
|productName|물품이름|VARCHAR|200|0|화장품|
|companyId|등록업체번호|INT UNSIGNED|0~4294967295|0|1|

※ 항목구분: 필수(1), 옵션(0)
```
요청메세지
http://127.0.0.1:8080/usr/get/ProductsData?productId=1&productName=화장품&companyId=1
```
```
응답메세지
{
  "total_item_count": 19,
  "list": [
    {
      "productId": 1,
      "productName": "화장품",
      "price": 20000,
      "regDate": "2022-12-28 17:48:24",
      "companyId": 1,
      "extra__companyName": "회사1"
    }
  ]
}
```

### 응답 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|productId|물품번호|INT UNSIGNED|0~4294967295|1|1|
|productName|물품이름|VARCHAR|200|1|화장품|
|price|물품가격|INT UNSIGNED|0~4294967295|1|20000|
|regDate|등록일자|DATETIME|---|1|---|
|companyId|등록업체번호|INT UNSIGNED|0~4294967295|1|1|
|extra__companyName|등록업체명|VARCHAR|200|1|회사1|

--- 
## company (등록업체)

### 요청 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|companyId|등록업체번호|INT UNSIGNED|0~4294967295|0|13|
|companyName|등록업체명|VARCHAR|200|0|3|
|ceoName|업체대표자명|VARCHAR|200|0|강대표|

※ 항목구분: 필수(1), 옵션(0)
```
요청메세지
http://127.0.0.1:8080/usr/get/CompanysData?companyName=3&companyId=13&ceoName=강대표
```

```
응답메세지
{
  "total_item_count": 19,
  "list": [
    {
      "companyId": 13,
      "companyName": "회사13",
      "ceoName": "강대표",
      "phoneNumber": "01016796068"
    }
  ]
}
```

### 응답 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|companyId|등록업체번호|INT UNSIGNED|0~4294967295|1|13|
|companyName|등록업체명|VARCHAR|200|1|회사13|
|ceoName|업체대표자명|VARCHAR|50|1|강대표|
|phoneNumber|전화번호|VARCHAR|20|1|01016796068|

--- 
## customer (구매자)

### 요청 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|customerId|구매자번호|INT UNSIGNED|0~4294967295|0|1|
|customerName|구매자이름|VARCHAR|50|0|홍길동|

※ 항목구분: 필수(1), 옵션(0)
```
요청메세지
http://127.0.0.1:8080/usr/get/CustomersData?customerId=1&customerName=홍길동
```

```
응답메세지
{
  "total_item_count": 15,
  "list": [
    {
      "customerId": 1,
      "customerName": "홍길동",
      "phoneNumber": "010-2349-1**6"
    }
  ]
}
```

### 응답 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|customerId|등록업체번호|INT UNSIGNED|0~4294967295|1|1|
|customerName|등록업체명|VARCHAR|50|1|홍길동|
|phoneNumber|업체대표자명|VARCHAR|50|1|010-2349-1**6|

--- 
## order (구매정보)

### 요청 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|orderId|구매번호|INT UNSIGNED|0~4294967295|0|1|
|productId|상품번호|INT UNSIGNED|0~4294967295|0|1|
|customerId|구매자번호|INT UNSIGNED|0~4294967295|0|1|
|customerName|구매자이름|VARCHAR|50|0|홍길동|
|productName|구매자이름|VARCHAR|50|0|화장품|
|companyName|등록업체이름|VARCHAR|50|0|회사1|

※ 항목구분: 필수(1), 옵션(0)
```
요청메세지
http://127.0.0.1:8080/usr/get/OrdersData?orderId=1&productId=1&customerId=1&customerName=홍길동&productName=화장품&companyName=회사1
```

```
응답메세지
{
  "total_item_count": 19,
  "list": [
    {
      "orderId": 1,
      "regDate": "2022-12-29 15:28:27",
      "payment": 20000,
      "quantity": 1,
      "extra__customerName": "홍길동",
      "extra__productName": "화장품",
      "extra__companyName": "회사1",
      "extra__price": 20000
    }
  ]
}
```

### 응답 메세지 명세
|항목명(영문)|항목명(국문)|항목타입|항목크기|항목구분|샘플데이터|
|---|---|---|---|---|---|
|orderId|구매번호|INT UNSIGNED|0~4294967295|1|1|
|regDate|구매일자|VARCHAR|50|1|2022-12-29 15:28:27|
|payment|구매금액|INT UNSIGNED|0~4294967295|1|20000|
|quantity|구매갯수|INT UNSIGNED|0~4294967295|1|1|
|extra__customerName|구매자이름|VARCHAR|50|1|홍길동|
|extra__productName|상품이름|VARCHAR|50|1|화장품|
|extra__companyName|상품업체이름|VARCHAR|50|1|회사1|
|extra__price|상품가격|0~4294967295|50|1|20000|