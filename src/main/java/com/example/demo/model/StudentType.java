package com.example.demo.model;

public enum StudentType {
    UNKNOWN("Unknown",null),
    BACHELOR("Bachelors Degree", 4),
    MASTER("Masters Degree", 2),
    PHD("Doctor Of Philosophy", 5);
    String fullName;
    Integer duration;

    StudentType(String fullName, Integer duration){
        this.fullName = fullName;
        this.duration = duration;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return fullName +" ," + duration + " Years";
    }
}
