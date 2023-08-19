REM   Script: ACTIVITY 11
REM   Complex sub Query

create table orders(  
    order_no int primary key, purchase_amount float, order_date date,  
    customer_id int, salesman_id int);

INSERT ALL  
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)   
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)  
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)  
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)  
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)  
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)  
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)  
SELECT 1 FROM DUAL;

select customer_id ,Max(purchase_amount) as Max_Purchage from orders group by customer_id;

select salesman_id, order_date,Max(purchase_amount) as Max_Purchage where order_date = '2012-08-17' group by salesman_id;

select salesman_id, order_date,Max(purchase_amount) as Max_Purchage from orders where order_date = '2012-08-17' group by salesman_id;

select salesman_id, order_date,Max(purchase_amount) as Max_Purchage from orders where order_date =To_Date('2012-08-17' ,'YYYY/MM/DD') group by salesman_id;

select salesman_id, order_date,Max(purchase_amount) as Max_Purchage from orders where order_date =To_Date('2012-08-17' ,'YYYY/MM/DD') group by salesman_id,order_date;

select customer_id, order_date, Max(purchase_amount) as Max_Purchage from orders group by customer_id having Max(purchase_amount) in (2030, 3450, 5760,6000);

select customer_id, order_date, Max(purchase_amount) as Max_Purchage from orders group by customer_id,order_date having Max(purchase_amount) in (2030, 3450, 5760,6000);

select customer_id ,Max(purchase_amount) as Max_Purchage from orders group by customer_id;

select salesman_id, order_date,Max(purchase_amount) as Max_Purchage from orders where order_date =To_Date('2012-08-17' ,'YYYY/MM/DD') group by salesman_id,order_date;

select customer_id, order_date, Max(purchase_amount) as Max_Purchage from orders group by customer_id,order_date having Max(purchase_amount) in (2030, 3450, 5760,6000);

select * from orders;

select SUM(PURCHASE_AMOUNT) as Total_purchase_amount_of_all_orders from orders;

select AVG(PURCHASE_AMOUNT) as Average_purchase_amount_of_all_orders from orders;

select MAX(PURCHASE_AMOUNT) as Max_purchase_amount_of_all_orders from orders;

select MIN(PURCHASE_AMOUNT) as Min_purchase_amount_of_all_orders from orders;

select Count(SALESMAN_IDT) as number_of_salesmen from orders;

select * from orders;

select SUM(PURCHASE_AMOUNT) as Total_purchase_amount_of_all_orders from orders;

select AVG(PURCHASE_AMOUNT) as Average_purchase_amount_of_all_orders from orders;

select MAX(PURCHASE_AMOUNT) as Max_purchase_amount_of_all_orders from orders;

select MIN(PURCHASE_AMOUNT) as Min_purchase_amount_of_all_orders from orders;

select Count(SALESMAN_ID) as number_of_salesmen from orders;

select * from orders;

select * from salesman;

Create table salesman(salesman_id int,salesman_name varchar2(20),salesman_city varchar2(20),commission int);

insert into salesman values(5001,'James Hoog','New York',15);

insert all  
into salesman values(5002 ,'Nail Knite','Paris',13)  
into salesman values(5005,'Pit Alex','London',11)  
into salesman values(5006,'McLyon','Paris',14)  
into salesman values(5007,'Paul Adam','Rome',13)  
into salesman values(5003,'Lauson Hen','San Jose',12)  
select 1 from dual;

select * from salesman;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select * from orders;

select * from salesman;

select * from customers;

select customers.CUSTOMER_NAME,customers.CUSTOMER_ID,salesman.SALESMAN_ID,salesman.SALESMAN_NAME from customers  
    Inner Join salesman on customers.SALESMAN_ID = salesman.SALESMAN_ID;

select * from orders;

select * from salesman;

select * from customers;

select * from orders;

select * from salesman;

select * from customers;

select CUSTOMER_NAME from customers where GRADE < 300 Group by SALESMAN_ID order by CUSTOMER_NAME ;

select * from orders;

select * from salesman;

select * from customers;

select A.CUSTOMER_NAME,A.CITY,A.GRADE,B.SALESMAN_NAME from customers A LEFT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      WHERE A.GRADE < 300 order by CUSTOMER_ID;

select * from orders;

select * from salesman;

select * from customers;

