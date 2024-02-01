create database online_mentorship;
use online_mentorship;

create table student(
                        student_id bigint primary key,
                        first_name varchar(100) not null,
                        last_name varchar(100) not null,
                        email varchar(50) not null unique,
                        pass_word varchar(50) not null,
                        contact_number varchar(10) not null unique,
                        previous_courses varchar(255),
                        previous_mentorships varchar(255),
                        payment_due double
);

alter table student
    add column username varchar(255) not null;
alter table trainer
    add column username varchar(255) not null;

alter table student
drop column user_name;

create table trainer(
                        trainer_id bigint primary key,
                        first_name varchar(100) not null,
                        last_name varchar(100) not null,
                        email varchar(50) not null unique,
                        pass_word varchar(50) not null,
                        contact_number varchar(10) not null unique,
                        available_from date not null,
                        penalty int default 0,
                        cancellation_count int default 0
);