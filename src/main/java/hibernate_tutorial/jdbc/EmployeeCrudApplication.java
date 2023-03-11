package hibernate_tutorial.jdbc;

import hibernate_tutorial.entity.Employee;
import org.hibernate.Session;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeCrudApplication {

    private static Scanner sc = new Scanner(System.in);
    private static Class<Employee> employeeClass = Employee.class;


    public static void addSomeStuffEmployee() {
        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase, employeeClass);
        try {
            session.beginTransaction();
            Employee employee = new Employee("Thanh", "Tung", "CT1");
            Employee employee2 = new Employee("Dang ", "Quyen", "CT2");
            session.save(employee);
            session.save(employee2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void create(String firstName, String lastName, String company) {
        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase, employeeClass);
        try {
            session.beginTransaction();
            Employee employee = new Employee(firstName, lastName, company);
            session.save(employee);
        } catch (Exception e) {
            System.out.println("Can not save Employee to Database !!! ");
        } finally {
            session.getTransaction().commit();
        }

    }

    public static Employee retrieve(int id) {
        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase, employeeClass);
        try {
            session.beginTransaction();
            Employee retrieved = session.get(Employee.class, id);
            return retrieved;
        } catch (Exception e) {
            System.out.println("The desired employee does not exist in database !!!! ");
        } finally {
            session.getTransaction().commit();
        }
        return null;
    }


    public static void update(int id) {
        String currentDatabase = "hb_student_tracker";
        Session session = HibernateUtil.getSession(currentDatabase, Employee.class);
        Field[] fieldList = Employee.class.getDeclaredFields();
        String fieldsBeAddedToMenu = "";
        String pattern = "-----";
        for (int i = 1; i <= fieldList.length; i++) {
            fieldsBeAddedToMenu += pattern + i + ". " + fieldList[i - 1].getName() + "\n";
        }


        try {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            System.out.println(employee.toString());
            String menu = "Which field do you want to be updated: \n " + fieldsBeAddedToMenu;
            System.out.println(menu);
            int userChoose = sc.nextInt() - 1;
            String inputValue = "New value for this field is ? ";
            System.out.println(inputValue);

            if (fieldList[userChoose].getType().equals(String.class)) {
                fieldList[userChoose].setAccessible(true);
                fieldList[userChoose].set(employee, sc.next());
            } else if (fieldList[userChoose].getType().equals(Integer.class)) {
                fieldList[userChoose].setAccessible(true);
                fieldList[userChoose].set(employee, sc.nextInt());
            }

        } catch (Exception e) {
            System.out.println("The desired employee does not exist in database !!!! ");
        } finally {
            session.getTransaction().commit();
        }
    }


    public static void delete(int id) {
        try {
            Employee employee = retrieve(id);
            String currentDatabase = "hb_student_tracker";
            Session session = HibernateUtil.getSession(currentDatabase, Employee.class);
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showMenu(String menu) {
        System.out.println(menu);
    }

    public static void main(String[] args) {
        String menu = "USER INTERFACE : \n 1. CREATE EMPLOYEE \n 2. RETRIEVE EMPLOYEE \n 3. UPDATE EMPLOYEE \n 4. DELETE EMPLOYEE";
        while (true) {
            showMenu(menu);
            int userInputt = sc.nextInt();
            switch (userInputt) {
                case 1:
                    showMenu("First name: ");
                    String firstName = sc.next();
                    showMenu("Last name: ");
                    String lastName = sc.next();
                    showMenu("Company: ");
                    String company = sc.next();
                    create(firstName, lastName, company);
                    break;

                case 2:
                    showMenu("Employee's ID you want to retrieve ! \n Type here : ");
                    retrieve(sc.nextInt());
                    break;

                case 3:
                    String userInput = "Employee's ID you want to update ! \n Type here : ";
                    showMenu(userInput);
                    update(sc.nextInt());
                    break;

                case 4:
                    showMenu("Employee's ID you want to delete ! \n Type here : ");
                    delete(sc.nextInt());
                    break;
            }

        }
    }
}
