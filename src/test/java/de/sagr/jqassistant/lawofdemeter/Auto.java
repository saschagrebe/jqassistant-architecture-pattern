package de.sagr.jqassistant.lawofdemeter;

/**
 * Created by grebe on 28.11.2017.
 */
public class Auto {
    private Motor motor;

    public Auto() {
        this.motor = new Motor();
    }

    public Motor getMotor() {
        return motor;
    }

    public void start() {
        this.motor.start();
    }

    public void start2() {
        this.getMotor().start();
    }
}
