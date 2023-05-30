package com.zanlo.advancedmappingonetoone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "instructor_id_fk") //this join column is set as a FK colum
    private Instructor instructorFK;

    //constructor
    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructorFK = instructor;
    }
}
