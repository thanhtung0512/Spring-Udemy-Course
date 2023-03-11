package hibernate_tutorial.jdbc;

import hibernate_tutorial.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class HibernateQueryObject {
    private static Class<Student> studentClass = Student.class;
    public static void main(String[] args) {

        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase,studentClass);

        try {

            session.beginTransaction();

            List<Student> studentList = session
                    .createQuery("from Student s where" + " s.email = '21020399@vnu.edu.vn' ")
                    .getResultList();

            for (Student s : studentList) {
                System.out.println(s.toString() + "\n");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }


    }
}
