package com.ojt.gasStation;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReFueler  implements Runnable{
    private ArrayList<Vehicle> queue,priorityQueue;
    private Vehicle CurrentVehcle;
    private int reFuelingTime=1;
    private GasStation gasStation;

    public ReFueler(GasStation gasStation){
        queue=new ArrayList<>();
        priorityQueue=new ArrayList<>();
        this.gasStation=gasStation;
    }
    public void addVehicle(Vehicle vehicle){
        switch (vehicle.getService()) {
            case R:
                queue.add(vehicle);
                break;
            case RC:
                queue.add(vehicle);
                priorityQueue.add(vehicle);
                break;
        }

    }
    private void reFuel(){
        if(CurrentVehcle!=null){
            if(CurrentVehcle.getStatus()==Status.RCREFUELING)
                CurrentVehcle.setStatus(Status.WAITINGFORCLEANING);
            else
                CurrentVehcle.setStatus(Status.DONE);
        }
        if(!priorityQueue.isEmpty() && priorityQueue.get(0).getStatus()==Status.WAITINGFORFUELING){
            CurrentVehcle=priorityQueue.remove(0);
            queue.remove(CurrentVehcle);

            System.out.println(CurrentVehcle.toString()+" start reFueling in time "+gasStation.getTime());

        }
        else if(!queue.isEmpty()){

            CurrentVehcle=queue.get(0);
            synchronized (CurrentVehcle) {
                if (CurrentVehcle.getStatus() != Status.RCCLEANING) {
                    CurrentVehcle=queue.remove(0);
                    if (CurrentVehcle.getService() == Action.RC && CurrentVehcle.getStatus() == Status.WAITING) {
                        CurrentVehcle.setStatus(Status.RCREFUELING);
                        priorityQueue.remove(CurrentVehcle);
                    } else
                        CurrentVehcle.setStatus(Status.REFUELING);
                    System.out.println(CurrentVehcle.toString() + " start reFueling in time " + gasStation.getTime());
                    reFuelingTime=CurrentVehcle.getFuelingTime();
                }

            }

        }



    }


    @Override
    public void run() {
        while (!queue.isEmpty()||!priorityQueue.isEmpty()){
            if(CurrentVehcle==null || gasStation.getTime() % reFuelingTime==0){
                reFuel();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
