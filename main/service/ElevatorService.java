package service;

import model.Elevator;
import repository.ElevatorRepository;

import java.util.Scanner;

public class ElevatorService {
    private static final Scanner scanner=new Scanner(System.in);
    private ElevatorRepository elr;

    public ElevatorService()  { elr = new ElevatorRepository();}
    public void call() {
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
    // TODO trebuie sa pun limita la etajele la care pot sa merg cu liftul
    public void statusElevator() {
        Elevator elevator = elr.findById();
        System.out.println("Liftul se afla la etajul " + elevator.getFloor());
        if (elevator.isDoors()){
            System.out.println("Usile liftului sunt deschise");
        } else {
            System.out.println("Usile liftului sunt inchise");
        }

    }

    void closeDoors() {
        Elevator elevator = elr.findById();
        System.out.println("Usile se inchid");
        elevator.setDoors(true);
        elevator.setUsed(true);
        elr.update(elevator);
    }

    void openDoors(){
        Elevator elevator = elr.findById();
        System.out.println("Usile se deschid");
        elevator.setDoors(false);
        elevator.setUsed(false);
        elr.update(elevator);
    }


}
