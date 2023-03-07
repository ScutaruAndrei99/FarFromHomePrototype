package interfata;

import service.LightService;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuRoomLight {
    private static final Scanner scanner = new Scanner(System.in);
    LightService ls;

    public MeniuRoomLight() {
        ls = new LightService();
    }

    public void TabRoomLight() {
        while (true){
            tabelRoomLight();
            int selectedOptionRoom = readOptionLight();
            processSelectedOptionRoom(selectedOptionRoom);
        }
    }


    private void processSelectedOptionRoom(int selectedOptionLight) {
        switch (selectedOptionLight) {
            case 1:
                ls.setPowerLight("Bathroom");
                break;
            case 2:
                ls.setPowerLight("Bedroom");
                break;
            case 3:
                ls.setPowerLight("Kitchen");
                break;
            case 4:
                ls.setPowerLight("Hall");
                break;
            case 5:
                ls.setPowerLight("LivingRoom");
                break;
            case 6:
                ls.setPowerLight("Dressing");
                break;
            case 7:
                ls.setPowerLight("Boiler");
                break;
            case 8:
                ls.LightStatus();
                break;
            case 9:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

    private static void tabelRoomLight() {
        System.out.println("Where do you want to use the light??");
        System.out.println("----------------------");
        System.out.println("1. Bathroom");
        System.out.println("2. Bedroom");
        System.out.println("3. Kitchen");
        System.out.println("4. Hall");
        System.out.println("5. Living room");
        System.out.println("6. Dressing");
        System.out.println("7. Boiler");
        System.out.println("8. Situatia becurilor");
        System.out.println("9. Back");
    }
    public static int readOptionLight(){
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 9 || optiune < 1) {
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

