package web.Builders;

import web.model.Student;

public class StudentBuilder {
    private int rollNo;
    private String firstName;
    private String lastName;
    private int standard;
    private String section;

    public StudentBuilder withDefaults() {
        this.rollNo = 1;
        this.firstName = "Sai";
        this.lastName = "Ram";
        this.standard = 4;
        this.section = "A";
        return this;
    }

    public StudentBuilder withFirstName(String name) {
        this.firstName = name;
        return this;
    }

    public StudentBuilder withLastName(String name) {
        this.lastName = name;
        return this;
    }

    public StudentBuilder withStandard(int std) {
        this.standard = std;
        return this;
    }

    public StudentBuilder withSection(String section) {
        this.section = section;
        return this;
    }

    public StudentBuilder withRollNo(int rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public Student build(){
        return new Student(this.rollNo,this.firstName,this.lastName,this.standard,this.section);
    }


}


