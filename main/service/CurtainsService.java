package service;

import model.Curtains;
import repository.CurtainsRepository;

import java.util.Scanner;

public class CurtainsService {

    private static final Scanner scanner = new Scanner(System.in);
    CurtainsRepository crtr;

    public CurtainsService () {
        crtr = new CurtainsRepository();
    }

    public void setOpenCurtain(String room) {
        Curtains curtains = crtr.findById();
        System.out.println("Pentru a trage draperiile scrie 0/ pentru a le trage scrie 1");
        int switchCurtain = scanner.nextInt();
        switch (room) {
            case "Bathroom":
                if (switchCurtain == 0) {
                    if (!curtains.isBathroom()) {
                        System.out.println("The curtains are already drawn in the bathroom");
                    } else {
                        curtains.setBathroom(false);
                        System.out.println("The draperies are drawn in bathroom");
                    }
                } else if (switchCurtain == 1) {
                    if (curtains.isBathroom()) {
                        System.out.println("The draperies are already set aside in bathroom");
                    } else {
                        curtains.setBathroom(true);
                        System.out.println("The draperies are set aside in bathroom");
                    }
                }
                break;
            case "Bedroom":
                if (switchCurtain == 0) {
                    if (!curtains.isBedroom()) {
                        System.out.println("The curtains are already drawn in the bedroom");
                    } else {
                        curtains.setBedroom(false);
                        System.out.println("The draperies are drawn in bedroom");
                    }
                } else if (switchCurtain == 1) {
                    if (curtains.isBathroom()) {
                        System.out.println("The draperies are already set aside in bedroom");
                    } else {
                        curtains.setBedroom(true);
                        System.out.println("The draperies are set aside in bedroom");
                    }
                }
                break;
            case "Kitchen":
                if (switchCurtain == 0) {
                    if (!curtains.isKitchen()) {
                        System.out.println("The curtains are already drawn in the kitchen");
                    } else {
                        curtains.setKitchen(false);
                        System.out.println("The draperies are drawn in kitchen");
                    }
                } else if (switchCurtain == 1) {
                    if (curtains.isBathroom()) {
                        System.out.println("The draperies are already set aside in kitchen");
                    } else {
                        curtains.setKitchen(true);
                        System.out.println("The draperies are set aside in kitchen");
                    }
                }
                break;
            case "Hall":
                if (switchCurtain == 0) {
                    if (!curtains.isHall()) {
                        System.out.println("The curtains are already drawn in the hall");
                    } else {
                        curtains.setHall(false);
                        System.out.println("The draperies are drawn in hall");
                    }
                } else if (switchCurtain == 1) {
                    if (curtains.isHall()) {
                        System.out.println("The draperies are already set aside in hall");
                    } else {
                        curtains.setHall(true);
                        System.out.println("The draperies are set aside in hall");
                    }
                }
                break;
            case "LivingRoom":
                if (switchCurtain == 0) {
                    if (!curtains.isLivingRoom()) {
                        System.out.println("The curtains are already drawn in the living room");
                    } else {
                        curtains.setLivingRoom(false);
                        System.out.println("The draperies are drawn in living room");
                    }
                } else if (switchCurtain == 1) {
                    if (curtains.isLivingRoom()) {
                        System.out.println("The draperies are already set aside in living room");
                    } else {
                        curtains.setLivingRoom(true);
                        System.out.println("The draperies are set aside in living Room");
                    }
                }
                break;
            case "Dressing":
                if (switchCurtain == 0) {
                    if (!curtains.isHall()) {
                        System.out.println("The curtains are already drawn in the dressing");
                    } else {
                        curtains.setDressing(false);
                        System.out.println("Lumina se opreste in Dressing");
                    }
                } else if (switchCurtain == 1) {
                    if (curtains.isDressing()) {
                        System.out.println("Lumina este deja pornita");
                    } else {
                        curtains.setDressing(true);
                        System.out.println("Lumina se porneste in Dressing");
                    }
                }
                break;
        }
        crtr.updateCurtains(curtains);
    }
    public void LightStatus() {
        Curtains curtains = crtr.findById();
        if (curtains.isBathroom()){
            System.out.println("The drapes in the bathroom are set aside");
        } else {
            System.out.println("The curtains in the bathroom are drawn");
        }
        if (curtains.isBedroom()){
            System.out.println("The drapes in the bedroom are set aside");
        } else {
            System.out.println("The curtains in the bedroom are drawn");
        }
        if (curtains.isKitchen()){
            System.out.println("The drapes in the kitchen are set aside");
        } else {
            System.out.println("The curtains in the kitchen are drawn");
        }
        if (curtains.isHall()){
            System.out.println("The drapes in the hall are set aside");
        } else {
            System.out.println("The curtains in the hall room are drawn");
        }
        if (curtains.isLivingRoom()){
            System.out.println("The drapes in the living room are set aside");
        } else {
            System.out.println("The curtains in the living room are drawn");
        }
        if (curtains.isDressing()){
            System.out.println("The drapes in the dressing are set aside");
        } else {
            System.out.println("The curtains in the dressing are drawn");
        }
    }

}
