package interfata;

import service.ElevatorService;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuElevator {
    private static final Scanner scanner = new Scanner(System.in);
    ElevatorService els;
    public MeniuElevator() {
        els = new ElevatorService();
    }

    public void TabElevator() {
        while (true) {
            tabelElevator();
            int selectedOptionElevator = readOptionElevator();
            processSelectedOptionElevator(selectedOptionElevator);
            break;
        }
    }

    public static void tabelElevator() {

        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Vreau sa chem liftul");
        System.out.println("2. La ce etaj se afla liftul?");
        System.out.println("3. Inapoi");
    }

    private void processSelectedOptionElevator(int selectedOptionElevator) {
        switch (selectedOptionElevator) {
            case 1:
                els.call();
                TabElevator();
                break;
            case 2:
                els.statusElevator();
                TabElevator();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }
    public static int readOptionElevator() {
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 3 || optiune < 1) {
                    System.out.println("Te rog sa alegi alt numar");
                } else {
                    scanner.nextLine();
                    return optiune;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Optiune neexistenta, te rog sa scrii doar numarul");
            }
        } while (true);
    }
}
