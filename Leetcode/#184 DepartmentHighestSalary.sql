select
  dp.Name as Department,
  em.Name as Employee,
  em.Salary as Salary
from Department as dp
  inner join (
  select
    *,
    rank() over(partition by DepartmentId order by Salary desc) as rn
  from Employee
  ) as em
  on dp.Id = em.DepartmentId
where
  rn = 1
