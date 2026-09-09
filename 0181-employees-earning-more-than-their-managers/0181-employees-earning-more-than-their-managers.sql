# Write your MySQL query statement below
SELECT  e.name as Employee FROM Employee e
JOIN Employee a ON e.managerId = a.id
WHERE e.salary > a.salary;