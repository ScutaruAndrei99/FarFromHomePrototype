package interfata;

import service.Service;
import service.VacuumService;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MeniuVacuum {
    private static final Scanner scanner= new Scanner(System.in);
    VacuumService vs;
    public MeniuVacuum() {vs = new VacuumService();}

    public void TabVacuum()  {
        while (true) {
            tabelVacuum();
            int selectedOptionVacuum = readOptionVacuum();
            processSelectedOptionVacuum(selectedOptionVacuum);
            return;
        }
    }

    private void processSelectedOptionVacuum(int selectedOptionVacuum) {
        switch (selectedOptionVacuum){
            case 1:
                System.out.println("Pentru a porni aspiratorul scrie 1/ pentru al opri scrie 0");
                int switchPower=scanner.nextInt();
                vs.setPowerVacuum(switchPower);
                TabVacuum();
                break;
            case 2:
                vs.vacuumWork();
                TabVacuum();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

    private static void tabelVacuum() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. On/Off aspiratorul");
        System.out.println("2. Aspiratorul este pornit?");
        System.out.println("3. Inapoi");
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
}
