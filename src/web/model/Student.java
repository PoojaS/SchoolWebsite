package web.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Student {

    private int rollNo;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotNull
    @Min(value = 1)
    @Digits(integer = 2, fraction = 0)
    private int standard;
    private String section;
    private boolean checkbox;

    public Student(int rollNo, String firstName, String lastName, int standard, String section) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.standard = standard;
        this.section = section;
    }

    public Student() {

    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}
