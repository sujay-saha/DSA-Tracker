CREATE TABLE EMPLOYEE
(EMPNO varchar(10),EMP_NAME varchar(20),
DEPT varchar(20),SALARY  varchar(20),DOJ date,BRANCH varchar(20));
insert INTO EMPLOYEE
VALUES(101,'AMIT','PRODUCTION',45000,'2000-03-12','BANGLORE');
insert INTO EMPLOYEE
VALUES(107,'YASH','PRODUCTION',53000,'2008-05-01','BANGLORE');
insert INTO EMPLOYEE
VALUES(108,'MAHESH','PRODUCTION',48000,'2003-06-29','BANGLORE');
insert INTO EMPLOYEE
VALUES(102,'AMIT','HR',70000,'2002-07-03','BANGLORE');
insert INTO EMPLOYEE
VALUES(109,'JATIN','HR',70000,'2001-05-03','BANGLORE');
insert INTO EMPLOYEE
VALUES(103,'SUNITA','MANAGER',120000,'2001-01-11','MYSORE');
insert INTO EMPLOYEE
VALUES(110,'HARISH SADU','MANAGER',160000,'1999-07-04','MYSORE');
insert INTO EMPLOYEE
VALUES(105,'SUNITA','IT',67000,'2001-08-01','MYSORE');
insert INTO EMPLOYEE
VALUES(105,'FRED','IT',67000,'2003-03-03','BANGLORE');
insert INTO EMPLOYEE
VALUES(106,'MAHESH','CIVIL',145000,'2003-09-20','MUMBAI');
select*from EMPLOYEE;
SELECT EMP_NAME ,SALARY from EMPLOYEE;

--Example1: Count employees in each department
select DEPT, count(DEPT) from EMPLOYEE group by DEPT;

--Example2: Get the Average Salary Per Department
select DEPT, avg(SALARY) from EMPLOYEE group by DEPT;

--Example3: Get the Highest and Lowest Salary Per Department
select DEPT, min(SALARY) as MAX_SALARY,max(SALARY) as MIN_SALARY from EMPLOYEE group by DEPT;

--Example4: Count Employees per Department and Joining Year
select DEPT,year(DOJ) as JOINING_YEAR,count(*) from EMPLOYEE group by DEPT, year(DOJ);

--Example5: Order Departments by the Highest Average Salary
select DEPT,avg(SALARY) as AVG_SALARY from EMPLOYEE group by DEPT order by AVG_SALARY desc;

--Example6: Based on Salary decide whether its low, medium or high
select count(*),
case
  WHEN SALARY<60000 THEN 'LOW SALARY'
  WHEN SALARY BETWEEN 60000 AND 70000 THEN 'MEDIUM SALARY'
  ELSE 'HIGH SALARY'
END as salary_range
from EMPLOYEE;

--Example7: Based on Salary decide whether its low, medium or high ands show its count
select
case
  WHEN SALARY<60000 THEN 'LOW SALARY'
  WHEN SALARY BETWEEN 60000 AND 70000 THEN 'MEDIUM SALARY'
  ELSE 'HIGH SALARY'
END as salary_range,count(*) as COUNT
from EMPLOYEE group by salary_range;

--Example8: Based on Salary decide whether its low, medium or high ands show its count
select
case
  WHEN SALARY<60000 THEN 'LOW SALARY'
  WHEN SALARY BETWEEN 60000 AND 70000 THEN 'MEDIUM SALARY'
  ELSE 'HIGH SALARY'
END as salary_range,count(*) as COUNT
from EMPLOYEE group by salary_range;

