package com.example.demo.model;

public enum TeacherType {
    UNKNOWN("Unknown"),
    TA("Teacher Assistant"),
    PF("Professor"),
    APF("Associate Professor"),
    DTR("Doctor");


    private String fullname;
    int duration;

    TeacherType(String fullname) {
        this.fullname = fullname;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return fullname;
    }
}
