package web.service;


import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import web.model.Student;
import web.repository.StudentRepository;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class StudentSeviceImplTest {

    StudentService studentService;
    Student student;

    @Mock
    StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        studentService = new StudentSeviceImpl(studentRepository);
        student = new StudentBuilder().withDefaults().withName("Pooja");
    }

    @Test
    public void shouldSaveAStudentObjectIfItExists() {
        doNothing().when(studentRepository).save(student);
        studentService.saveDetails(student);
        verify(studentRepository).save(student);
    }

    @Test
    public void shouldNotSaveAStudentObjectIfItIsNull() {
        student = null;
        studentService.saveDetails(student);
    }

    @Test
    public void shouldGetStudentById() throws Exception {
        int rollNo = 1;
        when(studentRepository.getByRollNo(rollNo)).thenReturn(student);
        Student result = studentService.getByRollNo(rollNo);
        assertThat(result.getRollNo(), is(rollNo));
        verify(studentRepository).getByRollNo(rollNo);
    }

    @Test
    public void shouldThrowExceptionIfStudentNotFound() {
        int rollNo = 1;
        when(studentRepository.getByRollNo(rollNo)).thenReturn(null);
        try {
            studentService.getByRollNo(rollNo);
            fail("Expected exception");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("No student exists for the given roll Number"));
        }   finally {
            verify(studentRepository).getByRollNo(rollNo);
        }

    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(studentRepository);
    }
}

