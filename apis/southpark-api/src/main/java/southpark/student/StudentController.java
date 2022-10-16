package southpark.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

import southpark.service.AwsSesService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/students")
@ResponseStatus(HttpStatus.OK)
public class StudentController {

    // @Autowired
    // StudentService studentService;

    @Autowired
    private AwsSesService awsSesService;

    // @GetMapping()
    // public List<StudentModel> getAllStudents() {
    //     return studentService.findAll();
    // }

    @GetMapping()
    public ResponseEntity test() {
        SendEmailRequest sendEmailRequest = awsSesService.generateSesEmailRequest();
        SendEmailResult sendEmailResult = awsSesService.sendEmail(sendEmailRequest); 

        return ResponseEntity.ok(sendEmailResult);
    }

    // @GetMapping("/{id}")
    // public StudentModel getStudentById(@PathVariable(value = "id") Long id) {
    //     return studentService.findById(id);
    // }

    // @PostMapping()
    // public StudentModel createStudent(@Valid @RequestBody StudentModel student) {
    //     return studentService.save(student);
    // }

    // @PutMapping("/{id}")
    // public StudentModel updateStudent(@PathVariable(value = "id") @Valid @RequestBody Long id, StudentModel student) {
    //         return studentService.update(id, student);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long id) {
    //         return studentService.delete(id);
    // }

}
