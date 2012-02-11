package web.service;

import web.model.Student;

public interface StudentService {
    public void saveDetails(Student student);
    public Student getByRollNo(int rollNo) throws Exception;
}
