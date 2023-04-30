package com.management.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "designation_type")
    private String designationType;

    @ManyToMany(fetch =FetchType.LAZY)
    @JoinTable(
            name = "designation_department",
            joinColumns = @JoinColumn(name = "designation_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departments;


    public Integer getId() {
        return id;
    }

    public Designation setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDesignationType() {
        return designationType;
    }

    public Designation setDesignationType(String designationType) {
        this.designationType = designationType;
        return this;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Designation setDepartments(List<Department> departments) {
        this.departments = departments;
        return this;
    }

    @Override
    public String toString() {
        return "Designation{" +
                "id=" + id +
                ", designationType='" + designationType + '\'' +
                '}';
    }
}
