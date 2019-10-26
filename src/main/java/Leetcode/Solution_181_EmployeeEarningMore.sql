Select p1.Name as Employee
FROM Employee p1
  Left join Employee p2
  On p1.ManagerId = p2.Id
where p1.Salary > p2.salary;
