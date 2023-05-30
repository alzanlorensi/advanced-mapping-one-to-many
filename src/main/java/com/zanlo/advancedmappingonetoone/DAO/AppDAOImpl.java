package com.zanlo.advancedmappingonetoone.DAO;

import com.zanlo.advancedmappingonetoone.entities.Course;
import com.zanlo.advancedmappingonetoone.entities.Instructor;
import com.zanlo.advancedmappingonetoone.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(Integer theid) {

        return entityManager.find(Instructor.class, theid);
    }

    @Override
    @Transactional
    public void deleteInsctructorById(Integer id) {
        Instructor temp = entityManager.find(Instructor.class, id);
        entityManager.remove(temp);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer theid) {
        return entityManager.find(InstructorDetail.class, theid);
    }

    @Override
    public void deleteInstructorDetailById(Integer id) {
        InstructorDetail temp = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(temp);
    }

    @Override
    public Course findCourseById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> showAllCoursesByInstructor(Integer id) {
        Instructor tmpInstructor = entityManager.find(Instructor.class,id);
        return tmpInstructor.getCourses();
    }
}
