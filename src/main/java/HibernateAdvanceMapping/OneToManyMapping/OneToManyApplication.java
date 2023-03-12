package HibernateAdvanceMapping.OneToManyMapping;

import hibernate_tutorial.jdbc.HibernateUtil;
import org.hibernate.Session;

public class OneToManyApplication {

    private static String currentDatabase = "hb-03-one-to-many";
    private static Class<Instructor> instructorClass = Instructor.class;
    private static Class<Course> courseClass = Course.class;
    private static Class<InstructorDetail> instructorDetailClass = InstructorDetail.class;


    private static void show(String s) {
        System.out.println(s);
    }

    private static void listCourses(Instructor instructor) {
        for (Course course : instructor.getCourseList()) {
            show(course.toString() + "/n");
        }
    }


    private static void addCourseToInstructor(Session session) {
        Instructor instructor = new Instructor("Viet", "Hoang", "vh@vnu.edu.vn");
        InstructorDetail instructorDetail = new InstructorDetail("Youtube", "Violin");
        instructor.setInstructorDetail(instructorDetail);
        instructorDetail.setInstructor(instructor);
        session.save(instructor);
        Course osConcept = new Course("OS Concept");
        instructor.addCourse(osConcept);
        session.save(osConcept);
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession(currentDatabase, instructorClass, courseClass, instructorDetailClass);
        session.beginTransaction();

        /*Course course1 = new Course("Spring for Beginner");
        Course course2 = new Course("Data structure and algorithm");
        Course course3 = new Course("Database Management System");

        session.save(course1);
        session.save(course2);
        session.save(course3);

        Instructor instructor = new Instructor("Le Quang","Hieu","hieulq@vnu.edu.vn");

        instructor.addCourse(course1);
        instructor.addCourse(course2);
        instructor.addCourse(course3);

        InstructorDetail instructorDetail = new InstructorDetail("hieulqYoutube","Football");

        instructor.setInstructorDetail(instructorDetail);

        instructorDetail.setInstructor(instructor);

        session.save(instructor);*/


        addCourseToInstructor(session);


        session.getTransaction().commit();

    }
}
