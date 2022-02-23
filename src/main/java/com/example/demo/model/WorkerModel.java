package com.example.demo.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerModel extends Person{
    private static AtomicInteger IdCounter = new AtomicInteger();
    WorkerType workerType = WorkerType.UNKOWN;

    public WorkerModel(String name, WorkerType workerType) {
        super(IdCounter.getAndIncrement(), name);
        this.workerType = workerType;
    }

    public WorkerType getWorkerType() {
        return workerType;
    }

    public void setWorkerType(WorkerType workerType) {
        this.workerType = workerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkerModel)) return false;
        if (!super.equals(o)) return false;
        WorkerModel that = (WorkerModel) o;
        return workerType == that.workerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerType);
    }

    @Override
    public String toString() {
        return "WorkerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workerType=" + workerType +
                '}';
    }
}
