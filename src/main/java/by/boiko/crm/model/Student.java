package by.boiko.crm.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @ManyToOne()
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public Student() {
    }

    public Student(String fullName, Group group) {
        this.fullName = fullName;
        this.group = group;
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Integer getNumberGroup() {
        if (group == null) {
            return null;
        }
        return group.getNumberGroup();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}