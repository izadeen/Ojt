package com.ojt.gasStation;

public class Trailer extends Vehicle {
    @Override
    public String toString() {
        return super.toString()+" with type Trailer";
    }

    public Trailer( Action service, Status status) {
        super(service, status);
    }
}