select A.CUSTOMER_NAME,B.SALESMAN_NAME,B.COMMISSION from customers A RIGHT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      Where B.COMMISSION > 12 order by A.CUSTOMER_ID;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT a.customer_name AS "Customer Name", a.city, b.SALESMAN_NAME AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

select A.CUSTOMER_NAME,B.SALESMAN_NAME,B.COMMISSION from customers A RIGHT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      Where B.COMMISSION > 12;

SELECT a.customer_name AS "Customer Name", a.city, b.SALESMAN_NAME AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

select * from orders;

select * from salesman;

select * from customers;

select A.ORDER_NO,A.ORDER_DATE,A.PURCHASE_AMOUNT,B.CUSTOMER_NAME,C.SALESMAN_NAME,C.COMMISSION from orders A Inner Join  
    customer B On A.CUSTOMER_ID = B.CUSTOMER_ID Inner Join salesman C on B.SALESMAN_ID = C.SALESMAN_ID;

select A.ORDER_NO,A.ORDER_DATE,A.PURCHASE_AMOUNT,B.CUSTOMER_NAME,C.SALESMAN_NAME,C.COMMISSION from orders A Inner Join  
    customers B On A.CUSTOMER_ID = B.CUSTOMER_ID Inner Join salesman C on B.SALESMAN_ID = C.SALESMAN_ID;

select customers.CUSTOMER_NAME,customers.CUSTOMER_ID,salesman.SALESMAN_ID,salesman.SALESMAN_NAME from customers  
    Inner Join salesman on customers.SALESMAN_ID = salesman.SALESMAN_ID 
 
--Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works  
--either through a salesman. 
select A.CUSTOMER_NAME,A.CITY,A.GRADE,B.SALESMAN_NAME from customers A LEFT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      WHERE A.GRADE < 300 order by A.CUSTOMER_ID 
 
--Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission 
--from the company is more than 12%. 
 
select A.CUSTOMER_NAME,B.SALESMAN_NAME,B.COMMISSION from customers A RIGHT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      Where B.COMMISSION > 12;

select A.ORDER_NO,A.ORDER_DATE,A.PURCHASE_AMOUNT,B.CUSTOMER_NAME,C.SALESMAN_NAME,C.COMMISSION from orders A Inner Join  
    customers B On A.CUSTOMER_ID = B.CUSTOMER_ID Inner Join salesman C on B.SALESMAN_ID = C.SALESMAN_ID 
 
 
;

select customers.CUSTOMER_NAME,customers.CUSTOMER_ID,salesman.SALESMAN_ID,salesman.SALESMAN_NAME from customers  
    Inner Join salesman on customers.SALESMAN_ID = salesman.SALESMAN_ID 
 
--Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works  
--either through a salesman. 
select A.CUSTOMER_NAME,A.CITY,A.GRADE,B.SALESMAN_NAME from customers A LEFT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      WHERE A.GRADE < 300 order by A.CUSTOMER_ID 
 
--Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission 
--from the company is more than 12%. 
 
select A.CUSTOMER_NAME,B.SALESMAN_NAME,B.COMMISSION from customers A RIGHT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      Where B.COMMISSION > 12;

select A.ORDER_NO,A.ORDER_DATE,A.PURCHASE_AMOUNT,B.CUSTOMER_NAME,C.SALESMAN_NAME,C.COMMISSION from orders A Inner Join  
    customers B On A.CUSTOMER_ID = B.CUSTOMER_ID Inner Join salesman C on B.SALESMAN_ID = C.SALESMAN_ID;

select customers.CUSTOMER_NAME,customers.CUSTOMER_ID,salesman.SALESMAN_ID,salesman.SALESMAN_NAME from customers  
    Inner Join salesman on customers.SALESMAN_ID = salesman.SALESMAN_ID;

select A.CUSTOMER_NAME,A.CITY,A.GRADE,B.SALESMAN_NAME from customers A LEFT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      WHERE A.GRADE < 300 order by A.CUSTOMER_ID;

select A.CUSTOMER_NAME,B.SALESMAN_NAME,B.COMMISSION from customers A RIGHT JOIN  salesman B on A.SALESMAN_ID = B.SALESMAN_ID 
      Where B.COMMISSION > 12;

