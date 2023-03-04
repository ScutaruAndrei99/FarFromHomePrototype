package service;

import model.Vacuum;
import repository.VacuumRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class VacuumService {
    VacuumRepository vr;
    private static Scanner scanner=new Scanner(System.in);
    public VacuumService(VacuumRepository vr) {this.vr=vr;}

    public void setPowerVacuum() throws SQLException {
        Vacuum vacuum=vr.findById();
        System.out.println("Pentru a porni aspiratorul scrie 1/ pentru al opri scrie 0");
        int switchPower=scanner.nextInt();
        if(switchPower == 1) {
            vacuum.setPowerVacuum(true);
            System.out.println("Aspiratorul a inceput procesul de curatare");
            timeVacuumWork(60);
        }
        vr.updateVacuum(vacuum);
    }

    public void vacuumWork() throws SQLException {
        Vacuum vacuum = vr.findById();
        if (vacuum.isPowerVacuum()) {
            System.out.println("Aspiratorul lucreaza");
        } else {
            System.out.println("Aspiratorul nu lucreaza");
        }
    }
    public static int readOptionVacuum() {

        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 3 || optiune < 1) {
                    System.out.println("Te rog sa alegi alt numar");
                } else {
                    scanner.nextLine();
                    return optiune;
                }
            } catch ( InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Optiune neexistenta, te rog sa scrii doar numarul");
            }
        } while (true);
    }
    public void timeVacuumWork(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000L);
    }
    class RemindTask extends TimerTask {

        VacuumRepository vr;
        public void run() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            vr = new VacuumRepository(conn);
            Vacuum vacuum = null;
            try {
                vacuum = vr.findById();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            vacuum.setPowerVacuum(false);
            try {
                vr.updateVacuum(vacuum);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Aspitatorul si-a terminat procesul de curatenie");
        }
    }
}