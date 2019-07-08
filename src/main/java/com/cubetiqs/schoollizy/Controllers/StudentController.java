package com.cubetiqs.schoollizy.Controllers;

import com.cubetiqs.schoollizy.Models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/student/{index}")
    public Student getStudent(@PathVariable int index) {
        return this.students.get(index);
    }

    @RequestMapping("/student")
    public Student getStudentFirstOrLast(
            @RequestParam (value = "first", defaultValue = "false") boolean first,
            @RequestParam (value = "last", defaultValue = "false") boolean last
            ) {
        if (first) {
            return this.students.get(0);
        }

        if (last) {
            int last_index = this.students.size() - 1;
            return this.students.get(last_index);
        }

        return new Student(0, null, 0);
    }

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student) {
        this.students.add(student);

        return student;
    }

    @PatchMapping("/student/update/{index}")
    public Student updateStudent(@PathVariable int index, @RequestBody Student student) {
        this.students.remove(index);
        this.students.add(index, student);

        return student;
    }

    @DeleteMapping("/student/delete/{index}")
    public String deleteStudent(@PathVariable int index) {
        this.students.remove(index);

        return String.format("You have deleted student at %s", index);
    }
}
