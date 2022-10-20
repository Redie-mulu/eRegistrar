package edu.miu.cs.cs425.eregistrarapp.service.Imp;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrarapp.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student editStudent(Integer studentId, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Integer studentId) {

    }

    @Override
    public Student findStudentById(Integer studentId) {
        return null;
    }
}
