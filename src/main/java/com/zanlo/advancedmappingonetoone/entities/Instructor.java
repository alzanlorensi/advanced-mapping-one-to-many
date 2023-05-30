package com.zanlo.advancedmappingonetoone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor_one_to_many")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firs_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    public Instructor(String firs_name, String last_name, String email) {
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.email = email;
    }

    @OneToMany(mappedBy = "instructorFK",fetch = FetchType.EAGER, cascade =
            {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,
                    CascadeType.DETACH}) //references the field InstructorFK in my Course class
    private List<Course> courses;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_detail_one_to_many_fk") //defined it in instructor table
    private InstructorDetail instructorDetail;

    //convenience methods for bi-directional relationship
    public void addcourse( Course tmpcourse){
        if (courses ==null){
            courses = new ArrayList<>();
        }

        courses.add(tmpcourse);
        tmpcourse.setInstructorFK(this);
    }

}
