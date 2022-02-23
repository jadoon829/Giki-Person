package com.example.demo.view;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import com.example.demo.model.MyOptional;
import com.example.demo.model.StudentModel;


public class StudentView {

    private static final Logger log = Logger.getLogger(StudentView.class.getName());

    public void showHighestId(int studentHighestId) {
        log.info("Highest Id: " + studentHighestId);
    }

    public void showStudentWithHighestId(MyOptional<StudentModel> studentWithHighestId){
        log.info("Student With Highest Id" + studentWithHighestId);
    }

    public void showBiggestName(String biggestName) {
        log.info("Student biggest Name: " + biggestName);
    }

    public void showBiggestNameLength(int biggestNameLength){
        log.info("Student biggest Name length: " + biggestNameLength);
    }

    public void showHighestMarks(int studentHighestmarks){
        log.info("Student Highest Marks: " + studentHighestmarks);
    }

    public void showStudentWithHighestMarks(MyOptional studentWithHighestMarks){
        log.info("Student With Highest Marks: " + studentWithHighestMarks);
    }

    public void showHighestRollno( int rollno) {
        log.info("Highest roll no is: " +rollno);
    }

    public  void showStudentWithHighestRollNo(MyOptional<StudentModel> studentWithHighestRollNo){
        log.info("student with highest rollno is : " + studentWithHighestRollNo);
    }

    public void showStudentsWithFacultyCs(Collection<String> studentWithFacultyCs) {
        log.info("Students from CS Faculty are \n : " + studentWithFacultyCs);

    }

    public void showFacultyOfLowestMarks(String facultyOfLowestMarks){
        log.info("Faculty of the student with Lowest marks is: " + facultyOfLowestMarks);
    }

    public void printStudent(String foundText, String notFoundText, Optional<StudentModel> studentModel){
        if(studentModel.isPresent()) {
            log.info(foundText + studentModel.get());
        } else {
            log.warning(notFoundText);
        }
    }

    public void addStudent(StudentModel studentModel){
        log.info("New Student is: " + studentModel);
    }

    public void ifHasStudent(String text, boolean b){
        log.info(text + b);
    }

    public void showIfHasDeleted(boolean b){
        log.info("The record of rollno 8 has been deleted: " + b);
    }

    public void showIfObjectHasBeenDeleted(String text, boolean b){
        log.info(text + b);
    }
}
