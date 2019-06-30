SELECT
  a.id AS 'Id'
FROM
  weather as a
  JOIN
  weather b ON DATEDIFF(a.RecordDate, b.RecordDate) = 1
    AND a.Temperature > b.Temperature
;
