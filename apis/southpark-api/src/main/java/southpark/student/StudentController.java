package southpark.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/students")
@ResponseStatus(HttpStatus.OK)
public class StudentController {

    @Autowired
    StudentService studentService;

    // @GetMapping()
    // public List<StudentModel> getAllStudents() {
    //     return studentService.findAll();
    // }

    @GetMapping()
    public String test() {
        return "hello spen";
    }

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable(value = "id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping()
    public StudentModel createStudent(@Valid @RequestBody StudentModel student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public StudentModel updateStudent(@PathVariable(value = "id") @Valid @RequestBody Long id, StudentModel student) {
            return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long id) {
            return studentService.delete(id);
    }

}
