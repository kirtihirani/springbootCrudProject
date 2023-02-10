package com.xadmin.SpringBootCrud;

import com.xadmin.SpringBootCrud.bean.Student;
import com.xadmin.SpringBootCrud.repository.StudentRepository;
import com.xadmin.SpringBootCrud.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class SpringBootCrudApplicationTests {
	@Autowired
	private StudentService service;
	@MockBean
	private StudentRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllStudents(){
		when(repository.findAll()).thenReturn(Stream.of(new Student("34","hirani","yagya","palsikar","indore")).collect(Collectors.toList()));
		assertEquals(1,service.getAllStudents().size());
	}
	@Test
	public void findByCity(){
		String city = "indore";
		when(repository.findByCity(city)).thenReturn(Stream.of(
				new Student("23","bhatia","divi","elite","indore"),
				new Student("21","riddle","tom","curchgate","chicago")
		).collect(Collectors.toList()));
		assertEquals(2,service.getByCity(city).size());
	}

	@Test
	public void saveStudent(){
		Student s = new Student("5","jack","potter","time square","usa");
		when(repository.save(s)).thenReturn(s);
		assertEquals(s,service.addStudent(s));
	}

	@Test
	public void deleteStudent(){
		Student s = new Student("5","jack","potter","time square","usa");
		service.deleteStudent(s.getId());
		verify(repository,times(1)).deleteById(s.getId());
	}

}
