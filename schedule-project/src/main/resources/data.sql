INSERT INTO faculty values (1, 'ФІ', 'Факультет інформатики');

INSERT INTO speciality (ID, NAME, CODE, FACULTY_ID) values
(1, 'Прикладна Математика', 104, 1),
(2, 'Інженерія Програмного Забезпечення', 121, 1),
(3, 'Компютерні Науки', 122, 1);

INSERT INTO staff(id, name, surname, email, password, position ) values
(1, 'Олег', 'Винник', 'olegvynnyk@gmail.com', '$2a$10$3r4urWJ3x6U82.yJlJlng.idqxbkRfFBf4oswegaiC.DRH5NJ1Bea', 'Викладач');

INSERT INTO permissions(id, permission) values
(1, 'STUDENT'),
(2, 'METHODIST'),
(3, 'ADMIN');

INSERT INTO user_permissions(user_id, permission_id) values
(1, 3);