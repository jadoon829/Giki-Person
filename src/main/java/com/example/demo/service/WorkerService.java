package com.example.demo.service;

import java.util.Optional;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.WorkerModel;
import com.example.demo.model.WorkerType;

public class WorkerService extends PersonService<WorkerModel> {

    public WorkerService(){

        WorkerModel worker1 = new WorkerModel("wahid", WorkerType.ADMIN);
        WorkerModel worker2 = new WorkerModel("Maria", WorkerType.ASSISTANT);
        WorkerModel worker3 = new WorkerModel( "Saeed", WorkerType.COOK);
        WorkerModel worker4 = new WorkerModel("Altaf", WorkerType.WAITER);
        WorkerModel worker5 = new WorkerModel("Shah g", WorkerType.LIBRARIAN);
        personList.add(worker1);
        personList.add(worker2);
        personList.add(worker3);
        personList.add(worker4);
        personList.add(worker5);
    }

    public Optional<WorkerModel> getWorker(int id) {  //Stub

        Optional<WorkerModel> workerModel = personList.stream()
                .filter(wm -> wm.getId() == id )
                .findFirst();
        return workerModel;
        // not found

    }

    public boolean hasWorker(int id){
        return getWorker(id).isPresent();
    }

    public WorkerModel deleteWorker(int id) throws MyOptionalException {
        Optional <WorkerModel> workerModel = getWorker(id);

        if(workerModel.isPresent()) {
            return deletePerson(workerModel.get());
        }
        return null;
    }



}
