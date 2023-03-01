package service;

import applicances.Curtains;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuCurtains {
    private static final Scanner scanner=new Scanner(System.in);

    public Curtains draperii=new Curtains();

    public void TabCurtains() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelCurtains();
            int selectedOptionCurtains = readOptionCurtains();
            processSelectedOptionCurtains(selectedOptionCurtains);
        }
    }

    private static int readOptionCurtains() {
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

    private void processSelectedOptionCurtains(int selectedOptionCurtains) throws SQLException, ClassNotFoundException {
        switch (selectedOptionCurtains){
            case 1:
                comand();
                break;
            case 2:
                draperii.statusCurtains();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }


    private static void tabelCurtains() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Vreau sa cobori/ridici draperiile");
        System.out.println("2. Vreau sa vad cum sunt draperiile");
        System.out.println("3. Inapoi");
    }

    public void comand (){
        System.out.println("Pentru a cobora draperiile scrie 1/ pentru a le ridica scrie 0");
        int usedCurtains=scanner.nextInt();
        draperii.setUsedCurtains(usedCurtains);
        if (usedCurtains==1||usedCurtains==0) {
            draperii.setPowerCurtains(usedCurtains == 1);
        } else {
            System.out.println("Te rog sa alegi intre 0 si 1 ");
        }
    }

}
