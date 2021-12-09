INSERT INTO faculty values (1, 'ФІ', 'Факультет інформатики');

INSERT INTO speciality (ID, NAME, CODE, FACULTY_ID) values
(1, 'Прикладна Математика', 104, 1),
(2, 'Інженерія Програмного Забезпечення', 121, 1),
(3, 'Компютерні Науки', 122, 1);


INSERT INTO course (id, name, course_year, hours, credits, max_groups, season) values
(1, 'ООП та патерни', 2, 30, 4, 6, 'FALL');



INSERT INTO staff(id, name, surname, email, password, position ) values
(1, 'Олег', 'Винник', 'olegvynnyk@gmail.com', '$2a$10$3r4urWJ3x6U82.yJlJlng.idqxbkRfFBf4oswegaiC.DRH5NJ1Bea', 'Викладач');

INSERT INTO permissions(id, permission) values
(1, 'STUDENT'),
(2, 'METHODIST'),
(3, 'ADMIN');

INSERT INTO user_permissions(user_id, permission_id) values
(1, 3);

INSERT INTO lesson (id, course_id, staff_id, lesson_group, lesson_type, lesson_time, weeks) values
(1, 1, 1, 1, 'PRACTICE', '2021-12-06 16:00:00.000', '1,2,3,4,5,6,7,8,9'),
(2, 1, 1, 0, 'LECTURE',  '2021-12-07 10:00:00.000', '1,2,3,4,5,6,7,8,9'),
(3, 1, 1, 0, 'LECTURE',  '2021-12-08 10:00:00.000', '1,2,3,4,5,6,7,8,9'),
(4, 1, 1, 0, 'LECTURE',  '2021-12-09 10:00:00.000', '1,2,3,4,5,6,7,8,9'),
(5, 1, 1, 0, 'LECTURE',  '2021-12-10 10:00:00.000', '1,2,3,4,5,6,7,8,9');



