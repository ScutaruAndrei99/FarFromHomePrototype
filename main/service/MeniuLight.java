package service;

import applicances.Light;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuLight {
    private static Scanner scanner=new Scanner(System.in);

    public static Light lumina=new Light();

    public void TabLight() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelLight();
            int selectedOptionLight = readOptionLight();
            processSelectedOptionLight(selectedOptionLight);
        }
    }

    private static int readOptionLight() {
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

    private void processSelectedOptionLight(int selectedOptionLight) throws SQLException, ClassNotFoundException {
        switch (selectedOptionLight){
            case 1:
                comand();
                break;
            case 2:
                lumina.accesLight();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }


    private static void tabelLight() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Vreau sa pornesc/opresc lumina");
        System.out.println("2. Vreau sa vad cum e lumina");
        System.out.println("3. Inapoi");
    }

    public void comand() {
        System.out.println("Pentru a porni lumina scrie 1, iar pentru a o opri, scrie 0");
        int usedLight = scanner.nextInt();
        if (usedLight == 1) {
            lumina.setpowerLight(true);
        } else if (usedLight == 0) {
            lumina.setpowerLight(false);
        } else {
            System.out.println("Te rog sa alegi 0-OFF sau 1-ON");
        }
    }
}
