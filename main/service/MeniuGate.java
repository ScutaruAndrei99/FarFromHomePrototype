package service;

import applicances.Gate;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuGate {
    private static Scanner scanner=new Scanner(System.in);

    public static Gate poarta=new Gate(3);

    public void TabGate() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelGate();
            int selectedOptionGate = readOptionGate();
            processSelectedOptionGate(selectedOptionGate);
        }
    }

    private static int readOptionGate() {
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

    private void processSelectedOptionGate(int selectedOptionGate) throws SQLException, ClassNotFoundException {

        switch (selectedOptionGate){
            case 1:
                setGateOpen();
                break;
            case 2:
                poarta.setGateClose();
                break;
            case 3:
                poarta.gateSituation();
                break;
            case 4:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }


    private static void tabelGate() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Deschide poarta");
        System.out.println("2. Inchide poarta");
        System.out.println("3. Cat de mult este deschisa poarta ?");
        System.out.println("4. Inapoi");
    }

    public void setGateOpen(){
        System.out.println("Cat de mult vrei sa deschizi poarta?");
        int open=scanner.nextInt();
        if (open > 3 || open < 0){
            System.out.println("Poarta are maxim 3 metri");
        } else {
            poarta.move(open);
        }
    }

}
