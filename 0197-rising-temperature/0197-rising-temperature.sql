SELECT a.id
FROM Weather a
JOIN Weather b
    ON TIMESTAMPDIFF(DAY, b.recordDate, a.recordDate) = 1
WHERE a.temperature > b.temperature;