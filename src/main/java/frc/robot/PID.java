package frc.robot;

public class PID {
    double kP;
    double kI;
    double kD;
    double lastError;
    double integral;
    double minimumOutputValue;
    double maximumOutputValue;
    double pidOutput;
    double error;
     
    PID (double P, double I, double D) {
        kP = P;
        kI = I;
        kD = D;
        lastError = 0;
        integral = 0;
        minimumOutputValue = -1;
        maximumOutputValue = 1;
        pidOutput = 0;
    }

    void setOutputRange(double minimum, double maximum) {
        minimumOutputValue = minimum;
        maximumOutputValue = maximum;
    }

    void setKP (double P) {
        kP = P;
    }

    void setKI (double I) {
        kI = I;
    }
    void setKD (double D) {
        kD = D;
    }

    void setError(double newError) {
        error = newError;
    }

    void reset() {
        pidOutput = 0;
        integral = 0;
        lastError = 0;
    }

    void update() {
        integral += (error);
        pidOutput = (error * kP) + (integral * kI) + ((error - lastError) * kD);
        lastError = error;
    }

    double getOutput() {
        if (pidOutput < minimumOutputValue) {
            return minimumOutputValue;
        } else if (pidOutput > maximumOutputValue) {
            return maximumOutputValue;
        } else {
            return pidOutput;
        }
    }
}