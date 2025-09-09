# Write your MySQL query statement below
select e.name as Employee
from Employee e, Employee m
where e.managerID = m.Id and
e.salary > m.salary;