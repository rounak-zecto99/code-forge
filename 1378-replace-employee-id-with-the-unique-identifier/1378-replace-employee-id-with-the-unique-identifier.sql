# Write your MySQL query statement below
SELECT e.unique_id,s.name
FROM Employees s
LEFT JOIN EmployeeUNI e on s.id = e.id;