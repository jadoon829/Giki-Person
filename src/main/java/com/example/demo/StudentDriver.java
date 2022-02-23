package com.example.demo;

import com.example.demo.controller.StudentController;
import com.example.demo.model.*;
import com.example.demo.view.StudentView;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;



public class StudentDriver extends PersonDriver<StudentModel> {

    StudentView studentView = new StudentView();
    public StudentDriver() {
        personController = new StudentController();
    }
    private static final Logger log = Logger.getLogger(StudentView.class.getName());

    public void execute() {
        log.info("\n-------------- StudentDriver --------------\n");
        super.execute();

        studentView.showHighestId(highestId);
        studentView.showStudentWithHighestId(personWithHighestId);
        studentView.showBiggestName(biggestName);
        studentView.showBiggestNameLength(biggestNameLength);
        int studentHighestMarks = 0; // ((StudentController)personController).getHighestMarks();
        studentView.showHighestMarks(studentHighestMarks);
        MyOptional studentWithHighestMarks = null ;// ((StudentController)personController).getStudentWithHighestMarks();
        studentView.showStudentWithHighestMarks(studentWithHighestMarks);
        int highestRollNo = 0;//((StudentController)personController).getHighestRollno();
        studentView.showHighestRollno(highestRollNo);
        MyOptional<StudentModel> studentWithHighestRollNo = ((StudentController)personController).studentWithHighestRollNo();
        studentView.showStudentWithHighestRollNo(studentWithHighestRollNo);
        Collection<String> studentWithFacultyCs = null;//((StudentController)personController).getStudentWithFacultyCS();
        studentView.showStudentsWithFacultyCs(studentWithFacultyCs);
        String facultyWithLowestMarks = ((StudentController)personController).getFacultyOfLowestMarks();
        studentView.showFacultyOfLowestMarks(facultyWithLowestMarks);

        Optional<StudentModel> studentByRollno = ((StudentController)personController).getStudent(6);
        studentView.printStudent("Student with Rollno 6: ", "Not found.", studentByRollno);

        StudentModel student6 = new StudentModel(10,"Naeem", 44, FacultyType.CS, StudentType.BACHELOR);
        StudentModel newStudent = ((StudentController)personController).addStudent(student6);
        studentView.addStudent(newStudent);
        boolean b = ((StudentController)personController).hasStudent(9);
        studentView.ifHasStudent("Student with rollno 9 Exist: ", b);
        boolean deleteStudent = true;//((StudentController)personController).deleteStudent(8);
        studentView.showIfHasDeleted(deleteStudent);
        boolean objectDeleted = null != ((StudentController)personController).deleteStudent(student6);
        studentView.showIfObjectHasBeenDeleted("The object has been deleted: ", objectDeleted);
    }
}
