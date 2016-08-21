package by.boiko.crm.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "NUMBER")
    private Integer numberGroup;

    @OneToMany(mappedBy = "group")
    private Set<Student> student;

    public Group() {
    }

    public Group(Set<Student> student, Integer numberGroup, Integer id) {
        this.id = id;
        this.student = student;
        this.numberGroup = numberGroup;
    }

    public Group(Integer numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(Integer numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", numberGroup=" + numberGroup +
                ", student=" + student +
                '}';
    }
}