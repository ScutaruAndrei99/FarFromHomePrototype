package service;

import model.Vacuum;
import repository.VacuumRepository;

import java.util.Timer;
import java.util.TimerTask;

public class VacuumService {
    VacuumRepository vr;
    Timer timer = new Timer();
    public VacuumService() {vr=new VacuumRepository();}

    public void setPowerVacuum(int switchPower) {
        Vacuum vacuum=vr.findById();
        if(switchPower == 1) {
            vacuum.setPowerVacuum(true);
            System.out.println("Aspiratorul a inceput procesul de curatare");
            timeVacuumWork(60);
            vr.updateVacuum(vacuum);
        } else if (switchPower == 0) {
            vacuum.setPowerVacuum(false);
            vr.updateVacuum(vacuum);
            timer.cancel();
            System.out.println("Aspiratorul se opreste");
        }
    }

    public void vacuumWork() {
        Vacuum vacuum = vr.findById();
        if (vacuum.isPowerVacuum()) {
            System.out.println("Aspiratorul lucreaza");
        } else {
            System.out.println("Aspiratorul nu lucreaza");
        }
    }

    public void timeVacuumWork(int seconds) {
        timer.schedule(new RemindTask(), seconds * 1000L);
    }
    class RemindTask extends TimerTask {

        VacuumRepository vr;
        public void run() {
            vr = new VacuumRepository();
            Vacuum vacuum = null;
            vacuum = vr.findById();
            vacuum.setPowerVacuum(false);
            vr.updateVacuum(vacuum);
            System.out.println("Aspitatorul si-a terminat procesul de curatenie");
        }
    }
}