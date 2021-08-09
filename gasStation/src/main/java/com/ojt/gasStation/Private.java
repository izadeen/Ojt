package com.ojt.gasStation;

public class Private extends Vehicle {
    public Private(Action service, Status status) {
        super(service, status);
    }

    @Override
    public String toString() {
        return super.toString()+" with type Trailer";
    }
}
