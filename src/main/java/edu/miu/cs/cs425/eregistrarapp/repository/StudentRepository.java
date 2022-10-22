package edu.miu.cs.cs425.eregistrarapp.repository;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findStudentsByFirstName(String firstName);
    public Student findStudentByStudentId(Integer studentId);
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrCgpaContainingOrEnrollmentDateContainingOrStudentIdContainingOrStudentNumberContaining(
            String lastName, String firstName, String middleName, String cgpa, String enrollmentDate, String studentId, String studentNumber
    );
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContaining(
            String lastName, String firstName, String middleName
    );
}
