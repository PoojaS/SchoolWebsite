package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Student;
import web.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl() {
    }

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveDetails(Student student) {
        if(student!=null)
           studentRepository.save(student);

    }

    public Student getByRollNo(int rollNo) throws Exception {
        Student student = studentRepository.getByRollNo(rollNo);
        if(student==null)
            throw new Exception("No student exists for the given roll Number");
        return student;
    }
}
