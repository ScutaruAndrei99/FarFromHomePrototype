package applicances;

import java.util.Timer;
import java.util.TimerTask;

public class Vacuum {
    private static boolean powerVacuum;

    public void setpowerOnVacuum() {
        Vacuum.powerVacuum = true;
        System.out.println("Aspiratorul a inceput procesul de curatare");
        timeVacuumWork(60);
    }

    public void setPowerOffVacuum() {
        Vacuum.powerVacuum = false;
        System.out.println("Aspiratorul se v-a opri");
        Timer timer=new Timer();
        timer.cancel();
    }

    public void timeVacuumWork(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000L);
    }
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Aspitatorul si-a terminat procesul de curatenie");
        }
    }


    public void vacuumWork(){
        if(Vacuum.powerVacuum==true){
            System.out.println("Aspiratorul lucreaza");
        } else {
            System.out.println("Aspiratorul nu lucreaza");
        }
    }
}
