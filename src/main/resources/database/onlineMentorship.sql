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

create table course_registration(
                                    course_registration_id long primary key,
                                    student_id long not null,
                                    course_id long not null,
                                    course_status enum('COMPLETED','IN_PROGRESS'),
                                    installment boolean not null,
                                    installment_number int
);

create table mentorship_registration(
                                        mentorship_registration_id long primary key,
                                        student_id long not null,
                                        mentorship_id long not null,
                                        mentorship_status enum('COMPLETED','IN_PROGRESS'),
                                        installment boolean not null,
                                        installment_number int
);

create table payment(
                        payment_id long primary key,
                        student_id long not null,
                        course_registration_id long,
                        mentorship_registration_id long,
                        transaction_id varchar(255) not null unique,
                        amount_paid double(5,2) not null,
                        payment_date date not null
);