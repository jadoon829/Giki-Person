package com.example.demo.model;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentModel extends Person {

    private static AtomicInteger IdCounter = new AtomicInteger();

    private int rollNumber;
    private int marks;
    FacultyType faculty = FacultyType.UNKNOWN;
    StudentType studentType = StudentType.UNKNOWN;

    public StudentModel(){
        super(IdCounter.getAndIncrement(), "");
    }
    public StudentModel(int rollno, String name, int marks, FacultyType faculty, StudentType studentType)  {

        super(IdCounter.getAndIncrement(), name);
        this.rollNumber = rollno;
        this.name = name;
        this.marks = marks;
        this.faculty = faculty;
        this.studentType = studentType;
    }

    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

    public FacultyType getFaculty() {
        return faculty;
    }
    public void setFaculty(FacultyType faculty) {
        this.faculty = faculty;
    }

    public StudentType getTypeOfStudent() {
        return studentType;
    }
    public void setTypeOfStudent(StudentType studentType) {
        this.studentType = studentType;
    }


    @Override
    public String toString() {
        return "StudentModel{" + "Id= " + id + " name= " + name +
                ", rollNumber= " + rollNumber +
                ", marks= " + marks +
                ", faculty=" + faculty +
                ", studentType=" + studentType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentModel)) return false;
        if (!super.equals(o)) return false;
        StudentModel that = (StudentModel) o;
        return rollNumber == that.rollNumber &&
                marks == that.marks &&
                faculty == that.faculty &&
                studentType == that.studentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rollNumber, marks, faculty, studentType);
    }
//    public static void main(String[] args) {
//        StudentModel studentModel = new StudentModel(13,"programmer",65,FacultyType.UNKNOWN,StudentType.BACHELOR);
//        System.out.println("abc" + studentModel);
//    }

}



