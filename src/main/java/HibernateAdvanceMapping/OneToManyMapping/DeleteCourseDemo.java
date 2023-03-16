package HibernateAdvanceMapping.OneToManyMapping;

import hibernate_tutorial.jdbc.HibernateUtil;
import org.hibernate.Session;

public class DeleteCourseDemo {

     /* config for getting session */
    private static String currentDatabase = "hb-03-one-to-many";
    private static Class<Instructor> instructorClass = Instructor.class;
    private static Class<Course> courseClass = Course.class;
    private static Class<InstructorDetail> instructorDetailClass = InstructorDetail.class;

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession(currentDatabase, instructorClass, courseClass, instructorDetailClass);
        try {
            session.beginTransaction();
            Course course = session.get(courseClass,25);
            session.delete(course);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
