# Write your MySQL query statement below
SELECT e.name , i.bonus as bonus
FROM Employee e 
LEFT JOIN Bonus i on e.empId = i.empId
WHERE i.bonus IS NULL or i.bonus <1000; 