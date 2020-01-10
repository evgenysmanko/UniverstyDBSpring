package university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import university.domain.StudyGroup;
import university.domain.Student;
import university.repos.GroupRepository;
import university.repos.StudentRepository;

import java.util.Iterator;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @PostMapping(path = "/addStudent")
    public @ResponseBody
    String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String groupName){
        StudyGroup studyGroup = groupRepository.findByName(groupName).orElse(groupRepository.save(new StudyGroup(groupName)));
        studentRepository.save(new Student(firstName, lastName, studyGroup));
        return firstName+" "+lastName+" saved!";
    }

    @GetMapping(path = "/allStudents")
    public @ResponseBody String getAllStudents(){
        String res = "";
        Iterator iterator = studentRepository.findAll().iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            res += " {" + student.getFirstName() + " " + student.getLastName() + " }";
        }
        return res;
    }


    @GetMapping("/allGroup")
    public @ResponseBody String getAllGroup(){
        return groupRepository.findAll().stream()
                .map(group -> "{"+group.getName()+"}")
                .reduce("Список групп: ", (t1, t2) -> t1 + t2);
    }
}