package applicances;

public class Curtains {

    public boolean powerCurtains;

    protected int usedCurtains;

    public void setUsedCurtains(int usedCurtains) {
        this.usedCurtains = usedCurtains;
    }

    public boolean isPowerCurtains() {
        return powerCurtains;
    }

    public void setPowerCurtains(boolean powerCurtains) {
        this.powerCurtains = powerCurtains;
    }

    public void statusCurtains(){
        if (!isPowerCurtains()){
            System.out.println("Draperiile sunt coborate in casa");
        } else {
            System.out.println("Draperiile sunt ridicate in casa");
        }
    }
}
