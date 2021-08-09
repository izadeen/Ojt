package com.ojt.gasStation;

public  abstract class Vehicle  {
    private static int counter=0;
    private int id;
    private Action service;
    private Status status;

    @Override
    public String toString() {
        return "Vehicle "+id;
    }

    public Vehicle(Action service, Status status) {
        this.id =counter++;
        this.service = service;
        this.status = status;
    }


    public abstract int getFuelingTime();
    public abstract int getCleaningTime();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public synchronized Action getService() {
        return service;
    }

    public synchronized void setService(Action service) {
        this.service = service;
    }

    public synchronized Status getStatus() {
        return status;
    }

    public synchronized void setStatus(Status status) {
        this.status = status;
    }
}
