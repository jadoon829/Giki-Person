package com.example.demo.model;

import java.util.Objects;

public class TeacherModel extends Person{

    private static int idCounter = 0;
    FacultyType faculty;
    TeacherType teacherType = TeacherType.UNKNOWN;
    public TeacherModel(String name, FacultyType faculty, TeacherType teacherType) {
        super(idCounter++, name);
        this.faculty = faculty;
        this.teacherType = teacherType;
    }

    public FacultyType getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyType faculty) {
        this.faculty = faculty;
    }

    public TeacherType getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(TeacherType teacherType) {
        this.teacherType = teacherType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherModel)) return false;
        if (!super.equals(o)) return false;
        TeacherModel that = (TeacherModel) o;
        return faculty == that.faculty && teacherType == that.teacherType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, teacherType);
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherType=" + teacherType + "faculty= " + faculty +
                '}';
    }
}
