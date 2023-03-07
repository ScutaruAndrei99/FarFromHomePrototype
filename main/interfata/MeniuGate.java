package interfata;

import service.GateService;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuGate {
    private static Scanner scanner=new Scanner(System.in);
    GateService gs;

    public MeniuGate(){gs= new GateService();}
    public void TabGate() {
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

    private void processSelectedOptionGate(int selectedOptionGate) {

        switch (selectedOptionGate){
            case 1:
                System.out.println("Scrie 1 pentru a deschide poarta/0 pentru a o inchide");
                int switchOpen =scanner.nextInt();
                gs.setGate(switchOpen);
                break;
            case 2:
                gs.gateWork();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }
    private static void tabelGate() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Interactioneaza poarta");
        System.out.println("2. Status poarta");
        System.out.println("3. Inapoi");
    }
}
