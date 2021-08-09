package com.ojt.gasStation;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class GasStation implements Runnable {
    private Integer time;
    private List<Vehicle> serviceList;
    private static GasStation object;
    private Cleaner cleaner;
    private ReFueler reFueler;

    public Integer getTime() {
        return time;
    }

    public List<Vehicle> getServiceList() {
        return serviceList;
    }

    public static GasStation getInstance(){
        if(object==null){
            object=new GasStation();
        }
        return object;
    }
    private GasStation(){
        this.time=0;
        this.serviceList=new ArrayList<>();
        cleaner=new Cleaner(this);
        reFueler=new ReFueler(this);
    }

    public void addVehicl(Vehicle vehicle){
        serviceList.add(vehicle);
        switch (vehicle.getService()){
            case C:
                cleaner.addVehicle(vehicle);
                break;
            case R:
                reFueler.addVehicle(vehicle);
                break;
            case RC:
                cleaner.addVehicle(vehicle);
                reFueler.addVehicle(vehicle);
                break;
        }
    }


    @Override
    public void run() {

        Thread reFuelThread=new Thread(reFueler);
        reFuelThread.start();
        Thread cleaningThread=new Thread(cleaner);
        cleaningThread.start();
        while (cleaningThread.isAlive() || reFuelThread.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;

        }
    }

    public Status getStatus(Integer id) {
        for (Vehicle i:serviceList){
            if(i.getId()==id)
                return i.getStatus();
        }
        return null;
    }
}
