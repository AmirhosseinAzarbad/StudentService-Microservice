package ir.speedy.studentservice.controllers;

import ir.speedy.studentservice.models.Student;
import ir.speedy.studentservice.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/show")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/insert")
    public Student InsertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

}
