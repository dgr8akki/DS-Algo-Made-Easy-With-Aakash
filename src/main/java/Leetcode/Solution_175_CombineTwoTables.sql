# Write your MySQL query statement below
Select p.FirstName as FirstName, p.LastName as LastName, a.City as City, a.State as State
from Person p
Left Join Address a
On p.PersonId = a.PersonId;
