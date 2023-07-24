USE student_manager_db;

SELECT * FROM student WHERE student_name
LIKE "h%";

SELECT * FROM class WHERE MONTH(start_date) >= 12;

SELECT * FROM subject WHERE credit
BETWEEN 3 AND 5;

UPDATE student
SET class_id = 2
WHERE student_name = 'Hung';

SELECT s.student_name, sub.sub_name, m.mark
FROM student s JOIN mark m ON s.student_id = m.student_id JOIN subject sub ON sub.sub_id=m.sub_id
ORDER BY  m.mark DESC, s.student_name;