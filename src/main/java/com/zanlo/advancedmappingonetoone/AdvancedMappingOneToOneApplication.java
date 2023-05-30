package com.zanlo.advancedmappingonetoone;

import com.zanlo.advancedmappingonetoone.DAO.AppDAO;
import com.zanlo.advancedmappingonetoone.entities.Course;
import com.zanlo.advancedmappingonetoone.entities.Instructor;
import com.zanlo.advancedmappingonetoone.entities.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingOneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedMappingOneToOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner ->
                //createInstructor(appDAO);
                //findInstructor(appDAO);
                //deleteInstructor(appDAO);
                //findInstructorDetail(appDAO);
                //deleteInstructorbyID(appDAO);
                findCoursebyId(appDAO);
                //showAllCoursesByInstructor(appDAO);

    }

    private void showAllCoursesByInstructor(AppDAO appDAO) {
        int theId = 2;
        Instructor tmpInstructor = appDAO.findInstructorById(theId);

        tmpInstructor.getCourses().forEach(c -> System.out.println("Course's name " +c.getTitle()));

    }

    private void findCoursebyId(AppDAO appDAO) {
        int theId = 1;
        Course course = appDAO.findCourseById(theId);
        System.out.println("The course is " + course.getTitle()
                + "\nthe instrutor's id is: " + course.getInstructorFK().getId()
                + "\nthe instructor's name is " + course.getInstructorFK().getFirs_name()
                + "\nthe instructor's hobby is " + course.getInstructorFK().getInstructorDetail().getHobby()
        );
    }

    private void deleteInstructorbyID(AppDAO appDAO) {
        int theId = 3;
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Deleted: " + theId);

        /*
         * If I want to just delete Instructor detail i will have to modify my code
         * Fist i need to change the cascate types in my Instructor detail file
         * !OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
         * it means that cascateType wont effect detail
         * # Send i will have to break the bidirectional association seeting my instructordetail to null so the method  would have to be
         * @Override
         * @Transactional
         *public void deleteInsctructorById(Integer id) {
         * Instructor temp = entityManager.find(Instructor.class, id);
         * temp.getInstructor.setinstructorDetail(null)
         * entityManager.remove(temp);
         *  }
         * basically i'd have to set my detail to null
         * */
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 4;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
        System.out.println("The instructor is " + instructorDetail.getInstructor().getId() + " " + instructorDetail.getInstructor().getFirs_name());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        appDAO.deleteInsctructorById(theId);
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 4;
        Instructor tempInstructo = appDAO.findInstructorById(theId);
        System.out.println(tempInstructo);
    }

    private void createInstructor(AppDAO appDAO) {

        Instructor tempInstructor =
                new Instructor("karen", "Zanlorensi", "aza@gmail.com");
        InstructorDetail instructorDetail =
                new InstructorDetail("Implantador", "Jogar");
        tempInstructor.setInstructorDetail(instructorDetail);
        Course course =
                new Course("Java Programming", tempInstructor);
        tempInstructor.addcourse(course);

        appDAO.save(tempInstructor);

    }

}
