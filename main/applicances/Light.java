package applicances;

public class Light {

    private static boolean powerLight;

    public void setpowerLight(boolean powerLight) {

        this.powerLight = powerLight;
        viewPowerLight();
    }

    public boolean getpowerLight() {
        return powerLight;
    }

    public void viewPowerLight() {
        if (getpowerLight()==true) {
            System.out.println("Lumina se porneste in casa");
        } else {
            System.out.println("Lumina se opreste in casa");
        }
    }

    public void accesLight() {
        getpowerLight();
        if (getpowerLight() == true) {
            System.out.println("Lumina este deschisa in casa");
        } else {
            System.out.println("Lumina este oprita in casa");
        }
    }

}
