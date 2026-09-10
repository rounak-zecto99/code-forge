SELECT s.student_id,s.student_name,e.subject_name,
COUNT(s.student_id = l.student_id AND e.subject_name = l.subject_name)
 as attended_exams 
FROM Students s
CROSS JOIN Subjects e
LEFT JOIN Examinations l on s.student_id = l.student_id AND e.subject_name = l.subject_name
Group by s.student_id,s.student_name,e.subject_name
ORDER BY s.student_id , e.subject_name;