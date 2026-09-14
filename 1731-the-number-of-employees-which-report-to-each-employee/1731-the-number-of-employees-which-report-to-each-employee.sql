# Write your MySQL query statement below
Select a.employee_id , a.name ,Count(*) as reports_count ,ROUND(SUM(e.age)/count(*),0) as average_age
-- SELECT *
FROM Employees e 
JOIN Employees a on e.reports_to = a.employee_id
GROUP BY a.employee_id, a.name
ORDER BY a.employee_id;
