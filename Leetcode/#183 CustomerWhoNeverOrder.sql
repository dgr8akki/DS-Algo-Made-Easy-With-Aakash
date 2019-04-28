# Write your
MySQL query statement below
Select C.Name as Customers
from Customers C
  left join Orders O
  on C.Id = O.CustomerId
where O.CustomerId is null;
