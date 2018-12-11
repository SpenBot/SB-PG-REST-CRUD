package southpark.student;

import southpark.student.studentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface studentRepository extends JpaRepository<studentModel, Long> {

}