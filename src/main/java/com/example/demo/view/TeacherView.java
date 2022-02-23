package com.example.demo.view;

import com.example.demo.model.MyOptional;
import com.example.demo.model.TeacherModel;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class TeacherView {

    private static final Logger log = Logger.getLogger(TeacherView.class.getName());

    public void highestId(int highestId){
        log.info("Highest Teacher Id: " + highestId);
    }

    public void showTeacherWithBiggestId(MyOptional<TeacherModel> biggestTeacherId){
        log.info("Teacher with highest Id is: " + biggestTeacherId);
    }

    public void showBiggestTeachersName(String biggestTeacherName){
        log.info("Biggest teachers name is: " + biggestTeacherName);
    }

    public void showBiggestNameLength(int BiggesatNameLength){
        log.info("Teachers Biggest name length is: " + BiggesatNameLength);
    }
    public void printTeacher(String text, Optional<TeacherModel> teacherModel){
        log.info(text + teacherModel.get());
    }

    public void addTeacher(TeacherModel teacherModel){
        log.info("New Teacher is: " + teacherModel);
    }

    public void showTypeProfessor(List<String> professorList){
        log.info("Teachers who are professors are: " +professorList);
    }

    public void ifHasTeacher(String text, boolean b){
        log.info(text + b);
    }

    public void showIfHasbeenDeleted(boolean b){
        log.info("The record of id 9 has been deleted: " + b);
    }

    public void showIfObjectHasBeenDeleted(String text, boolean b){
        log.info(text + b);
    }

}
