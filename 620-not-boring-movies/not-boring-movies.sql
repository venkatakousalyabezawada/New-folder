# Write your MySQL query statement below
SELECT *
FROM Cinema
WHERE ID % 2 != 0 AND DESCRIPTION != 'BORING'
ORDER BY RATING DESC;



