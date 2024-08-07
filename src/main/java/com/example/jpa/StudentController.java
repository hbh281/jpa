package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }
    //READALL
    @GetMapping
    public String readAll(Model model){
        model.addAttribute("studentList",service.readAll());
        return "students/home.html";
    }
    @GetMapping("{id}")
    public String update(Model model,
                         @PathVariable("id")
                         Long id){
        model.addAttribute("student",service.readOne(id));
        return "students/update.html";
    }
}
