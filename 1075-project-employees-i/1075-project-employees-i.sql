SELECT p.project_id ,ROUND(SUM(e.experience_years)/Count(*) , 2) as average_years  
FROM Project p
JOIN Employee e ON p.employee_id = e.employee_id
Group by p.project_id