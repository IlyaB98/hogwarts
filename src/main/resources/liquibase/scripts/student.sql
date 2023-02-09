-- liquibase formatted sql

-- changeSet ilya:1
CREATE INDEX name_student_index ON student (name);

-- changeSet ilya:2
CREATE INDEX faculty_name_and_color_index ON faculty(name, color);

