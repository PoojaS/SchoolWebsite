package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Student;
import web.repository.ListStudentsRepository;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class ListStudentsServiceImpl implements ListStudentsService{

    private ListStudentsRepository listStudentsRepository;

    @Autowired
    public ListStudentsServiceImpl(ListStudentsRepository listStudentsRepository) {

        this.listStudentsRepository = listStudentsRepository;
    }

    @Transactional
    public List<Student> getListOfStudents() {

        List<Student> students = listStudentsRepository.getStudents();
        if(students!=null)
            return students;
        return  asList(new Student());

    }
}
