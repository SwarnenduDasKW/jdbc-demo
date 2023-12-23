-- schooldb.student definition

-- Drop table

-- DROP TABLE schooldb.student;

CREATE TABLE schooldb.student (
	student_id int8 NOT NULL,
	email_id varchar(255) NULL,
	first_name varchar(255) NULL,
	guardian_email varchar(255) NULL,
	guardian_mobile varchar(255) NULL,
	guardian_name varchar(255) NULL,
	last_name varchar(255) NULL,
	CONSTRAINT student_pkey PRIMARY KEY (student_id)
);

INSERT INTO schooldb.student (student_id,email_id,first_name,guardian_email,guardian_mobile,guardian_name,last_name) VALUES
	 (1,'john.doe@aol.com','John','jim.doe@aol.com','2268993302','Jim Doe','Doe'),
	 (2,'jane.doe@aol.com','Jane','jim.doe@aol.com','2233442212','Jim Doe','Doe');
