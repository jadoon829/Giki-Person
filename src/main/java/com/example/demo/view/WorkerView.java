package com.example.demo.view;

import com.example.demo.model.MyOptional;
import com.example.demo.model.WorkerModel;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


public class WorkerView {
    private static final Logger log = Logger.getLogger(TeacherView.class.getName());

    public void showHighestId(int workerHighestId) {
        log.info("Worker Highest Id: " + workerHighestId);
    }

    public void showPersonTypeWithHighestId(MyOptional<WorkerModel> showWorkerTypeWithHighestId) {
        log.info("Worker with highest ID is:" + showWorkerTypeWithHighestId);
    }

    public void showBiggestName(String biggestName){
        log.info("Worker Biggeat Name is : " + biggestName);
    }

    public void showbiggstNameLength(int biggestNameLength){
        log.info("Worker biggest name length: " + biggestNameLength);
    }

    public void showWrokerTypeCOOK(List<WorkerModel> workerOfTypeCOOK){
        log.info("WorkerType Cook details are: " + workerOfTypeCOOK);
    }

    public void printWorker(String foundText, String notFoundText, Optional<WorkerModel> workerModel){
        if(workerModel.isPresent()) {
            log.info(foundText + workerModel.get());
        } else {
            log.warning(notFoundText);
        }
    }

    public void addWorker(WorkerModel workerModel){
        log.info("New worker is: " + workerModel);
    }

    public void ifHasWorker(String text, boolean b){
        log.info(text + b);
    }

    public void showIfRecordbeenDeleted(boolean b){
        log.info("The record with id 4 has been deleted: " + b);
    }

    public void showIfWorkerHasBeenDeleted(String text, boolean b){
        log.info(text + b);
    }

}
