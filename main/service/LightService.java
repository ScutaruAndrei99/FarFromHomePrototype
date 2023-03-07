package service;

import model.Light;
import repository.LightRepository;

import java.util.Scanner;

public class LightService {
    LightRepository lr;
    private static final Scanner scanner = new Scanner(System.in);
    public LightService () {lr = new LightRepository();}
    public void setPowerLight(String room) {
        Light light = lr.findById();
        System.out.println("Pentru a porni lumina scrie 1/ pentru a o opri scrie 0");
        int switchPower = scanner.nextInt();
        switch (room) {
            case "Bathroom":
                if (switchPower == 0) {
                    if (!light.isBathroom()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setBathroom(false);
                        System.out.println("Lumina se opreste in Bathroom");
                    }
            } else if (switchPower == 1) {
                    if(light.isBathroom()){
                        System.out.println("Lumina este deja pornita");
                    } else {
                        light.setBathroom(true);
                        System.out.println("Lumina se porneste in Bathroom");
                    }
                }
                break;
            case "Bedroom":
                if (switchPower == 0) {
                    if (!light.isBedroom()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setBedroom(false);
                        System.out.println("Lumina se opreste in Bedroom");
                    }
                } else if (switchPower == 1) {
                        if(light.isBathroom()){
                            System.out.println("Lumina este deja pornita");
                        } else {
                            light.setBedroom(true);
                            System.out.println("Lumina se porneste in Bedroom");
                        }
                }
                break;
            case "Kitchen":
                if (switchPower == 0) {
                    if (!light.isKitchen()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setKitchen(false);
                        System.out.println("Lumina se opreste in Kitchen");
                    }
                } else if (switchPower == 1) {
                    if(light.isBathroom()){
                        System.out.println("Lumina este deja pornita");
                    } else {
                        light.setKitchen(true);
                        System.out.println("Lumina se porneste in Kitchen");
                    }
                }
                break;
            case "Hall":
                if (switchPower == 0) {
                    if(!light.isHall()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setHall(false);
                        System.out.println("Lumina se opreste in Hall");
                    }
                } else if (switchPower == 1) {
                    if(light.isHall()){
                        System.out.println("Lumina este deja pornita");
                    } else {
                        light.setHall(true);
                        System.out.println("Lumina se porneste in Hall");
                    }
                }
                break;
            case "LivingRoom":
                if (switchPower == 0) {
                    if(!light.isLivingRoom()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setLivingRoom(false);
                        System.out.println("Lumina se opreste in Living Room");
                    }
                } else if (switchPower == 1) {
                    if(light.isLivingRoom()){
                        System.out.println("Lumina este deja pornita");
                    } else {
                        light.setLivingRoom(true);
                        System.out.println("Lumina se porneste in Living Room");
                    }
                }
                break;
            case "Dressing":
                if (switchPower == 0) {
                    if(!light.isDressing()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setDressing(false);
                        System.out.println("Lumina se opreste in Dressing");
                    }
                } else if (switchPower == 1) {
                    if(light.isDressing()){
                        System.out.println("Lumina este deja pornita");
                    } else {
                        light.setDressing(true);
                        System.out.println("Lumina se porneste in Dressing");
                    }
                }
                break;
            case "Boiler":
                if (switchPower == 0) {
                    if(!light.isBoiler()){
                        System.out.println("Lumina este deja inchisa");
                    } else {
                        light.setBoiler(false);
                        System.out.println("Lumina se opreste in Boiler");
                    }
                } else if (switchPower == 1) {
                    if(light.isBoiler()){
                        System.out.println("Lumina este deja pornita");
                    } else {
                        light.setBoiler(true);
                        System.out.println("Lumina se porneste in Boiler");
                    }
                }
                break;
        }
        lr.updateLight(light);
    }
    public void LightStatus() {
        Light light = lr.findById();
        if (light.isBathroom()){
            System.out.println("Lumina in Bathroom este pornita");
        } else {
            System.out.println("Lumina in Bathroom este oprita");
        }
        if (light.isBedroom()){
            System.out.println("Lumina in Bedroom este pornita");
        } else {
            System.out.println("Lumina in Bedroom este oprita");
        }
        if (light.isKitchen()){
            System.out.println("Lumina in kitchen este pornita");
        } else {
            System.out.println("Lumina in kitchen este oprita");
        }
        if (light.isHall()){
            System.out.println("Lumina in hall este pornita");
        } else {
            System.out.println("Lumina in hall este oprita");
        }
        if (light.isLivingRoom()){
            System.out.println("Lumina in living room este pornita");
        } else {
            System.out.println("Lumina in living room este oprita");
        }
        if (light.isDressing()){
            System.out.println("Lumina in dressing este pornita");
        } else {
            System.out.println("Lumina in dressing este oprita");
        }
        if (light.isBoiler()){
            System.out.println("Lumina in boiler este pornita");
        } else {
            System.out.println("Lumina in boiler este oprita");
        }
    }
}
