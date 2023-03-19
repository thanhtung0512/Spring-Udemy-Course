package restAPI.studentRestAPI;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PathVariableController {

    private List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(PathVariableController.class,args);
    }

    @PostConstruct
    public void loadData() {
        studentList.add(new Student("Thanh","Tung"));
        studentList.add(new Student("An","Nguyen"));
        studentList.add(new Student("Duc","Anh"));
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return studentList.get(studentId);
    }

}
