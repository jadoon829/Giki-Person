package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

//    public static void main(String[] args){
//
//        StudentDriver studentDriver = new StudentDriver();
//        studentDriver.execute();
//
//        TeacherDriver teacherDriver = new TeacherDriver();
//        teacherDriver.execute();
//
//        WorkerDriver workerDriver = new WorkerDriver();
//        workerDriver.execute();
//    }
}
