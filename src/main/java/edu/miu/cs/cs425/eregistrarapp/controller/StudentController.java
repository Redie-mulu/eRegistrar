package edu.miu.cs.cs425.eregistrarapp.controller;

import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/eregistrar/student"})
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list")// /eregistrar/student/list
    public ModelAndView listStudents() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
//        modelAndView.setViewName("secured/sysadmin/students/list");
        modelAndView.setViewName("students/list");
        return modelAndView;
    }
    @GetMapping(value = {"/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var student = studentService.findStudentByName(searchString);
        modelAndView.addObject("student", student);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/sysadmin/students/searchResult");
        return modelAndView;
    }

}
