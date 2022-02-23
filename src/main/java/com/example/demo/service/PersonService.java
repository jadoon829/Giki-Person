package com.example.demo.service;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.Person;
import com.example.demo.model.StudentModel;


import java.util.ArrayList;
import java.util.List;

public abstract class PersonService <T extends Person> {

    List<T> personList = new ArrayList<T>();

    public List<T> getPersonList() {
        return personList;
    }

    public void addPerson(T person) {
        personList.add(person);

    }

    public T deletePerson(T person) throws MyOptionalException{
//        boolean success = false;
        if(person == null) {
            throw new MyOptionalException("tried to get null values");
           // System.out.println("provided object is null");
           // return false;
        }
        if(personList.contains(person)) {
            personList.remove(person);
            return person;
        }
        return null;
    }


}
