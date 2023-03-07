package interfata;

import service.Service;
import service.TVService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuTV {
    private static final Scanner scanner=new Scanner(System.in);
    TVService tvs;

    public MeniuTV() {tvs = new TVService();}

    public void TabTV() {
        while (true) {
            tabelTV();
            int selectedOptionTV = readOptionTV();
            processSelectedOptionTV(selectedOptionTV);
        }
    }


    private void processSelectedOptionTV(int selectedOptionTV) {
        switch (selectedOptionTV){
            case 1:
                int switchPower=scanner.nextInt();
                tvs.setPowerTV(switchPower);
                break;
            case 2:
                tvs.whatIsPower();
                break;
            case 3:
                int changeChannel= scanner.nextInt();
                tvs.changeChannel(changeChannel);
                break;
            case 4:
                tvs.whatChannelIs();
                break;
            case 5:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }


    private static void tabelTV() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Vreau sa pornesc/opresc televizorul");
        System.out.println("2. Vreau sa vad cum e televizorul");
        System.out.println("3. Vreau sa mut pe alt canal");
        System.out.println("4. Pe ce Canal este deschis televizorul?");
        System.out.println("5. Inapoi");
    }
    public static int readOptionTV() {
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 5 || optiune < 1) {
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
