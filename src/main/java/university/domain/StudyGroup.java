package university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_group")
    private Integer id;

    private String name;
    @OneToMany(mappedBy = "studyGroup")
    private Set<Student> students;

    public StudyGroup(String name) {
        this.name = name;
    }

    public StudyGroup() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }*/
}
