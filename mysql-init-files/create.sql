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
    `price`        INT             NOT NULL    COMMENT '가격', 
    `regDate`      DATETIME        NOT NULL    COMMENT '등록일자', 
    `companyId`    INT UNSIGNED    NOT NULL    COMMENT '등록업체번호', 
     PRIMARY KEY (productId)
);

-- 테이블 Comment 설정 SQL - Products
ALTER TABLE Products COMMENT '상품정보';

-- Foreign Key 설정 SQL - Products(companyId) -> Companys(companyId)
ALTER TABLE Products
    ADD CONSTRAINT FK_Products_companyId_Companys_companyId FOREIGN KEY (companyId)
        REFERENCES Companys (companyId) ON DELETE RESTRICT ON UPDATE RESTRICT;

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
    `customerId`  INT UNSIGNED    NOT NULL    COMMENT '구매자', 
    `payment`     INT             NOT NULL    COMMENT '금액', 
    `regDate`     DATETIME        NOT NULL    COMMENT '구매일자', 
     PRIMARY KEY (orderId)
);

-- 테이블 Comment 설정 SQL - Orders
ALTER TABLE Orders COMMENT '구매정보';

-- Foreign Key 설정 SQL - Orders(productId) -> Products(productId)
ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_productId_Products_productId FOREIGN KEY (productId)
        REFERENCES Products (productId) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - Orders(productId)
-- ALTER TABLE Orders
-- DROP FOREIGN KEY FK_Orders_productId_Products_productId;

-- Foreign Key 설정 SQL - Orders(customerId) -> Customers(customerId)
ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_customerId_Customers_customerId FOREIGN KEY (customerId)
        REFERENCES Customers (customerId) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - Orders(customerId)
-- ALTER TABLE Orders
-- DROP FOREIGN KEY FK_Orders_customerId_Customers_customerId;

# 테스트 데이터 생성

INSERT INTO `Companys`(companyName,ceoName,phoneNumber)VALUES
('회사1','김대표','01012341234'),
('회사2','이대표','01023452345'),
('회사3','박대표','01013333334'),
('회사4','최대표','01015523234'),
('회사5','정대표','01012345344'),
('회사6','장대표','01011234534'),
('회사7','송대표','01012343455'),
('회사8','윤대표','01012312398'),
('회사9','송대표','01023334223'),
('회사10','주대표','01023563477'),
('회사11','조대표','01045641244'),
('회사12','양대표','01012356896'),
('회사13','강대표','01016796068'),
('회사14','고대표','01056834525'),
('회사15','지대표','01078954234'),
('회사16','성대표','01089700834'),
('회사17','수대표','01012568234'),
('회사18','신대표','01086856834'),
('회사19','마대표','01015856534');


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

INSERT INTO `Customers`(`customerName`,phoneNumber)VALUES
('홍길동',01023490495),
('김철수',01023490495),
('아무개',01023490495),
('김고객',01023490495),
('마석두',01023490495),
('장첸',01023490495),
('조태오',01023490495),
('이순신',01023490495),
('이몽룡',01023490495),
('장국영',01023490495),
('박해수',01023490495),
('송실장',01023490495),
('이병철',01023490495),
('오수재',01023490495),
('지상렬',01023490495);

INSERT INTO `Orders`(productId,customerId,payment,regDate)VALUES
(1,1,20000,NOW()),
(2,2,33000,NOW()),
(3,3,10000,NOW()),
(4,4,23000,NOW()),
(5,5,13000,NOW()),
(6,6,32000,NOW()),
(7,7,10000,NOW()),
(8,8,6000,NOW()),
(9,9,5000,NOW()),
(10,10,2000,NOW()),
(11,11,22000,NOW()),
(12,12,23000,NOW()),
(13,13,27000,NOW()),
(14,1,12000,NOW()),
(15,2,46000,NOW()),
(16,3,11000,NOW()),
(17,4,9000,NOW()),
(18,5,8000,NOW()),
(19,6,19000,NOW());
