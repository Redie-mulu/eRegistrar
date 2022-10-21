package edu.miu.cs.cs425.eregistrarapp.controller;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    //search
    @GetMapping(value = {"/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var student = studentService.findStudentByName(searchString);
        modelAndView.addObject("student", student);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("students/searchResult");
        return modelAndView;
    }
    @GetMapping(value = {"/new"})
    public String displayNewPublisherForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "students/new";
    }
    @PostMapping(value = {"/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
        BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
        model.addAttribute("student", student);
        model.addAttribute("errors", bindingResult.getAllErrors());
        return "students/new";
    }
    studentService.addStudent(student);
    return "redirect:/eregistrar/student/list";
    }
    // edit
    @GetMapping(value = {"/edit/{studentId}"})
    public String displayEditPublisherForm(@PathVariable Integer studentId, Model model) {
        var student = studentService.findStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }

        return "redirect:/eregistrar/student/list";
    }
    // update
    @PostMapping(value = {"/udate"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
    BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "students/edit";
        }
        studentService.updateStudent(student);
        return "redirect:/eregistrar/student/list";
    }
    // delete

    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId ) {
        studentService.deleteStudent(studentId);
        return "redirect:/eregistrar/student/list";
    }

}
