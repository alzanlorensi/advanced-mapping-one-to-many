package com.zanlo.advancedmappingonetoone.DAO;

import com.zanlo.advancedmappingonetoone.entities.Course;
import com.zanlo.advancedmappingonetoone.entities.Instructor;
import com.zanlo.advancedmappingonetoone.entities.InstructorDetail;
import org.springframework.transaction.annotation.Transactional;

public interface AppDAO {

    void save (Instructor theInstructor);

    Instructor findInstructorById(Integer id);

    void deleteInsctructorById(Integer id);

    InstructorDetail findInstructorDetailById(Integer id);

    @Transactional
    void deleteInstructorDetailById(Integer id);

    Course findCourseById(Integer id);

}
