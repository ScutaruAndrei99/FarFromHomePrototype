package model;

public class Central {

    private int idCentral;
    private int temperature;
    private boolean power;

    public Central(int idCentral, int maxTemperature, boolean isPower){
        this.idCentral=2;
        this.temperature=maxTemperature;
        this.power=isPower;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
}
