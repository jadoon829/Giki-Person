package com.example.demo.service;

import java.util.Optional;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.FacultyType;
import com.example.demo.model.TeacherModel;
import com.example.demo.model.TeacherType;

public class TeacherService extends PersonService<TeacherModel>{

    public TeacherService() {

        TeacherModel professor1 = new TeacherModel("Liaqat Shah",  FacultyType.CS, TeacherType.DTR);
        TeacherModel professor2 = new TeacherModel("Sajjad" , FacultyType.ME, TeacherType.PF);
        TeacherModel professor3 = new TeacherModel("Amjad", FacultyType.MM, TeacherType.APF);
        TeacherModel professor4 = new TeacherModel("Jamil",  FacultyType.ES, TeacherType.TA);
        TeacherModel professor5 = new TeacherModel("Chusmani",  FacultyType.ES, TeacherType.PF);
        personList.add(professor1);
        personList.add(professor2);
        personList.add(professor3);
        personList.add(professor4);
        personList.add(professor5);

    }


    public Optional<TeacherModel> getTeacher(int id) {  //Stub

        Optional<TeacherModel> teacherModel = personList.stream()
                .filter(tm -> tm.getId() == id )
                .findFirst();
                return teacherModel;

                }

    public boolean hasTeacher(int id){
        return getTeacher(id).isPresent();
    }

    public TeacherModel deleteTeacher(int id){
        Optional<TeacherModel> teacherModel = getTeacher(id);
        if(teacherModel.isPresent()) {
            try {
                return deletePerson(teacherModel.get());
            }
            catch (MyOptionalException ex){
                System.out.println("no teacher been found, details: " +ex.getDescription());
            }
        }
        return null;
    }

}
