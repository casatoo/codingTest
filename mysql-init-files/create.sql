DROP DATABASE IF EXISTS codingTest;
CREATE DATABASE codingTest;
USE codingTest;

-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- Companys Table Create SQL
-- 테이블 생성 SQL - Companys
CREATE TABLE Companys
(
    `companyId`    INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '등록업체번호', 
    `companyName`  VARCHAR(200)    NOT NULL    COMMENT '등록업체명', 
    `ceoName`      VARCHAR(50)     NOT NULL    COMMENT '업체대표자명', 
    `phoneNumber`  VARCHAR(20)     NOT NULL    COMMENT '전화번호', 
    `regDate`      DATETIME        NOT NULL    COMMENT '등록일자', 
    `updateDate`   DATETIME        NULL        COMMENT '수정일자', 
     PRIMARY KEY (companyId)
);

-- 테이블 Comment 설정 SQL - Companys
ALTER TABLE Companys COMMENT '등록업체';


-- Products Table Create SQL
-- 테이블 생성 SQL - Products
CREATE TABLE Products
(
    `productId`    INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '상품번호', 
    `productName`  VARCHAR(200)    NOT NULL    COMMENT '상품명', 
    `price`        INT UNSIGNED    NOT NULL    COMMENT '가격', 
    `regDate`      DATETIME        NOT NULL    COMMENT '등록일자', 
    `companyId`    INT UNSIGNED    NOT NULL    COMMENT '등록업체번호', 
    `updateDate`   DATETIME        NULL        COMMENT '수정일자', 
     PRIMARY KEY (productId)
);

-- 테이블 Comment 설정 SQL - Products
ALTER TABLE Products COMMENT '상품정보';

-- Foreign Key 설정 SQL - Products(companyId) -> Companys(companyId)
ALTER TABLE Products
    ADD CONSTRAINT FK_Products_companyId_Companys_companyId FOREIGN KEY (companyId)
        REFERENCES Companys (companyId) ON DELETE CASCADE  ON UPDATE CASCADE ;

-- Foreign Key 삭제 SQL - Products(companyId)
-- ALTER TABLE Products
-- DROP FOREIGN KEY FK_Products_companyId_Companys_companyId;


-- Customers Table Create SQL
-- 테이블 생성 SQL - Customers
CREATE TABLE Customers
(
    `customerId`    INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '고객번호', 
    `customerName`  VARCHAR(50)     NOT NULL    COMMENT '고객이름', 
    `phoneNumber`   VARCHAR(20)     NOT NULL    COMMENT '고객전화번호', 
    `regDate`       DATETIME        NOT NULL    COMMENT '등록일자', 
    `updateDate`    DATETIME        NULL        COMMENT '수정일자', 
     PRIMARY KEY (customerId)
);

-- 테이블 Comment 설정 SQL - Customers
ALTER TABLE Customers COMMENT '구매자';


-- Orders Table Create SQL
-- 테이블 생성 SQL - Orders
CREATE TABLE Orders
(
    `orderId`     INT UNSIGNED    NOT NULL    AUTO_INCREMENT COMMENT '구매번호', 
    `productId`   INT UNSIGNED    NOT NULL    COMMENT '상품번호', 
    `customerId`  INT UNSIGNED    NOT NULL    COMMENT '고객번호', 
    `payment`     INT UNSIGNED    NOT NULL    COMMENT '구매금액', 
    `regDate`     DATETIME        NOT NULL    COMMENT '구매일자', 
    `quantity`    INT UNSIGNED    NOT NULL    COMMENT '구매수량', 
    `updateDate`  DATETIME        NULL        COMMENT '수정일자', 
     PRIMARY KEY (orderId)
);

-- 테이블 Comment 설정 SQL - Orders
ALTER TABLE Orders COMMENT '구매정보';

-- Foreign Key 설정 SQL - Orders(productId) -> Products(productId)
ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_productId_Products_productId FOREIGN KEY (productId)
        REFERENCES Products (productId) ON DELETE CASCADE  ON UPDATE CASCADE ;

-- Foreign Key 삭제 SQL - Orders(productId)
-- ALTER TABLE Orders
-- DROP FOREIGN KEY FK_Orders_productId_Products_productId;

