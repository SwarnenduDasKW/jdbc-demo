package com.ssd.jdbcdemo;

public class Student {
    private int student_id;
    private String email_id;
    private String first_name;
    private String guardian_email;
    private String guardian_mobile;
    private String guardian_name;
    private String last_name;

    public Student() {
    }

    public Student(int student_id, String email_id, String first_name, String guardian_email, String guardian_mobile, String guardian_name, String last_name) {
        this.student_id = student_id;
        this.email_id = email_id;
        this.first_name = first_name;
        this.guardian_email = guardian_email;
        this.guardian_mobile = guardian_mobile;
        this.guardian_name = guardian_name;
        this.last_name = last_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGuardian_email() {
        return guardian_email;
    }

    public void setGuardian_email(String guardian_email) {
        this.guardian_email = guardian_email;
    }

    public String getGuardian_mobile() {
        return guardian_mobile;
    }

    public void setGuardian_mobile(String guardian_mobile) {
        this.guardian_mobile = guardian_mobile;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
