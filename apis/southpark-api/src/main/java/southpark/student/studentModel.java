package southpark.student;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "students")
//@EntityListeners(AuditingEntityListener.class)

public class studentModel {

    @Id
    private Long student_id;

    @NotBlank
    private String first_name;

    @NotBlank
    private String last_name;

    @NotBlank
    private String grade;

    @NotBlank
    private String email;

}
