package com.example.demo;

import com.example.demo.controller.PersonController;
import com.example.demo.model.MyOptional;
import com.example.demo.model.Person;

import java.util.Optional;

public abstract class PersonDriver <T extends Person> {

    PersonController<T> personController;
    int highestId;
    MyOptional<T> personWithHighestId;
    String biggestName;
    int biggestNameLength;

    public void execute() {
        highestId = personController.getHighestId();
        personWithHighestId = personController.getPersonWithHighestId();
        biggestName = personController.getBiggestName();
        biggestNameLength = personController.getBiggestNameLength();
    }
    //
    //
    //
}
