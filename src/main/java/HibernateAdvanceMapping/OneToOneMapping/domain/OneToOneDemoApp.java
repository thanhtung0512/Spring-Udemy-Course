package HibernateAdvanceMapping.OneToOneMapping.domain;

import hibernate_tutorial.jdbc.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemoApp {
    private static String currentDatabase = "hb-01-one-to-one-uni";
    private static Class<Instructor> instructorClass = Instructor.class;
    private static Class<InstructorDetail> instructorDetailClass = InstructorDetail.class;
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession(currentDatabase,instructorClass,instructorDetailClass);
        session.beginTransaction();

        // doing stuff while transaction

/*
        delete from instructor detail without delete instructor
        we need to unlink from the instructor to current instructor_details
        and set cascade on all operation except the CascadeType.ALL

        InstructorDetail instructorDetail = session.get(InstructorDetail.class,5);
        instructorDetail.getInstructor().setInstructorDetail(null);
        session.delete(instructorDetail);
*/

        session.getTransaction().commit();
    }
}
