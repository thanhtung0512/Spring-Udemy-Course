package hibernate_tutorial.jdbc;

import hibernate_tutorial.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class HibernateObjectUpdate {
    private static Class<Student> studentClass = Student.class;
    public static void main(String[] args) {
        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase,studentClass);
        // update for many object in database
        try {
            session.beginTransaction();
            String queryAll = "FROM Student s";
            Student firstStudent = session.get(Student.class,1);
            session.delete(firstStudent);
            List<Student> studentList = session.createQuery(queryAll)
                            .getResultList();
            for (Student s : studentList) {
                s.setEmail(s.getFirstName().toLowerCase() + "@uet.vnu.edu");
            }
            session.getTransaction().commit();
        }
        catch (Exception e) {
        } finally {
            session.close();
        }
    }
}
