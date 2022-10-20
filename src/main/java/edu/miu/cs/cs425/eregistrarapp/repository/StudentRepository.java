package edu.miu.cs.cs425.eregistrarapp.repository;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}