package com.example.demo.controller;



import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.MyOptional;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

public abstract class PersonController<T extends Person> {

    public abstract PersonService<T> getService();

    public int getHighestId() {

        Optional<T> highestId = getService().getPersonList().
                stream().max(Comparator.comparingInt(Person::getId));

        return highestId.get().getId();

    }

    public MyOptional<T> getPersonWithHighestId() {

        List<T> personArrayList = getService().getPersonList();
        Optional<T> studentWithHighestId = personArrayList.stream().
                max(Comparator.comparingInt(Person::getId));

        return MyOptional.toMyOptional(studentWithHighestId);
    }

    public String getBiggestName() {

        Optional<T> biggestStudentName = getService().getPersonList()
                .stream().max (Comparator.comparingInt(aName -> aName.getName().length()));

        return biggestStudentName.get().getName();
    }

    public int getBiggestNameLength() {

        Optional<T> biggestNameLength = getService().getPersonList()
                .stream().max (Comparator.comparingInt(aName -> aName.getName().length()));

        return biggestNameLength.get().getName().length();
    }
}
