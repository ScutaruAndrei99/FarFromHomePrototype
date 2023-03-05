package service;

import model.Elevator;
import repository.ElevatorRepository;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ElevatorService {
    private static final Scanner scanner=new Scanner(System.in);
    private ElevatorRepository elr;

    public ElevatorService(ElevatorRepository elr)  { this.elr=elr;}
    public void call() throws SQLException {
        Elevator elevator = elr.findById();
        System.out.println("La ce etaj vrei sa vina liptul?");
        int switchetaj = scanner.nextInt();
        System.out.println("Vreau sa chem liftul la "+ switchetaj);
        if (elevator.getFloor() == switchetaj){
            System.out.println("Liftul este deja la etajul " + switchetaj);
        } else if(elevator.isUsed()){
            System.out.println("Liftul este deja folosit de o alta persoana");
        } else
        {
            closeDoors();
            elevator.setFloor(switchetaj);
            openDoors();
            elr.update(elevator);
        }
    }
    public void statusElevator() throws SQLException {
        Elevator elevator = elr.findById();
        System.out.println("Liftul se afla la etajul " + elevator.getFloor());
        if (elevator.isDoors()){
            System.out.println("Usile liftului sunt deschise");
        } else {
            System.out.println("Usile liftului sunt inchise");
        }

    }

    void closeDoors() throws SQLException {
        Elevator elevator = elr.findById();
        System.out.println("Usile se inchid");
        elevator.setDoors(true);
        elevator.setUsed(true);
        elr.update(elevator);
    }

    void openDoors() throws  SQLException{
        Elevator elevator = elr.findById();
        System.out.println("Usile se deschid");
        elevator.setDoors(false);
        elevator.setUsed(false);
        elr.update(elevator);
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
