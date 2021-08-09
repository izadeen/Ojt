package com.ojt.gasStation;

public class Trailer extends Vehicle {
    @Override
    public String toString() {
        return super.toString()+" with type Trailer";
    }

    public Trailer( Action service, Status status) {
        super(service, status);
    }

    @Override
    public int getFuelingTime() {
        return 5;
    }

    @Override
    public int getCleaningTime() {
        return 6;
    }
}
