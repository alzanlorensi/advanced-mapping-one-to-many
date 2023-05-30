package com.zanlo.advancedmappingonetoone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "instructor_detail_one_to_many")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "job")
    private String job;

    @Column(name = "hobby")
    private String hobby;

    //add new field for instructior -->Here its the name of my field in class Instructor
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //
    //* here i cascate every cascate type, if i dont wanna cascate delete it would be like this
    //!OneToOne(mappedBy = "instructorDetail",
    //!         cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail(String job, String hobby) {
        this.job = job;
        this.hobby = hobby;
    }


}
