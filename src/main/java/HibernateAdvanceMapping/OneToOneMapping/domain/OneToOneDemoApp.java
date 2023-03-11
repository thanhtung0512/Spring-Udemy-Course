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
        InstructorDetail instructorDetail = session.get(instructorDetailClass,2);
        session.delete(instructorDetail);

        session.getTransaction().commit();
    }
}
