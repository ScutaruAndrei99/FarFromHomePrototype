package applicances;


public class TV {

    public static boolean powerTV;

    public static int maxTVChannel;

    public static int TVChannel;

    public static int getTVChannel() {
        return TVChannel;
    }

    public void setTVChannel(int TVChannel) {
        this.TVChannel = TVChannel;
    }

    public boolean getPowerTV() {

        return powerTV;
    }

    public void setPowerTV(boolean powerTV) {
        this.powerTV = powerTV;
        viewPowerTV();
    }

    public void viewPowerTV() {
        if (TV.powerTV == true) {
            System.out.println("Televizorul se deschis");
        } else {
            System.out.println("Televizorul se inchide ");
        }
    }

    public void accesTV() {

        if (getPowerTV() == true) {
            System.out.println("Televizorul este deschis");
        } else {
            System.out.println("Televizorul este inchis");
        }
    }

    public void moveChannel(int TVChannel) {
        if (TVChannel < 0 || TVChannel > maxTVChannel) {
            System.out.println("Televizorul este acum deschis pe canalul " + TVChannel);
            return;
        }
        if (getTVChannel() == TVChannel) {
            System.out.println("Televizorul este deja deschis la " + TVChannel);
        } else {
            System.out.println("Canalul tv se muta acum la " + TVChannel);
            setTVChannel(TVChannel);
        }
    }
}
