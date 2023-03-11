package hibernate_tutorial.jdbc;

import hibernate_tutorial.entity.Student;
import org.hibernate.Session;

public class JdbcConnector {
    private static Class<Student> studentClass = Student.class;
    public static void main(String[] args) {
        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase,studentClass);
        try {
            Student student = new Student("Dai", "An", "21020399@vnu.edu.vn");
            Student student1 = new Student("Thanh","Tung","cudamset1125@gmail.com");
            Student student2 = new Student("Duc","Anh","ducanh@gmail.com");
            session.beginTransaction();
            session.save(student);

            System.out.println("Saved student, ID = " + student.getId());

            session.getTransaction().commit();


            // retrieve object from database


            session = HibernateUtil.getSession(currentDatabase,studentClass);
            session.beginTransaction();

            Student myStudent =  session.get(Student.class, student.getId());

            System.out.println("Retrieved student : " + myStudent.toString());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
