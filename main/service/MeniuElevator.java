package service;

import applicances.Elevator;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuElevator {
    private static final Scanner scanner = new Scanner(System.in);

    protected static Elevator lift=new Elevator(2);

    public static void TabElevator() throws SQLException, ClassNotFoundException {
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
        System.out.println("1. Trimite liftul la parter");
        System.out.println("2. Trimite liftul la etajul 1");
        System.out.println("3. Trimite liftul la etajul 2");
        System.out.println("4. La ce etaj se afla liftul?");
        System.out.println("5. Inapoi");
    }

    private static void processSelectedOptionElevator(int selectedOptionElevator) throws SQLException, ClassNotFoundException {
        switch (selectedOptionElevator) {
            case 1:
                lift.call(0);
                TabElevator();
                break;
            case 2:
                lift.call(1);
                TabElevator();
                break;
            case 3:
                lift.call(2);
                TabElevator();
                break;
            case 4:
                lift.statusElevator();
                TabElevator();
                break;
            case 5:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

    private static int readOptionElevator() {
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 5 || optiune < 1) {
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