select A.ORDER_NO,A.ORDER_DATE,A.PURCHASE_AMOUNT,B.CUSTOMER_NAME,C.SALESMAN_NAME,C.COMMISSION from orders A Inner Join  
    customers B On A.CUSTOMER_ID = B.CUSTOMER_ID Inner Join salesman C on B.SALESMAN_ID = C.SALESMAN_ID;

select * from orders;

select * from salesman;

select * from customers;

select ORDER_NO from orders where SALESMAN_ID IN (select SALESMAN_ID from customers where CUSTOMER_ID = 3007);

select * from orders where SALESMAN_ID = (select SALESMAN_ID from orders where CUSTOMER_ID = 3007);

select * from orders where SALESMAN_ID = (select SALESMAN_ID from customer where CUSTOMER_ID = 3007);

select * from orders where SALESMAN_ID = (select SALESMAN_ID from customers where CUSTOMER_ID = 3007);

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

select * from orders;

select * from salesman;

select * from customers;

select * from orders where SALESMAN_ID IN (select SALESMAN_ID from customers where CITY ='New York');

select * from orders where SALESMAN_ID =(select SALESMAN_ID from customers where CITY ='New York');

select * from orders where SALESMAN_ID IN (select SALESMAN_ID from customers where CITY ='New York');

select * from salesman;

select * from orders where SALESMAN_ID IN (select SALESMAN_ID from salesman where CITY ='New York');

select * from salesman;

select * from orders where SALESMAN_ID IN (select SALESMAN_ID from salesman where SALESMAN_CITY ='New York');

select * from orders;

select * from salesman;

select * from customers;

select GRADE, COUNT(*) from customers  
    group by GRADE HAVING GRADE > (select AVG(GRADE) from customers where CITY = 'New York');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

select * from salesman;

select * from orders where SALESMAN_ID =(select SALESMAN_ID from salesman where COMMISSION = Max(COMMISSION));

select * from orders  
    where SALESMAN_ID IN (select SALESMAN_ID from salesman where COMMISSION = (Select MAX(COMMISSION) from salesman));

select * from orders where SALESMAN_ID = (select SALESMAN_ID from customers where CUSTOMER_ID = 3007);

select * from orders where SALESMAN_ID IN (select SALESMAN_ID from salesman where SALESMAN_CITY ='New York');

select GRADE, COUNT(*) from customers  
    group by GRADE HAVING GRADE > (select AVG(GRADE) from customers where CITY = 'New York');

select * from orders  
    where SALESMAN_ID IN (select SALESMAN_ID from salesman where COMMISSION = (Select MAX(COMMISSION) from salesman));

select * from orders;

select * from salesman;

select * from customers;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

 select * from salesman;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, SALESMAN_NAME FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

select * from customers 
select * from salesman 
select * from orders;

select * from customers;

select * from salesman;

select * from orders;

select A.CUSTOMER_NAME from customers A where 1 < (select count(BORDER_NO) from orders B) 
UNION 
select A.SALESMAN_NAME from salesman B where 1< (select count(B.ORDER_NO) from orders B) 
ORDER BY CUSTOMER_NAME;

select A.CUSTOMER_NAME from customers A where 1 < (select count(ORDER_NO) from orders B) 
UNION 
select A.SALESMAN_NAME from salesman B where 1< (select count(ORDER_NO) from orders B) 
ORDER BY CUSTOMER_NAME;

select * from salesman;

select A.CUSTOMER_NAME from customers A where 1 < (select count(ORDER_NO) from orders B) 
UNION 
select A.SALESMAN_NAME from salesman A where 1< (select count(ORDER_NO) from orders B) 
ORDER BY CUSTOMER_NAME;

select A.CUSTOMER_NAME from customers A where 1 < (select count(ORDER_NO) from orders B) 
UNION 
select C.SALESMAN_NAME from salesman C where 1< (select count(ORDER_NO) from orders B) 
ORDER BY CUSTOMER_NAME;

select CUSTOMER_NAME,CUSTOMER_ID from customers A where 1 < (select count(*) from orders B A.CUSTOMER_ID = B.CUSTOMER_ID) 
UNION 
select SALESMAN_NAME,SALESMAN_ID from salesman A where 1< (select count(*) from orders B where A.SALESMAN_ID = B.SALESMAN_ID ) 
ORDER BY CUSTOMER_NAME;

