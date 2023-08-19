REM   Script: ACTIVITY 7
REM    Aggregate functions

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

