package com.example.demo.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.exceptions.MyOptionalException;
import com.example.demo.model.WorkerModel;
import com.example.demo.model.WorkerType;
import com.example.demo.service.PersonService;
import com.example.demo.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "worker")
public class WorkerController extends PersonController <WorkerModel>{

    WorkerService workerService = new WorkerService();

    @GetMapping(value = "cookworker", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkerModel>> getWorkerOfTypeCOOK() {
        List<WorkerModel> workerModelType = workerService.getPersonList().stream().
                filter(s -> s.getWorkerType().equals(WorkerType.COOK)).collect(Collectors.toList());

        return ResponseEntity.ok(workerModelType);
    }

    @GetMapping(value = "all")
    public List<WorkerModel> getWorkers(){  //Stub
        return workerService.getPersonList();
    }

    @GetMapping(value = "count")
    public int getWorkerCount(){  //Stub
        return workerService.getPersonList().size();
    }

    public Optional<WorkerModel> getWorker(int id){  //Stub
        return workerService.getWorker(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public WorkerModel addWorker(@RequestBody WorkerModel workerModel){
        workerService.addPerson(workerModel);
        return workerModel;
    }

    public boolean hasWorker(int id){
        return workerService.hasWorker(id);
    }

    @DeleteMapping(value = "{id}")
    public WorkerModel deleteWorker(@PathVariable int id) {
        try {
            return workerService.deleteWorker(id);
        }catch (MyOptionalException e){
            System.out.println("no worker was found: " +e.getDescription());
        }
        return null;
    }

    @DeleteMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteWorker(@RequestBody WorkerModel workerModel1){
        try {
            return ResponseEntity.ok(workerService.deletePerson(workerModel1));
        } catch (MyOptionalException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    public PersonService<WorkerModel> getService(){
        return workerService;
    }

}
