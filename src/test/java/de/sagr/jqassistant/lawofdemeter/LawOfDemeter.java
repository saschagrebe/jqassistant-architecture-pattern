package de.sagr.jqassistant.lawofdemeter;

/**
 * Created by grebe on 28.11.2017.
 */
public class LawOfDemeter {

    public void fahrenConstructsViolation() {
        Auto auto = new Auto();
        auto.getMotor().start();
    }

    public void fahrenDeclaresViolation(Auto auto) {
        auto.getMotor().start();
    }

    public void fahrenConstructs() {
        Auto auto = new Auto();
        auto.start();
    }

    public void fahrenDeclares(Auto auto) {
        auto.start();
    }

    public void fahrenConstructs2() {
        Auto auto = new Auto();
        auto.start2();
    }

    public void fahrenDeclares2(Auto auto) {
        auto.start2();
    }
}
