package com.example.demo.controller;



import java.util.*;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.FacultyType;
import com.example.demo.model.MyOptional;
import com.example.demo.model.StudentModel;
import com.example.demo.service.PersonService;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "student")
public class StudentController extends PersonController<StudentModel> {

    StudentService studentService = new StudentService();

    @GetMapping(value = "highestmarks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getHighestMarks() {

        Optional<StudentModel> highestMarks = studentService.getPersonList().
                stream().max(Comparator.comparingInt(StudentModel::getMarks));
        try {
            return ResponseEntity.ok(MyOptional.toMyOptional(highestMarks).get().getMarks());
        } catch (MyOptionalException excep){
            String str = "Couldn't find highest mask, details: " + excep.getDescription();
            System.out.println(str);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(str);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(-1);
    }

    @GetMapping(value = "withhighestmarks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentModel> getStudentWithHighestMarks(){

        Collection<StudentModel> studentModelArrayList = studentService.getPersonList();
        Optional<StudentModel> studentWithHighestMarks = studentModelArrayList.stream().
                max(Comparator.comparingInt(StudentModel::getMarks));

        return ResponseEntity.ok(studentWithHighestMarks.get());
    }

    @GetMapping(value = "highestrollno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getHighestRollno() {

        MyOptional<StudentModel> highestRollNo = MyOptional.toMyOptional(studentService.getPersonList().
                stream().max(Comparator.comparingInt(StudentModel::getRollNumber)));
        try{
            return ResponseEntity.ok(highestRollNo.get().getRollNumber());
        }
        catch (MyOptionalException e){
            String str = "ErrorCode.E_MYOPTIONAL, Details" + e.getDescription();
            System.out.println(str);
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(str);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(-1);
    }

    public MyOptional<StudentModel> studentWithHighestRollNo() {
        Optional<StudentModel> studentWithHighestRollNo = studentService.getPersonList().
                stream().max(Comparator.comparing(StudentModel::getRollNumber));

        return MyOptional.toMyOptional(studentWithHighestRollNo);
    }

    @GetMapping(value = "withfacultycs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<String>> getStudentWithFacultyCS() {
        Collection<String> studentsFromCS = new ArrayList<>();
        for (StudentModel s : studentService.getPersonList()) {
            if (s.getFaculty().equals(FacultyType.CS)) {
                String name = s.getName();
                studentsFromCS.add(name);

            }
        }
        ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("students", "from cs")
                .body("Accepted");
        return ResponseEntity.ok(studentsFromCS);

    }

    public String getFacultyOfLowestMarks() {
        Optional<StudentModel> lowestMarks = studentService.getPersonList().stream().
                min(Comparator.comparingInt(StudentModel::getMarks));

        return lowestMarks.get().getFaculty().toString();
    }

    @GetMapping(value = "all")
    public List<StudentModel> getStudents(){
        return studentService.getPersonList();
    }
    @GetMapping(value = "count")
    public int getStudentCount(){
        return studentService.getPersonList().size();
    }
    public Optional<StudentModel> getStudent(int rollno){  //Stub
       return studentService.getStudent(rollno);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentModel addStudent(@RequestBody StudentModel addStudentModel){
        studentService.addPerson(addStudentModel);
        return addStudentModel;
    }

    public boolean hasStudent(int rollno){
       return studentService.hasStudent(rollno);
    }

    @DeleteMapping(value ="{rollno}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentModel> deleteStudent(@PathVariable int rollno){
        try {
             ResponseEntity.status(HttpStatus.ACCEPTED).body("trying");
             return ResponseEntity.ok(studentService.deleteStudent(rollno));
        }
        catch (MyOptionalException e){
            System.out.println("no student has been found" + e.getDescription());
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentModel> deleteStudent(@RequestBody StudentModel studentModel){
        try {
            StudentModel studentModel1 = studentService.deletePerson(studentModel);
            return ResponseEntity.ok(studentModel1);
        }
        catch (MyOptionalException ec){
            System.out.println("no person could be found" + ec.getDescription());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    @Override
    public PersonService<StudentModel> getService() {
        return studentService;
    }
}


