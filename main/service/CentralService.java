package service;

import model.Central;
import repository.CentralRepository;

import java.util.Scanner;

public class CentralService {
    CentralRepository cr;
    private static final Scanner scanner =new Scanner(System.in);
    public CentralService () { cr = new CentralRepository(); }

    public void changeTemperature() {
        Central central = cr.findById(2);
        if(!central.isPower()){
            System.out.println("Te rog sa pornesti mai intai centrala");
        }else {
            System.out.println("Te rog sa alegi o temperatura");
            System.out.print("Noua temperatura este " );
            int switchTemperature = scanner.nextInt();
            if(switchTemperature>30||switchTemperature<0){
                System.out.println("Centrala functioneaza in parametri normali intre 0 si 30 grade");
            } else {
                central.setTemperature(switchTemperature);
                System.out.println("Se modifica temperatura");
                cr.updateCentral(central);
            }
        }
    }
    public void setPowerCentral()  {
        Central central = cr.findById(2);
        System.out.println("Pentru a porni centrala scrie 1/ pentru a o opri scrie 0");
        int switchPower=scanner.nextInt();
        if(switchPower == 0) {
            central.setPower(false);
            System.out.println("Centrala se opreste");
        } else if (switchPower == 1) {
            central.setPower(true);
            System.out.println("Centrala se porneste");
        } else{
            System.out.println("Te rog sa alegi intre 0 si 1");
        }
        cr.updateCentral(central);
    }

    public void readTemperature() {
        Central central = cr.findById(2);
        System.out.println("Temperatura din centrala este de " + central.getTemperature() +" grade Celsius" );
    }

}
