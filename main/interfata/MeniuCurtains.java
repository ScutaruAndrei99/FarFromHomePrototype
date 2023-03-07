package interfata;

import service.CurtainsService;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MeniuCurtains {
    private static final Scanner scanner = new Scanner(System.in);
    CurtainsService crts;
    public MeniuCurtains() {
        crts = new CurtainsService();
    }

    public void TabCurtains() {
        while (true) {
            tabelCurtains();
            int selectedOptionCurtains = readOptionCurtains();
            processSelectedOptionCurtains(selectedOptionCurtains);
        }
    }


    private void processSelectedOptionCurtains(int selectedOptionCurtains) {
            switch (selectedOptionCurtains) {
                case 1:
                    crts.setOpenCurtain("Bathroom");
                    break;
                case 2:
                    crts.setOpenCurtain("Bedroom");
                    break;
                case 3:
                    crts.setOpenCurtain("Kitchen");
                    break;
                case 4:
                    crts.setOpenCurtain("Hall");
                    break;
                case 5:
                    crts.setOpenCurtain("LivingRoom");
                    break;
                case 6:
                    crts.setOpenCurtain("Dressing");
                    break;
                case 7:
                    crts.LightStatus();
                    break;
                case 8:
                    Service menu=new Service();
                    menu.tabStart();
                    break;
            }
        }

    private static void tabelCurtains() {
        System.out.println("In which room do you want to change the status of the curtains?");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. Bathroom");
        System.out.println("2. Bedroom");
        System.out.println("3. Kitchen");
        System.out.println("4. Hall");
        System.out.println("5. Living room");
        System.out.println("6. Dressing");
        System.out.println("7. What is the curtains status");
        System.out.println("8. Exit");
    }
    public static int readOptionCurtains(){
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 8 || optiune < 1) {
                    System.out.println("Te rog sa alegi un numar din meniu");
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
