package interfata;

import service.CentralService;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuCentral {
    private static final Scanner scanner =new Scanner(System.in);
    CentralService cs;

    public MeniuCentral() {
        cs = new CentralService();
    }

    public void TabCentral() {
        while (true) {
            tabelCentral();
            int selectedOptionCentral = readOptionCentral();
            processSelectedOptionCentral(selectedOptionCentral);
            break;
        }
    }

    protected static void tabelCentral() {

        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Porneste/opreste centrala");
        System.out.println("2. Seteaza temperatura din centrala");
        System.out.println("3. Ce temperatura este setata?");
        System.out.println("4. Inapoi");
    }

    private void processSelectedOptionCentral(int selectedOptionCentral) {

        switch (selectedOptionCentral) {
            case 1:
                cs.setPowerCentral();
                TabCentral();
                break;
            case 2:
                cs.changeTemperature();
                TabCentral();
                break;
            case 3:
              cs.readTemperature();
                TabCentral();
                break;
            case 4:
                Service menu=new Service();
                menu.tabStart();
                break;

        }
    }
    public static int readOptionCentral() {
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

}
