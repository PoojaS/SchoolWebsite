package web.Builders;

import web.model.Student;

public class StudentBuilder extends Student{

    public StudentBuilder withDefaults() {
        withRollNo(1);
        withFirstName("Default Firstname");
        withLastName("Default Lastname");
        withStandard(8);
        withSection("A");
        return this;
    }

    public StudentBuilder withRollNo(int roll) {
        setRollNo(roll);
        return this;
    }

    public StudentBuilder withFirstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public StudentBuilder withLastName(String lastName) {
        setLastName(lastName);
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
