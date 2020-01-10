package university.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idStudent;

    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "id_group", nullable = false)
    private StudyGroup studyGroup;


    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, StudyGroup studyGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studyGroup = studyGroup;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
