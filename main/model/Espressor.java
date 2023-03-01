package model;

public class Espressor {
    private long idEspressor;
    private long shotCoffe;
    private long shotWater;
    private long shotMilk;

    public Espressor(long idEspressor, long MaxCoffe, long MaxWater, long MaxMilk){
        this.idEspressor =1;
        this.shotCoffe =MaxCoffe;
        this.shotWater =MaxWater;
        this.shotMilk =MaxMilk;
    }

    public long getShotCoffe() {return shotCoffe;}

    public void setShotCoffe(long shotCoffe) {this.shotCoffe = shotCoffe;}

    public long getShotWater() {return shotWater;}

    public void setShotWater(long shotWater) {this.shotWater = shotWater;}

    public long getShotMilk() {return shotMilk;}

    public void setShotMilk(long shotMilk) {this.shotMilk = shotMilk;}

    @Override
    public String toString(){
        return "Cafeaua{" + idEspressor +" mai are "+ shotCoffe + " shot-uri de cafea " + shotWater + " shot-uri de apa " + shotMilk + " shot-uri de lapte"+'}';
    }


}
