package edu.miu.cs.cs425.eregistrarapp;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ERegistrarappApplication implements CommandLineRunner {
    private StudentService studentService;

    public ERegistrarappApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        SpringApplication.run(ERegistrarappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate d1 = LocalDate.of(2020, 1,8);
        LocalDate d2 = LocalDate.of(2022, 1,8);
        Student s1 = new Student(null, "000-61-0001", "Anna","w", "Smith",3.65,d1,"yes");
        Student s2 = new Student(null, "000-61-0002", "Redi","m", "Wold",3.65,d1,"no");
        Student s3 = new Student(null, "000-61-0002", "Dagi","m", "Mulu",3.65,d1,"no");
        Student s4 = new Student(null, "000-61-0002", "Mesi","m", "Wold",3.65,d1,"no");
        Student s5 = new Student(null, "000-61-0002", "Betty","m", "Yihe",3.65,d1,"no");
        Student s6 = new Student(null, "000-61-0002", "Dani","m", "Bogale",3.65,d1,"no");

        studentService.addStudent(s1);
        studentService.addStudent(s2);
        studentService.addStudent(s3);
        studentService.addStudent(s4);
        studentService.addStudent(s5);
        studentService.addStudent(s6);
    }
}