select CUSTOMER_NAME,CUSTOMER_ID from customers A where 1 < (select count(*) from orders B where A.CUSTOMER_ID = B.CUSTOMER_ID) 
UNION 
select SALESMAN_NAME,SALESMAN_ID from salesman A where 1< (select count(*) from orders B where A.SALESMAN_ID = B.SALESMAN_ID ) 
ORDER BY CUSTOMER_NAME;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, SALESMAN_NAME FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT salesman_id, SALESMAN_NAME FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT salesman_id, SALESMAN_NAME FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id);

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id);

select CUSTOMER_NAME,CUSTOMER_ID from customers A where 1 < (select count(*) from orders B where A.CUSTOMER_ID = B.CUSTOMER_ID) 
UNION 
select SALESMAN_NAME,SALESMAN_ID from salesman A where 1< (select count(*) from orders B where A.SALESMAN_ID = B.SALESMAN_ID ) 
ORDER BY CUSTOMER_NAME;

select * from customers;

select * from salesman;

select * from orders;

Select Max(PURCHASE_AMOUNT),Min(PURCHASE_AMOUNT),SALESMAN_ID from orders group by ORDER_DATE;

select * from customers;

select * from salesman;

select * from orders;

select A.SALESMAN_ID,A.SALESMAN_NAME,B.ORDER_NO,'highest On',B.ORDER_DATE from salesman A, orders B  
    Where A.SALESMAN_ID =B.SALESMAN_ID AND B.PURCHASE_AMOUNT =(select MAX(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE =B.ORDER_DATE ) 
UNION 
select A.SALESMAN_ID,SALESMAN_NAME,B.ORDER_NO,'lowest on',B.ORDER_DATE from salesman A,orders B  
    where A.SALESMAN_ID = B.SALESMAN_ID AND B.PURCHASE_AMOUNT = (select MIN(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE = B.ORDER_DATE );

select A.SALESMAN_ID,A.SALESMAN_NAME,B.ORDER_NO,'highest/Lowest On',B.ORDER_DATE from salesman A, orders B  
    Where A.SALESMAN_ID =B.SALESMAN_ID AND B.PURCHASE_AMOUNT =(select MAX(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE =B.ORDER_DATE ) 
UNION 
select A.SALESMAN_ID,SALESMAN_NAME,B.ORDER_NO,'lowest on',B.ORDER_DATE from salesman A,orders B  
    where A.SALESMAN_ID = B.SALESMAN_ID AND B.PURCHASE_AMOUNT = (select MIN(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE = B.ORDER_DATE );

select A.SALESMAN_ID,A.SALESMAN_NAME,B.ORDER_NO,'highest on',B.ORDER_DATE from salesman A, orders B  
    Where A.SALESMAN_ID =B.SALESMAN_ID AND B.PURCHASE_AMOUNT =(select MAX(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE =B.ORDER_DATE ) 
UNION 
select A.SALESMAN_ID,SALESMAN_NAME,B.ORDER_NO,'lowest on',B.ORDER_DATE from salesman A,orders B  
    where A.SALESMAN_ID = B.SALESMAN_ID AND B.PURCHASE_AMOUNT = (select MIN(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE = B.ORDER_DATE );

select CUSTOMER_NAME,CUSTOMER_ID from customers A where 1 < (select count(*) from orders B where A.CUSTOMER_ID = B.CUSTOMER_ID) 
UNION 
select SALESMAN_NAME,SALESMAN_ID from salesman A where 1< (select count(*) from orders B where A.SALESMAN_ID = B.SALESMAN_ID ) 
ORDER BY CUSTOMER_NAME;

select A.SALESMAN_ID,A.SALESMAN_NAME,B.ORDER_NO,'highest on',B.ORDER_DATE from salesman A, orders B  
    Where A.SALESMAN_ID =B.SALESMAN_ID AND B.PURCHASE_AMOUNT =(select MAX(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE =B.ORDER_DATE ) 
UNION 
select A.SALESMAN_ID,SALESMAN_NAME,B.ORDER_NO,'lowest on',B.ORDER_DATE from salesman A,orders B  
    where A.SALESMAN_ID = B.SALESMAN_ID AND B.PURCHASE_AMOUNT = (select MIN(PURCHASE_AMOUNT) from orders C  
    where C.ORDER_DATE = B.ORDER_DATE );

