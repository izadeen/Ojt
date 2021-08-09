package com.ojt.gasStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class GasStation implements Runnable {
    private Integer time;
    private List<Vehicle> serviceQueue;
    private static GasStation object;

    public static GasStation getInstance(){
        if(object==null){
            object=new GasStation();
        }
        return object;
    }
    private GasStation(){
        this.time=0;
        this.serviceQueue=new ArrayList<>();
    }


    @Override
    public void run() {
        while (true){
            time++;
        }
    }
}
