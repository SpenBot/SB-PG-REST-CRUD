package southpark.student;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "students")

public class StudentModel {




    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long student_id;

    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotBlank
    @Column(name="last_name")
    private String lastName;

    @NotBlank
    private String grade;

    @NotBlank
    private String email;


    public Long getId() {
        return this.student_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

