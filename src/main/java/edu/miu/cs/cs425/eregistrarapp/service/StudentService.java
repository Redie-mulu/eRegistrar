package edu.miu.cs.cs425.eregistrarapp.service;

import edu.miu.cs.cs425.eregistrarapp.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student addStudent(Student student);
    public Student editStudent(Integer studentId, Student student);
    public void deleteStudent(Integer studentId);
    public Student findStudentById(Integer studentId);

}
