package model;

public class Vacuum {
    private int idVacuum;
    private boolean powerVacuum;
    public Vacuum(int idLight, boolean powerVacuum){
        this.idVacuum=idLight;
        this.powerVacuum=powerVacuum;
    }
    public boolean isPowerVacuum() {
        return powerVacuum;
    }
    public void setPowerVacuum(boolean powerVacuum) {
        this.powerVacuum = powerVacuum;
    }
}
