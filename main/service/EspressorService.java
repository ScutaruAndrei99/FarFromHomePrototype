package service;

import model.Espressor;
import repository.EspressorRepository;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class EspressorService {
    private EspressorRepository er;
    private volatile boolean isPreparing = false;

    public EspressorService(EspressorRepository er) {
        this.er=er;
    }

    public boolean prepareShortEspresso() throws SQLException {
        boolean success = false;
        Espressor espressor = er.findById(1);

        if(espressor.getShotCoffe()>0 && !isPreparing){
            System.out.println("Se prepara cafeaua");
            espressor.setShotCoffe(espressor.getShotCoffe()-1) ;
            er.update(espressor);
            success = true;
            isPreparing = true;
            timeEspressor(15);
        }else if (espressor.getShotCoffe()==0){
            System.out.println("Nu mai ai cafea, te rog sa faci un refill");
        }else if (isPreparing) {
            System.out.println("Se prepara deja o alta cafea");
        }
        return success;
    }

    public boolean prepareDubleEspresso() throws SQLException {
        boolean success = false;
        Espressor espressor = er.findById(1);
        if(espressor.getShotCoffe()>1 && !isPreparing){
            System.out.println("Se prepara cafeaua");
            espressor.setShotCoffe(espressor.getShotCoffe()-2) ;
            er.update(espressor);
            success = true;
            isPreparing = true;
            timeEspressor(15);
        }else if (espressor.getShotCoffe()<2) {
            System.out.println("Nu mai ai apa si cafea, te rog sa faci un refill");
        }else if (isPreparing) {
            System.out.println("Se prepara deja o alta cafea");
        }
        return success;
    }

    public boolean prepareSmallLatte() throws SQLException {
        boolean success = false;
        Espressor espressor = er.findById(1);
        if(espressor.getShotCoffe()>0 && espressor.getShotMilk()>0 && !isPreparing){
            System.out.println("Se prepara cafeaua");
            espressor.setShotCoffe(espressor.getShotCoffe()-1) ;
            espressor.setShotMilk(espressor.getShotMilk()-1);
            er.update(espressor);
            success = true;
            isPreparing = true;
            timeEspressor(15);
        }else if (espressor.getShotCoffe()==0 && espressor.getShotMilk()==0){
            System.out.println("Nu mai ai lapte si cafea, te rog sa faci un refill");
        } else if (espressor.getShotCoffe()==0 && espressor.getShotMilk()>0) {
            System.out.println("Nu mai ai cafea in expressor, te rog sa faci un refill");
        }else if(espressor.getShotCoffe()>0 && espressor.getShotMilk()==0){
            System.out.println("Nu mai ai lapte in expressor, te rog sa faci un refill");
        }else if (isPreparing) {
            System.out.println("Se prepara deja o alta cafea");
        }
        return success;
    }

    public boolean prepareBigLatte() throws SQLException {
        boolean success = false;
        Espressor espressor = er.findById(1);
        if(espressor.getShotCoffe()>1 && espressor.getShotMilk()>1 && !isPreparing){
            System.out.println("Se prepara cafeaua");
            espressor.setShotCoffe(espressor.getShotCoffe()-2) ;
            espressor.setShotMilk(espressor.getShotMilk()-2);
            er.update(espressor);
            success = true;
            isPreparing = true;
            timeEspressor(15);
        }else if (espressor.getShotCoffe()<2 && espressor.getShotMilk()<2){
            System.out.println("Nu mai ai lapte si cafea, te rog sa faci un refill");
        } else if (espressor.getShotCoffe()<2 && espressor.getShotMilk()>1) {
            System.out.println("Nu mai ai cafea in expressor, te rog sa faci un refill");
        }else if(espressor.getShotCoffe()>1 && espressor.getShotMilk()<2){
            System.out.println("Nu mai ai lapte in expressor, te rog sa faci un refill");
        }else if (isPreparing) {
            System.out.println("Se prepara deja o alta cafea");
        }
        return success;
    }

    public boolean prepareShortCoffe() throws SQLException {
        boolean success = false;
        Espressor espressor = er.findById(1);
        if(espressor.getShotCoffe()>0 && espressor.getShotWater()>0 && !isPreparing){
            System.out.println("Se prepara cafeaua");
            espressor.setShotCoffe(espressor.getShotCoffe()-1) ;
            espressor.setShotWater(espressor.getShotWater()-1);
            er.update(espressor);
            success = true;
            isPreparing = true;
            timeEspressor(15);
        }else if (espressor.getShotCoffe()==0 && espressor.getShotWater()==0){
            System.out.println("Nu mai ai apa si cafea, te rog sa faci un refill");
        } else if (espressor.getShotCoffe()==0 && espressor.getShotWater()>0) {
            System.out.println("Nu mai ai cafea in expressor, te rog sa faci un refill");
        }else if(espressor.getShotCoffe()>0 && espressor.getShotWater()==0){
            System.out.println("Nu mai ai apa in expressor, te rog sa faci un refill");
        }else if (isPreparing) {
            System.out.println("Se prepara deja o alta cafea");
        }
        return success;
    }

    public boolean prepareLongCoffe() throws SQLException {
        boolean success = false;
        Espressor espressor = er.findById(1);
        if(espressor.getShotCoffe()>1 && espressor.getShotWater()>1 && !isPreparing){
            System.out.println("Se prepara cafeaua");
            espressor.setShotCoffe(espressor.getShotCoffe()-2) ;
            espressor.setShotWater(espressor.getShotWater()-2);
            er.update(espressor);
            success = true;
            isPreparing = true;
            timeEspressor(15);
        }else if (espressor.getShotCoffe()<2 && espressor.getShotWater()<2){
            System.out.println("Nu mai ai apa si cafea, te rog sa faci un refill");
        } else if (espressor.getShotCoffe()<2 && espressor.getShotWater()>1) {
            System.out.println("Nu mai ai cafea in expressor, te rog sa faci un refill");
        }else if(espressor.getShotCoffe()>1 && espressor.getShotWater()<2){
            System.out.println("Nu mai ai apa in expressor, te rog sa faci un refill");
        }else if (isPreparing) {
            System.out.println("Se prepara deja o alta cafea");
        }
        return success;
    }

    public void timeEspressor(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000L);
    }


    class RemindTask extends TimerTask {

        @Override
        public void run() {
            isPreparing = false;
            System.out.println("Aparatul a devenit disponibil");
        }
    }
}
