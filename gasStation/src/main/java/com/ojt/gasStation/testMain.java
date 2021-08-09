package com.ojt.gasStation;

public class testMain {
    public static void main(String[] args){
        GasStation gasStation=GasStation.getInstance();
        MotorCycle vehicle0=new MotorCycle(Action.RC,Status.WAITING);
        gasStation.addVehicl(vehicle0);

        Trailer vehicle1=new Trailer(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle1);

        MotorCycle vehicle2=new MotorCycle(Action.RC,Status.WAITING);
        gasStation.addVehicl(vehicle2);

        Private vehicle3=new Private(Action.C,Status.WAITING);
        gasStation.addVehicl(vehicle3);

        Private vehicle4=new Private(Action.C,Status.WAITING);
        gasStation.addVehicl(vehicle4);

        Private vehicle5=new Private(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle5);

        Private vehicle6=new Private(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle6);

        MotorCycle vehicle7=new MotorCycle(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle7);

        MotorCycle vehicle8=new MotorCycle(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle8);

        Private vehicle9=new Private(Action.RC,Status.WAITING);
        gasStation.addVehicl(vehicle9);

        Private vehicle10=new Private(Action.C,Status.WAITING);
        gasStation.addVehicl(vehicle10);

        MotorCycle vehicle11=new MotorCycle(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle11);

        Private vehicle12=new Private(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle12);

        Trailer vehicle13=new Trailer(Action.RC,Status.WAITING);
        gasStation.addVehicl(vehicle13);

        Private vehicle14=new Private(Action.R,Status.WAITING);
        gasStation.addVehicl(vehicle14);

        Thread thread=new Thread(gasStation);
        thread.start();
    }
}
