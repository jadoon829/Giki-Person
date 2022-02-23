package com.example.demo.service;


import java.util.Optional;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.FacultyType;
import com.example.demo.model.StudentModel;
import com.example.demo.model.StudentType;

public class StudentService extends PersonService<StudentModel> {


    public StudentService(){
         StudentModel student1 = new StudentModel(5, "sajjad", 49, FacultyType.CS, StudentType.BACHELOR);
         StudentModel student2 = new StudentModel(8,"qabal", 48, FacultyType.ES, StudentType.MASTER);
         StudentModel student3 = new StudentModel(6,"saeed", 43, FacultyType.MM, StudentType.PHD);
         StudentModel student4 = new StudentModel(7,"atiq", 44, FacultyType.ME, StudentType.BACHELOR);
         StudentModel student5 = new StudentModel(11,"mansoor", 43, FacultyType.CS, StudentType.PHD);

         personList.add(student1);
         personList.add(student2);
         personList.add(student3);
         personList.add(student4);
         personList.add(student5);

         personList.add(new StudentModel(12,"dsfsas", 43, FacultyType.CS, StudentType.PHD));
         personList.add(new StudentModel(13,"mansodfsor", 43, FacultyType.ES, StudentType.PHD));
         personList.add(new StudentModel(14,"manssdfsoor", 43, FacultyType.ME, StudentType.PHD));
         personList.add(new StudentModel(11,"masdfnsoor", 43, FacultyType.MM, StudentType.PHD));
         personList.add(new StudentModel(15,"mansdfsoor", 43, FacultyType.ES, StudentType.PHD));
         personList.add(new StudentModel(16,"mansghoor", 43, FacultyType.CS, StudentType.PHD));
         personList.add(new StudentModel(17,"mansjhoor", 43, FacultyType.CS, StudentType.PHD));
         personList.add(new StudentModel(18,"mansnmnoor", 43, FacultyType.MM, StudentType.PHD));
         personList.add(new StudentModel(19,"manuisoor", 43, FacultyType.ME, StudentType.PHD));
         personList.add(new StudentModel(20,"mansqwqoor", 43, FacultyType.CS, StudentType.PHD));
    }

    public Optional<StudentModel> getStudent(int rollno){                                                 //Stub

         Optional<StudentModel> studentModel = personList.stream()
                 .filter((sm -> sm.getRollNumber() == rollno))
                 .findFirst();
         return studentModel;
     }

    public boolean hasStudent(int rollno){
          return getStudent(rollno).isPresent();    }

    public StudentModel deleteStudent(int rollno) throws MyOptionalException {
         Optional<StudentModel> studentModel = getStudent(rollno);
         if(studentModel.isPresent()) {
              return deletePerson(studentModel.get());
         }
         return null;
    }

}
