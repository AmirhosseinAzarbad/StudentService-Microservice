package ir.speedy.studentservice.controllers;

import ir.speedy.studentservice.models.Library;
import ir.speedy.studentservice.models.Student;
import ir.speedy.studentservice.services.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/student/v1")
public class StudentController {
    private final RestTemplate restTemplate;
    private final StudentService studentService;

    public StudentController(StudentService studentService, RestTemplate restTemplate) {
        this.studentService = studentService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/show")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        Library library = restTemplate.getForObject("http://localhost:9092/api/library/v1/" + id, Library.class);
        Student student =  studentService.getStudentById(id);
        student.setLibrary(library);
        return student;
    }

    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

}
