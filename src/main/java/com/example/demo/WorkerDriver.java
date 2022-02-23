package com.example.demo;

import com.example.demo.controller.WorkerController;
import com.example.demo.model.WorkerModel;
import com.example.demo.model.WorkerType;
import com.example.demo.view.StudentView;
import com.example.demo.view.WorkerView;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;




public class WorkerDriver extends PersonDriver<WorkerModel> {

    private static final Logger log = Logger.getLogger(StudentView.class.getName());
    WorkerView workerView = new WorkerView();
    public WorkerDriver() {
        personController = new WorkerController();
    }

    public void execute() {

        log.info("\n-------- WorkerDriver --------\n");
        super.execute();
        workerView.showHighestId(highestId);
        workerView.showPersonTypeWithHighestId(personWithHighestId);
        workerView.showBiggestName(biggestName);
        workerView.showbiggstNameLength(biggestNameLength);
        List<WorkerModel> workerOfTypeCook = null;// ((WorkerController)personController).getWorkerOfTypeCOOK();
        workerView.showWrokerTypeCOOK(workerOfTypeCook);

        Optional <WorkerModel> workerById = ((WorkerController)personController).getWorker(4);
        workerView.printWorker("Worker with id 4: ","Not Found", workerById);
        WorkerModel worker5 = new WorkerModel("Saeed" , WorkerType.COOK);
        WorkerModel newWorker = ((WorkerController)personController).addWorker(worker5);
        workerView.addWorker(newWorker);
        boolean b = ((WorkerController)personController).hasWorker(9);
        workerView.ifHasWorker("Worker with id 9 Exist: ", b);
        boolean deleteWorker = null!=((WorkerController)personController).deleteWorker(4);
        workerView.showIfRecordbeenDeleted(deleteWorker);
        boolean objectDeleted = null!=((WorkerController)personController).deleteWorker(worker5);
        workerView.showIfWorkerHasBeenDeleted("The object has been deleted: ", objectDeleted);

    }

}
