package restAPI.studentRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/api")
public class StudentRestController {

    public static void main(String[] args) {
        SpringApplication.run(StudentRestController.class,args);
    }

    @GetMapping("/list")
    public List<Student> getStudentList () {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Thanh","Tung"));
        studentList.add(new Student("Cao","Trung"));
        studentList.add(new Student("Duc","Anh"));
        studentList.add(new Student("An","Nguyen"));
        studentList.add(new Student("Dai","An"));
        return studentList;
    }



    /*[
    {
        "firstName": "Thanh",
            "lastName": "Tung"
    },
    {
        "firstName": "Cao",
            "lastName": "Trung"
    },
    {
        "firstName": "Duc",
            "lastName": "Anh"
    },
    {
        "firstName": "An",
            "lastName": "Nguyen"
    }*/
//]
}
