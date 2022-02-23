package com.example.demo.model;

public enum FacultyType {
    UNKNOWN(""),
    CS("Computer Science"),
    ME("Mechanical Engineering"),
    MM("Metalergy"),
    ES("Engineering Sciences");

    private String fullName;

    FacultyType(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
