package web.service;

import web.model.Student;

public class StudentBuilder extends Student{

    public StudentBuilder withDefaults() {
        withRollNo(1);
        withName("Default Name");
        withStandard(8);
        withSection("A");
        return this;
    }

    public StudentBuilder withRollNo(int roll) {
        setRollNo(roll);
        return this;
    }

    public StudentBuilder withName(String name) {
        setName(name);
        return this;
    }

    public StudentBuilder withStandard(int std) {
        setStandard(std);
        return this;
    }

    public StudentBuilder withSection(String section) {
        setSection(section);
        return this;
    }
    
}
