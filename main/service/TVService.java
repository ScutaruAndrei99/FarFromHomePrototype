package service;

import model.TV;
import repository.TVRepository;

import java.sql.SQLException;



public class TVService {
    TVRepository tvr;

    public TVService () {
        tvr = new TVRepository();
    }
    public void setPowerTV(int switchPower) {
        TV tv = tvr.findById(3);
        System.out.println("Pentru a porni televizorul scrie 1/ pentru al opri scrie 0");
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

    public void changeChannel(int changeChannel) {
        TV tv=tvr.findById(3);

        if(!tv.isPower()){
            System.out.println("Te rog sa pornesti televizorul");
        } else {
            System.out.println("Te rog sa alegi postul pe care vrei sa te uiti");
            System.out.print("Postul pe care l-ai selectat este ");
            if (changeChannel>82 || changeChannel <1){
                System.out.println("Televizorul are doar 82 de canale");
            } else {
                tv.setChannelPost(changeChannel);
                tv.setChannelName(tvr.findByChannelPost(tv.getChannelPost()));
                tvr.updateTV(tv);
            }
        }
    }
    public void whatIsPower() {
        TV tv =tvr.findById(3);
        if(tv.isPower()){
            System.out.println("Televizorul este pornit");
        } else {
            System.out.println("Televizorul este oprit");
        }
    }
    public void whatChannelIs() {
        TV tv = tvr.findById(3);
        if(tv.isPower()) {
            System.out.println("Televizorul este deschis pe canalul " + tv.getChannelName());
        } else {
            System.out.println("Televizorul este momentan oprit");
        }
    }
}
