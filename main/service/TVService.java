package service;

import model.Channel;
import model.TV;
import repository.TVRepository;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TVService {
    TVRepository tvr;
    private static final Scanner scanner = new Scanner(System.in);
    public TVService (TVRepository tvr) {this.tvr=tvr;}
    public void setPowerTV() throws SQLException {
        TV tv = tvr.findById(3);
        System.out.println("Pentru a porni televizorul scrie 1/ pentru al opri scrie 0");
        int switchPower=scanner.nextInt();
        if (switchPower == 0) {
            tv.setPower(false);
            System.out.println("Televizorul se inchide");
        }else if (switchPower == 1) {
            tv.setPower(true);
            System.out.println("Televizorul se porneste");
        } else {
            System.out.println("Te rog sa alegi intre 0 si 1");
        }
        tvr.updateTV(tv);
    }

    public void changeChannel() throws SQLException {
        TV tv=tvr.findById(3);

        if(!tv.isPower()){
            System.out.println("Te rog sa pornesti televizorul");
        } else {
            System.out.println("Te rog sa alegi postul pe care vrei sa te uiti");
            System.out.print("Postul pe care l-ai selectat este ");
            tv.setChannelPost(readOptionTV());
            tv.setChannelName(tvr.findByChannelPost(tv.getChannelPost()));
            tvr.updateTV(tv);
        }
    }
    public void whatIsPower() throws SQLException {
        TV tv =tvr.findById(3);
        if(tv.isPower()){
            System.out.println("Televizorul este pornit");
        } else {
            System.out.println("Televizorul este oprit");
        }
    }
    public void whatChannelIs() throws SQLException {
        TV tv = tvr.findById(3);
        if(tv.isPower()) {
            System.out.println("Televizorul este deschis pe canalul " + tv.getChannelName());
        } else {
            System.out.println("Televizorul este momentan oprit");
        }
    }

    public static int readOptionTV() {
        do {
            try {
                int optiune = scanner.nextInt();
                if (optiune > 82 || optiune < 0) {
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
