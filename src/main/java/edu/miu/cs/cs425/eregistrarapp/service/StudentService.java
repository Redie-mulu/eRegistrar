package edu.miu.cs.cs425.eregistrarapp.service;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
//    public List<Student> getAllStudents();
    public Page<Student> getAllStudents(int pageNo);

    public Student addStudent(Student student);
    public Student editStudent(Integer studentId, Student student);
    public void deleteStudent(Integer studentId);
    public Student findStudentById(Integer studentId);
    public Student findStudentByName(String name);
    public Student getStudentById(Integer studentId);
    public void updateStudent(Student student);
    public List<Student> searchStudent(String searchString);

}
