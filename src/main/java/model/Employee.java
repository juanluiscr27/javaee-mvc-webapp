package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Serializable {
    private Integer emp_no;
    private LocalDate birth_date;
    private String first_name;
    private String last_name;
    private Character gender;
    private LocalDate hire_date;
    private String dept_no;

    public Employee () {}

    public Employee(int emp_no,
                    LocalDate birth_date,
                    String first_name,
                    String last_name,
                    char gender,
                    LocalDate hire_date,
                    String dept_no) {

        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.dept_no = dept_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Employee{" +
                "emp_no=" + emp_no +
                ", birth_date='" + dtf.format(birth_date) + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender=" + gender +
                ", hire_date='" + dtf.format(hire_date) + '\'' +
                ", dept_no='" + dept_no + '\'' +
                '}';
    }
}
