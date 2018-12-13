package southpark.student;

import org.springframework.http.ResponseEntity;
import southpark.common.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



//    GET ALL ////////////////////////////////////////////////////

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }



//    GET ONE BY ID //////////////////////////////////////////////

    public StudentModel findById(Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(()->new NotFoundException("No STUDENT with id " + id ));
    }



//    CREATE /////////////////////////////////////////////////////

    public StudentModel save(StudentModel student) { return studentRepository.save(student); }



//    UPDATE /////////////////////////////////////////////////////

    public StudentModel update(Long id, StudentModel student) {

        StudentModel toUpdateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No STUDENT with id " + id ));

        toUpdateStudent.setFirstName(student.getFirstName());
        toUpdateStudent.setLastName(student.getLastName());
        toUpdateStudent.setGrade(student.getGrade());
        toUpdateStudent.setEmail(student.getEmail());

        StudentModel updatedStudent = studentRepository.save(toUpdateStudent);
        return updatedStudent;

    }



//    DELETE /////////////////////////////////////////////////////

    public ResponseEntity<?> delete(Long id) {

        StudentModel toDeleteStudent = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No STUDENT with id " + id ));


        studentRepository.delete(toDeleteStudent);
        return ResponseEntity.ok().build();
    }



}

