WITH
  CTE
  AS
  (
    SELECT E.Salary,
      E.DepartmentID,
      E.Name,
      DENSE_RANK() OVER (Partition by E.DepartmentID Order by E.Salary desc) AS Rank
    FROM Employee E
  )

SELECT D.Name AS Department, CTE.Name AS Employee, CTE.Salary
FROM CTE
  LEFT JOIN Department D
  ON D.ID = CTE.DepartmentID
WHERE Rank <= 3
  AND D.Name IS NOT NULL
