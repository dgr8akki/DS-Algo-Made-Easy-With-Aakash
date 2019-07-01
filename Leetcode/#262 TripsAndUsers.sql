WITH
  CTE
  AS
  (
    SELECT
      Client_ID,
      Driver_ID,
      Request_at,
      CASE WHEN Patindex('%cancelled%', Status) >= 1
        THEN 1
        ELSE 0
    END AS Cancelled
    FROM Trips
  )

SELECT CTE.Request_at AS Day,
  CAST(SUM(CTE.Cancelled*1.00)/Count(CTE.Client_ID*1.00) AS DECIMAL(5,2)) AS [Cancellation Rate]
FROM CTE
  LEFT JOIN Users AS Clients
  ON Clients.Users_ID = CTE.Client_ID
  LEFT JOIN Users AS Drivers
  ON Drivers.Users_ID = CTE.Driver_ID
WHERE 
Clients.Banned = 'No' AND
  Drivers.Banned = 'No' AND
  Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY CTE.Request_at
