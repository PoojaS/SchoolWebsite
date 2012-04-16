package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import web.Builders.StudentBuilder;
import web.model.Student;
import web.repository.ListStudentsRepository;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListStudentsServiceImplTest {

    ListStudentsServiceImpl serviceImpl;
    @Mock
    ListStudentsRepository repository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        serviceImpl = new ListStudentsServiceImpl(repository);
    }

    @Test
    public void shouldGiveAListOfStudentsAvailable(){

        Student student1 = new StudentBuilder().withDefaults().build();
        Student student2 = new StudentBuilder().withDefaults().build();
        when(repository.getStudents()).thenReturn(asList(student1, student2));

        List<Student> students = serviceImpl.getListOfStudents();

        assertThat(students,hasItems(student1,student2));
        verify(repository).getStudents();
    }

    @Test
    public void shouldReturnEmptyStudentWhenNoStudentAvailable() {

        when(repository.getStudents()).thenReturn(null);

        List<Student> students = serviceImpl.getListOfStudents();

        assertThat(students, notNullValue());
        verify(repository).getStudents();
    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(repository);
    }
}
