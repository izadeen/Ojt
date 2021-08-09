package com.ojt.gasStation;

import java.util.ArrayList;

public class Cleaner implements Runnable{
    private ArrayList<Vehicle> queue,priorityQueue;
    private Vehicle CurrentVehcle;
    private int cleaningTime=1;
    private GasStation gasStation;

    public Cleaner(GasStation gasStation){
        queue=new ArrayList<>();
        priorityQueue=new ArrayList<>();
        this.gasStation=gasStation;
    }
    public void addVehicle(Vehicle vehicle){
        switch (vehicle.getService()) {
            case C:
                queue.add(vehicle);
                break;
            case RC:
                queue.add(vehicle);
                priorityQueue.add(vehicle);
                break;
        }
    }
    private void clean(){
        if(CurrentVehcle!=null){
            if(CurrentVehcle.getStatus()==Status.RCCLEANING)
                CurrentVehcle.setStatus(Status.WAITINGFORFUELING);
            else
                CurrentVehcle.setStatus(Status.DONE);
        }
        if(!priorityQueue.isEmpty() && priorityQueue.get(0).getStatus()==Status.WAITINGFORCLEANING){
            CurrentVehcle=priorityQueue.remove(0);
            queue.remove(CurrentVehcle);
            System.out.println(CurrentVehcle.toString()+" start cleaning in time "+gasStation.getTime());

        }
        else if(!queue.isEmpty()){
            CurrentVehcle=queue.get(0);

            synchronized (CurrentVehcle) {
                if (CurrentVehcle.getStatus() != Status.RCREFUELING) {
                    CurrentVehcle=queue.remove(0);
                    if (CurrentVehcle.getService() == Action.RC && CurrentVehcle.getStatus() == Status.WAITING) {
                        CurrentVehcle.setStatus(Status.RCCLEANING);
                        priorityQueue.remove(CurrentVehcle);
                    } else
                        CurrentVehcle.setStatus(Status.CLEANING);
                    cleaningTime=CurrentVehcle.getCleaningTime();
                    System.out.println(CurrentVehcle.toString() + " start cleaning in time " + gasStation.getTime());

                }

            }
        }

    }


    @Override
    public void run() {
        while (!queue.isEmpty()||!priorityQueue.isEmpty()){
            if(CurrentVehcle==null || gasStation.getTime() % cleaningTime==0){
                clean();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