-- Foreign Key 설정 SQL - Orders(customerId) -> Customers(customerId)
ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_customerId_Customers_customerId FOREIGN KEY (customerId)
        REFERENCES Customers (customerId) ON DELETE CASCADE  ON UPDATE CASCADE ;

-- Foreign Key 삭제 SQL - Orders(customerId)
-- ALTER TABLE Orders
-- DROP FOREIGN KEY FK_Orders_customerId_Customers_customerId;



# 테스트 데이터 생성

INSERT INTO `Companys`(companyName,ceoName,phoneNumber,regDate)VALUES
('회사1','김대표','010-1234-1234',NOW()),
('회사2','이대표','010-2345-2345',NOW()),
('회사3','박대표','010-1333-3334',NOW()),
('회사4','최대표','010-1552-3234',NOW()),
('회사5','정대표','010-1234-5344',NOW()),
('회사6','장대표','010-1123-4534',NOW()),
('회사7','송대표','010-1234-3455',NOW()),
('회사8','윤대표','010-1231-2398',NOW()),
('회사9','송대표','010-2333-4223',NOW()),
('회사10','주대표','010-2356-3477',NOW()),
('회사11','조대표','010-4564-1244',NOW()),
('회사12','양대표','010-1235-6896',NOW()),
('회사13','강대표','010-1679-6068',NOW()),
('회사14','고대표','010-5683-4525',NOW()),
('회사15','지대표','010-7895-4234',NOW()),
('회사16','성대표','010-8970-0834',NOW()),
('회사17','수대표','010-1256-8234',NOW()),
('회사18','신대표','010-8685-6834',NOW()),
('회사19','마대표','010-1585-6534',NOW());


INSERT INTO `Products`(productName,price,regDate,companyId)VALUES
('화장품',20000,NOW(),1),
('소고기',33000,NOW(),2),
('닭고기',10000,NOW(),3),
('선물세트',23000,NOW(),4),
('쌀',13000,NOW(),5),
('랍스타',32000,NOW(),6),
('코트',10000,NOW(),7),
('티셔츠',6000,NOW(),8),
('신발',5000,NOW(),9),
('휴대폰케이스',2000,NOW(),10),
('상품권',22000,NOW(),11),
('샴푸',23000,NOW(),12),
('면도기',27000,NOW(),13),
('라면',12000,NOW(),14),
('장난감',46000,NOW(),15),
('가위',11000,NOW(),16),
('도마',9000,NOW(),17),
('선풍기',8000,NOW(),18),
('빵',19000,NOW(),19);

INSERT INTO `Customers`(`customerName`,phoneNumber,regDate)VALUES
('홍길동','010-2349-1456',NOW()),
('김철수','010-8749-4038',NOW()),
('아무개','010-2634-3039',NOW()),
('김고객','010-2149-0919',NOW()),
('마석두','010-1249-2318',NOW()),
('장첸','010-2126-8465',NOW()),
('조태오','010-6749-2525',NOW()),
('이순신','010-5459-1234',NOW()),
('이몽룡','010-5679-2039',NOW()),
('장국영','010-3636-2038',NOW()),
('박해수','010-8996-4847',NOW()),
('송실장','010-5665-5678',NOW()),
('이병철','010-5568-5686',NOW()),
('오수재','010-4829-3464',NOW()),
('지상렬','010-2020-3456',NOW());

INSERT INTO `Orders`(productId,customerId,payment,regDate,quantity)VALUES
(1,1,20000,NOW(),1),
(2,2,33000,NOW(),1),
(3,3,10000,NOW(),1),
(4,4,23000,NOW(),1),
(5,5,13000,NOW(),1),
(6,6,32000,NOW(),1),
(7,7,10000,NOW(),1),
(8,8,6000,NOW(),1),
(9,9,5000,NOW(),1),
(10,10,2000,NOW(),1),
(11,11,22000,NOW(),1),
(12,12,23000,NOW(),1),
(13,13,27000,NOW(),1),
(14,1,12000,NOW(),1),
(15,2,46000,NOW(),1),
(16,3,11000,NOW(),1),
(17,4,9000,NOW(),1),
(18,5,8000,NOW(),1),
(19,6,19000,NOW(),1);


# 연습 쿼리

SELECT * FROM Companys;
SELECT * FROM Products;
SELECT * FROM Customers;
SELECT * FROM Orders;

