package com.ojt.gasStation;

public class MotorCycle extends Vehicle {
    @Override
    public String toString() {
        return super.toString()+" with type MotorCycle";
    }

    public MotorCycle(Action service, Status status) {
        super(service, status);
    }
}
