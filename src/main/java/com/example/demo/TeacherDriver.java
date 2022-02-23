package com.example.demo;

import com.example.demo.controller.TeacherController;
import com.example.demo.model.FacultyType;
import com.example.demo.model.TeacherModel;
import com.example.demo.view.StudentView;
import com.example.demo.view.TeacherView;
import static com.example.demo.model.TeacherType.PF;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class TeacherDriver extends PersonDriver<TeacherModel> {

    private static final Logger log = Logger.getLogger(StudentView.class.getName());
    public TeacherDriver() {
        personController = new TeacherController();
    }
    TeacherView teacherView = new TeacherView();

    public void execute() {

        log.info("\n .......TeacherDriver....... \n ");
        super.execute();

        teacherView.highestId(highestId);
        teacherView.showTeacherWithBiggestId(personWithHighestId);
        teacherView.showBiggestTeachersName(biggestName);
        teacherView.showBiggestNameLength(biggestNameLength);

        Optional<TeacherModel> teacherById =null; // ((TeacherController)personController).getTeacher(2);
        teacherView.printTeacher("Teacher with id 6: ", teacherById);
        TeacherModel professor5 = new TeacherModel("Sajjad" , FacultyType.ME, PF);
        TeacherModel newTeacher = ((TeacherController)personController).addPerson(professor5);
        teacherView.addTeacher(newTeacher);
        List<String> professorList = null;//((TeacherController)personController).getTypeProfessors();
        teacherView.showTypeProfessor(professorList);
        boolean b = ((TeacherController)personController).hasTeacher(12);
        teacherView.ifHasTeacher("Teacher with this 12 Exist: ", b);
        boolean deleteTeacher = null!= ((TeacherController)personController).deleteTeacher(9);
        teacherView.showIfHasbeenDeleted(deleteTeacher);
        boolean objectDeleted = null!= ((TeacherController)personController).deleteTeacher(professor5);
        teacherView.showIfObjectHasBeenDeleted("The object has been deleted: ", objectDeleted);

        }
}
