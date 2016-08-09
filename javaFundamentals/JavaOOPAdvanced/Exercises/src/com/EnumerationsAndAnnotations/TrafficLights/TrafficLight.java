package com.EnumerationsAndAnnotations.TrafficLights;

public class TrafficLight {
    private Signals signal;

    public TrafficLight(Signals signal) {
        this.signal = signal;
    }

    public Signals getSignals() {
        return signal;
    }

    public void update() {
        switch (this.signal) {
            case GREEN:
                this.signal = Signals.YELLOW;
                break;
            case YELLOW:
                this.signal = Signals.RED;
                break;
            case RED:
                this.signal = Signals.GREEN;
                break;
        }
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}
