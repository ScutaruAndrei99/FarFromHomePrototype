package service;

import interfata.*;

import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        tabStart();

    }
    public static void tabStart ()  {
        Scanner scanner = new Scanner(System.in);
            int selectedOption;
            do {
                System.out.println("Ce vrei sa folosesti?");
                System.out.println("----------------------");
                System.out.println("1. Espressor");
                System.out.println("2. Elevator");
                System.out.println("3. Vacuum");
                System.out.println("4. Gate");
                System.out.println("5. Central");
                System.out.println("6. Light");
                System.out.println("7. Curtains");
                System.out.println("8. TV");
                selectedOption = scanner.nextInt();
                scanner.nextLine();
                switch (selectedOption) {
                    case 1:
                        MeniuEspressor espres = new MeniuEspressor();
                        espres.TabEspressor();
                        break;
                    case 2:
                        MeniuElevator elevat = new MeniuElevator();
                        elevat.TabElevator();
                        break;
                    case 3:
                        MeniuVacuum vac= new MeniuVacuum();
                        vac.TabVacuum();
                        break;
                    case 4:
                        MeniuGate gat=new MeniuGate();
                        gat.TabGate();
                        break;
                    case 5:
                        MeniuCentral centr= new MeniuCentral();
                        centr.TabCentral();
                        break;
                    case 6:
                        MeniuRoomLight lumina= new MeniuRoomLight();
                        lumina.TabRoomLight();
                        break;
                    case 7:
                        MeniuCurtains draperii=new MeniuCurtains();
                        draperii.TabCurtains();
                        break;
                    case 8:
                        MeniuTV tv=new MeniuTV();
                        tv.TabTV();
                        break;

                }
            } while (selectedOption != 5);
        }

}
