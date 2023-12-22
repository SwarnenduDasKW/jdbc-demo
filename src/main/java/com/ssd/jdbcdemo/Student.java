package com.ssd.jdbcdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Column("student_id")
    private int studentId;

    @Column("email_id")
    private String emailId;

    @Column("first_name")
    private String firstName;

    @Column("guardian_email")
    private String guardianEmail;

    @Column("guardian_mobile")
    private String guardianMobile;

    @Column("guardian_name")
    private String guardianName;

    @Column("last_name")
    private String lastName;
}
