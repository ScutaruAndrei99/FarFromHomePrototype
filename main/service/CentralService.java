package service;

import model.Central;
import repository.CentralRepository;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CentralService {
    CentralRepository cr;
    private static final Scanner scanner =new Scanner(System.in);
    public CentralService (CentralRepository cr) { this.cr=cr; }

    public void changeTemperature() throws SQLException {
        Central central = cr.findById(2);

        if(!central.isPower()){
            System.out.println("Te rog sa pornesti mai intai centrala");
        }else {
            System.out.println("Te rog sa alegi o temperatura");
            System.out.print("Noua temperatura este " );
            central.setTemperature(readOptionCentral());
            System.out.println("Se modifica temperatura");
            cr.updateCentral(central);
        }
    }
    public void setPowerCentral() throws SQLException {
        Central central = cr.findById(2);
        System.out.println("Pentru a porni centrala scrie 1/ pentru a o opri scrie 0");
        int switchPower=scanner.nextInt();
        if(switchPower == 0) {
            central.setPower(false);
            System.out.println("Centrala se opreste");
        } else if (switchPower == 1) {
            central.setPower(true);
            System.out.println("Centrala se porneste");
        } else{
            System.out.println("Te rog sa alegi intre 0 si 1");
        }
        cr.updateCentral(central);
    }

    public void readTemperature() throws SQLException {
        Central central = cr.findById(2);
        System.out.println("Temperatura din centrala este de " + central.getTemperature() +" grade Celsius" );
    }
    static int readOptionCentral() {
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 30 || optiune < 0) {
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

}
