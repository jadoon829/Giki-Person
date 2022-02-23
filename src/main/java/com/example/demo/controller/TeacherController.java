package com.example.demo.controller;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.TeacherModel;
import com.example.demo.model.TeacherType;
import com.example.demo.service.PersonService;
import com.example.demo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "teacher")
public class TeacherController extends PersonController<TeacherModel> {

   TeacherService teacherService = new TeacherService();

    @GetMapping(value = "all")
    public List<TeacherModel> getTeachers(){  //Stub
        return teacherService.getPersonList();
    }

    @GetMapping (value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherModel> getTeacher(@PathVariable int id){  //Stub
        Optional<TeacherModel> teacher = teacherService.getTeacher(id);
        if(teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "count")
    public int getTeacherCount(){
        return teacherService.getPersonList().size();
    }
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherModel addPerson(@RequestBody TeacherModel teacherModel){
        teacherService.addPerson(teacherModel);
        return teacherModel;
    }

    @GetMapping(value = "professor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getTypeProfessors(){
        List<String> professorList = new ArrayList<>();
        for( TeacherModel t: teacherService.getPersonList()){
            if(t.getTeacherType().equals(TeacherType.PF)){
                String name = t.getName();
                professorList.add(name);
            }
        }
        ResponseEntity.status(HttpStatus.ACCEPTED);
        return ResponseEntity.ok(professorList);
    }
    public boolean hasTeacher(int id){
        return teacherService.hasTeacher(id);
    }

    @DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherModel> deleteTeacher(@PathVariable int id){
        if(teacherService.getTeacher(id).isPresent()){
            return ResponseEntity.ok(teacherService.deleteTeacher(id));
        }
        else{
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }


    @DeleteMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherModel> deleteTeacher(@RequestBody TeacherModel teacherModel){
        try{
            return ResponseEntity.ok(teacherService.deletePerson(teacherModel));
        }
        catch (MyOptionalException ex){
            System.out.println(" couldn't find any teacher: " + ex.getDescription());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public PersonService<TeacherModel> getService(){
        return teacherService;
    }
}
