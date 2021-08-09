package com.ojt.gasStation;

public class Private extends Vehicle {
    public Private(Action service, Status status) {
        super(service, status);
    }

    @Override
    public int getFuelingTime() {
        return 4;
    }

    @Override
    public int getCleaningTime() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString()+" with type Trailer";
    }
}
