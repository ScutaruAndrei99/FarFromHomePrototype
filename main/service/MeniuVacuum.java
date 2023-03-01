package service;

import applicances.Vacuum;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MeniuVacuum {
    private static Scanner scanner=new Scanner(System.in);

    public void TabVacuum() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelVacuum();
            int selectedOptionVacuum = readOptionVacuum();
            processSelectedOptionVacuum(selectedOptionVacuum);
            return;
        }
    }

    private static int readOptionVacuum() {

        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 4 || optiune < 1) {
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

    private void processSelectedOptionVacuum(int selectedOptionVacuum) throws SQLException, ClassNotFoundException {
        Vacuum vac=new Vacuum();
        switch (selectedOptionVacuum){
            case 1:
                vac.setpowerOnVacuum();
                TabVacuum();
                break;
            case 2:
                vac.setPowerOffVacuum();
                TabVacuum();
                break;
            case 3:
                vac.vacuumWork();
                TabVacuum();
                break;
            case 4:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

    private static void tabelVacuum() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Porneste aspiratorul");
        System.out.println("2. Opreste aspiratorul");
        System.out.println("3. Aspiratorul este pornit?");
        System.out.println("4. Inapoi");
    }
}
