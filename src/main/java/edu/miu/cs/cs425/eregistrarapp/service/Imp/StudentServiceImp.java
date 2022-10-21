package edu.miu.cs.cs425.eregistrarapp.service.Imp;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrarapp.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import org.springframework.data.domain.Sort;
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
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
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

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.findStudentsByFirstName(name);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findStudentByStudentId(studentId);
    }

    @Override
    public void updateStudent(Student student) {
        Student s =  studentRepository.findStudentByStudentId(student.getStudentId());
        s = student;
    }

    @Override
    public List<Student> searchStudent(String searchString) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrCgpaContainingOrEnrollmentDateContainingOrStudentIdContainingOrStudentNumberContaining(
                searchString, searchString,searchString, searchString, searchString, searchString,searchString
        );
    }
}
